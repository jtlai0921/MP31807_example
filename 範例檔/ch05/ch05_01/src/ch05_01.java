// 實作佇列資料的存入和取出

import java.io.*;
public class ch05_01
{
	public static int front=-1,rear=-1,max=20;
	public static int val;
	public static char ch;
	public static int queue[]=new int[max];
	public static void main(String args[]) throws IOException
   {
	String strM;
	int M=0;
	BufferedReader keyin=new BufferedReader(new InputStreamReader(System.in));
	while(rear<max-1&& M!=3)
	{  
		System.out.print("[1]存入一個數值[2]取出一個數值[3]結束: ");
		strM=keyin.readLine();
		M=Integer.parseInt(strM);
		switch(M)
		  {
			case 1:
				System.out.print("\n[請輸入數值]: ");
				strM=keyin.readLine();
				val=Integer.parseInt(strM);
				rear++;
				queue[rear]=val;
				break;
			case 2:
				if(rear>front)
				{  
					front++;
					System.out.print("\n[取出數值為]: ["+queue[front]+"]"+"\n");
					queue[front]=0;
				}
				else
				{  
					System.out.print("\n[佇列已經空了]\n");
					break;
				}
				break;
			default:
				System.out.print("\n");
				break;
		  }
	}
	if(rear==max-1) System.out.print("[佇列已經滿了]\n");
	System.out.print("\n[目前佇列中的資料]:");
	if (front>=rear)
	{
		System.out.print("沒有\n");
		System.out.print("[佇列已經空了]\n");
	}
	else
	{
		while (rear>front)
		{  
			front++;
			System.out.print("["+queue[front]+"]");
		}
		System.out.print("\n");
		}
   }

}
