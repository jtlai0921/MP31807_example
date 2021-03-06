// 快速排序法

import java.io.*;
import java.util.*;

public class ch08_06 extends Object
{
	int process = 0;
	int size;
	int data[]=new int[100];
	
	public static void main(String args[])
	{
		ch08_06 test = new ch08_06();
		
		System.out.print("請輸入陣列大小(100以下)：");
		try{			
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			test.size=Integer.parseInt(br.readLine());
		}catch(Exception e){}		
		
		test.inputarr ();
		System.out.print("原始資料是：");		
		test.showdata ();
		
		test.quick(test.data,test.size,0,test.size-1);
		System.out.print("\n排序結果：");
		test.showdata();
	}	
	
	void inputarr()
	{
		//以亂數輸入
		Random rand=new Random();
		int i;
		for (i=0;i<size;i++)
			data[i]=(Math.abs(rand.nextInt(99)))+1;		
	}
	
	void showdata()
	{  
		int i;
		for (i=0;i<size;i++)
			System.out.print(data[i]+" ");		
		System.out.print("\n");
	}

	void quick(int d[],int size,int lf,int rg)
	{
		int i,j,tmp;		
		int lf_idx;
		int rg_idx;
		int t;
                                         //1:第一筆鍵值為d[lf]
		if(lf<rg)
		{
			lf_idx=lf+1;
			rg_idx=rg;
			
			//排序
			while(true)
			{			
				System.out.print("[處理過程"+(process++)+"]=> ");
				for(t=0;t<size;t++)
					System.out.print("["+d[t]+"] ");									
				
				System.out.print("\n");
			
				for(i=lf+1;i<=rg;i++)  //2:由左向右找出一個鍵值大於d[lf]者
				{		
					if(d[i]>=d[lf])
					{
						lf_idx=i;
						break;
					}
					lf_idx++;
				}
			
				for(j=rg;j>=lf+1;j--)   //3:由右向左找出一個鍵值小於d[lf]者
				{			
					if(d[j]<=d[lf]) 
					{
						rg_idx=j;
						break;
					}
					rg_idx--;
				}
			
				if(lf_idx<rg_idx)        //4-1:若lf_idx<rg_idx
				{								
					tmp = d[lf_idx];
					d[lf_idx] = d[rg_idx]; //則d[lf_idx]和d[rg_idx]互換
					d[rg_idx] = tmp;       //然後繼續排序	
				}else{
					break;		       //否則跳出排序過程
				}
			}
			
			//整理
			if(lf_idx>=rg_idx)              //5-1:若lf_idx大於等於rg_idx
			{                               //則將d[lf]和d[rg_idx]互換
				tmp = d[lf];
				d[lf] = d[rg_idx];
				d[rg_idx] = tmp;
				   //5-2:並以rg_idx為基準點分成左右兩半
				quick(d,size,lf,rg_idx-1); //以遞迴方式分別為左右兩半進行排序
				quick(d,size,rg_idx+1,rg); //直至完成排序
			}
		}
	}
}
