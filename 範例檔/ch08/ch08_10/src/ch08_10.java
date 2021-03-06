// 完整合併排序法
// 資料檔名：datafile.txt
// 合併後檔案：sortdata.txt

import java.io.*;
public class ch08_10
{	
	public static void main (String args[])throws Exception 
	{
		String filep="datafile.txt";
		String filep1="sort1.txt";
		String filep2="sort2.txt";
		String filepa="sortdata.txt";
		File fp=new File(filep);	//宣告檔案指標
		File fp1=new File(filep1);	
		File fp2=new File(filep2);	
		File fpa=new File(filepa);	
		if(!fp.exists())		//檔案是否開啟成功
			System.out.print("開啟資料檔失敗\n");
		else if(!fp1.exists())
			System.out.print("開啟分割檔 1 失敗\n");	
		else if(!fp2.exists())		
			System.out.print("開啟分割檔 2 失敗\n");
		else if(!fpa.exists())		
			System.out.print("開啟合併檔失敗\n");
		else
		{  
			System.out.print("檔案分割中......\n");
	        me(fp,fp1,fp2,fpa);
			System.out.print("資料排序中......\n");
			System.out.print("資料處理完成!!\n");
		}

		System.out.print("原始檔datafile.txt資料內容為：\n");
		showdata(fp);
		System.out.print("\n分割檔sort1.txt資料內容為：\n");
		showdata(fp1);
		System.out.print("\n分割檔sort2.txt資料內容為：\n");
		showdata(fp2);
		System.out.print("\n排序後sortdata.txt資料內容為：\n");
		showdata(fpa);
	}
	
	public static void showdata(File p)throws Exception 
	{  
		char str;
		int str1;
		BufferedReader pfile=new BufferedReader(new FileReader(p)); 
		while (true)
		{  
			str1=pfile.read();		
			str=(char)str1;		
			if(str1==-1)
				 break;
			System.out.print("["+str+"]");	
		}
		System.out.print("\n");
	}

	public static void me(File p, File p1, File p2, File pa)throws Exception 
	{  
		char str1,str2;
		int n1=0,n2,n;	
		BufferedReader pfile3=new BufferedReader(new FileReader(p)); 
		BufferedWriter pfile1=new BufferedWriter(new FileWriter(p1)); 		
		BufferedWriter pfile2=new BufferedWriter(new FileWriter(p2)); 	
		BufferedWriter pfilea=new BufferedWriter(new FileWriter(pa)); 	
		while(true)
		{
			n2=pfile3.read();
			if(n2==-1)
				break;
			n1++;
		}
		pfile3.close();
		BufferedReader pfile=new BufferedReader(new FileReader(p)); 
		for(n2=0;n2<(n1/2);n2++)
		{
			str1=(char)pfile.read();
			pfile1.write(str1);
		}
		pfile1.close();
		bubble(p1,n2);
		while(true)
		{
			n=pfile.read();
			str2=(char)n;
			if(n==-1)
				break;
			pfile2.write(str2);
		}
		pfile2.close();
		bubble(p2,n1/2);
		pfilea.close();		
		merge(pa,p1,p2);
		pfile.close();		//關閉檔案
	}
	
	public static void bubble(File p1, int size)throws Exception 
	{  
		char str1;
		int data[]=new int[100];
		int i,j,tmp,flag,ii;	
		BufferedReader pfile=new BufferedReader(new FileReader(p1)); 
		for(i=0;i<size;i++)
		{
			ii=pfile.read();
			if(ii==-1)
				break;			
			data[i]=ii;
		}
		pfile.close();		//關閉檔案
		BufferedWriter pfile1=new BufferedWriter(new FileWriter(p1)); 		
		for(i=size;i>0;i--)
		{
			flag=0;
			for(j=0;j<i;j++)
			{
				if(data[j+1]<data[j])
				{
					tmp=data[j];
					data[j]=data[j+1];
					data[j+1]=tmp;
					flag++;
				}
			}
			if(flag==0)
				break;
		}
		for(i=1;i<=size;i++)
		{
			str1=(char)data[i];
			pfile1.write(str1);
		}
		pfile1.close();		//關閉檔案
	}

	public static void merge(File p, File p1, File p2)throws Exception 
	{  
		char str1,str2;
		int n1,n2;	//宣告變數n1，n2暫存資料檔data1及data2內的元素值
		BufferedWriter pfile=new BufferedWriter(new FileWriter(p)); 
		BufferedReader pfile1=new BufferedReader(new FileReader(p1)); 		
		BufferedReader pfile2=new BufferedReader(new FileReader(p2)); 	
		n1=pfile1.read();	
		n2=pfile2.read();
		while(n1!=-1 && n2!=-1)		//判斷是否已到檔尾
		{  
			if (n1 <= n2)
			{  
				str1=(char)n1;
				pfile.write(str1);	//如果n1比較小，則把n1存到fp裡
				n1=pfile1.read();	//接著讀下一筆 n1 的資料
			}
			else
			{  
				str2=(char)n2;
				pfile.write(str2);	//如果n1比較小，則把n1存到fp裡
	            n2=pfile2.read();	                //接著讀下一筆 n2的資料
			}
		}
		if(n2!=-1)	//如果其中一個資料檔已讀取完畢，經判斷後
		{ 		//把另一個資料檔內的資料全部放到fp裡
			while (true)
			{  
				if(n2==-1)
					 break;
				str2=(char)n2;
				pfile.write(str2);	
				n2=pfile2.read();		
			}
		}
		else if (n1!=-1)
		{ 
			while (true)
			{  
				if(n1==-1)
					 break;
				str1=(char)n1;
				pfile.write(str1);	
				n1=pfile1.read();		
			}
		}	
		pfile.close();
		pfile1.close();
		pfile2.close();
	}
}
