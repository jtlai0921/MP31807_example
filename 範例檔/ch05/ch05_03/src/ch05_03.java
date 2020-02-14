// 實作環狀佇列資料的存入和取出

import java.io.*;
public    class ch05_03
{
public static int front=-1,rear=-1,val;
public static int queue[] =new int[5];
public static void main(String args[]) throws IOException

   {  
	String strM;
	BufferedReader keyin=new BufferedReader(new InputStreamReader(System.in));
	while(rear<5&&val!=-1)
	{  
		System.out.print("請輸入一個值以存入佇列，欲取出值請輸入0。(結束輸入-1)：");
		strM=keyin.readLine();
		val=Integer.parseInt(strM);
		if(val==0)
		{  
			if(front==rear)
			{  
				System.out.print("[佇列已經空了]\n");
				break;
			}
			front++;
			if (front==5)
				front=0;
			System.out.print("取出佇列值 ["+queue[front]+"]\n");
			queue[front]=0;
		}
		else if(val!=-1&&rear<5)
		{  
			if(rear+1==front||rear==4&&front<=0)
			{  
				System.out.print("[佇列已經滿了]\n");
				break;
			}
			rear++;
			if(rear==5)
				rear=0;
			queue[rear]=val;
		}
	}
	System.out.print("\n佇列剩餘資料：\n");
	if (front==rear)
		System.out.print("佇列已空!!\n");
	else 
	{ 
		while(front!=rear)
		{  
			front++;
			if (front==5)
				front=0;
			System.out.print("["+queue[front]+"]");
			queue[front]=0;
		}
	}
	System.out.print("\n");

   }
}
