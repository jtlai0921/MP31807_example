// 內插搜尋法

import java.io.*;
public    class ch09_03
{
public static void main(String args[]) throws IOException
   {  
	int i,j,val=1,num;
	int data[]=new int[50];
	String strM;
	BufferedReader keyin=new BufferedReader(new InputStreamReader(System.in));
	for (i=0;i<50;i++)
	{  
		data[i]=val;
		val+=((int)(Math.random()*100)%5+1);
		
	}
	while(true)
	{  
		num=0;
		System.out.print("請輸入搜尋鍵值(1-"+data[49]+")，輸入-1結束：");
		strM=keyin.readLine();
		val=Integer.parseInt(strM);
		if(val==-1)
			break;
		num=interpolation(data,val);
		if(num==-1)
			System.out.print("##### 沒有找到["+val+"] #####\n");
		else
			System.out.print("在第 "+(num+1)+"個位置找到 ["+data[num]+"]\n");
	}
	System.out.print("資料內容：\n");
	for(i=0;i<5;i++)
	{ 
		for(j=0;j<10;j++)
			System.out.print((i*10+j+1)+"-"+data[i*10+j]+" ");
		System.out.print("\n");
	}
   }
public static int interpolation(int data[],int val)
   {  
	int low,mid,high;
	low=0;
	high=49;
	int tmp;
	System.out.print("搜尋處理中......\n");
	while(low<= high && val !=-1 )
	{  
		tmp=(int)((float)(val-data[low])*(high-low)/(data[high]-data[low]));
		mid=low+tmp; 		//內插法公式
		if (mid>50 || mid<-1)
			return -1;
		if (val<data[low] && val<data[high])
			return -1;
		else if (val>data[low] && val>data[high])
			return-1;
		if (val==data[mid])
			return mid;
		else if (val < data[mid])
		{  
			System.out.print(val+" 介於位置 "+(low+1)+"["+data[low]+"]及中間值 "+(mid+1)+"["+data[mid]+"]，找左半邊\n");
				high=mid-1;	
		}
		else if(val > data[mid])
		{  
			System.out.print(val+" 介於中間值位置 "+(mid+1)+"["+data[mid]+"]及 "+(high+1)+"["+data[high]+"]，找右半邊\n");
				low=mid+1;  
		}
	}
	return -1;
   }
}
