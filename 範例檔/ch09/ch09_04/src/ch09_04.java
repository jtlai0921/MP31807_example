// 線性探測法

import java.io.*;
import java.util.*;
public    class ch09_04 extends Object
{
final static int INDEXBOX=10;   //雜湊表最大元素
final static int MAXNUM=7;      //最大資料個數
public static void main(String args[]) throws IOException

   {  
	int i;
	int index[]=new int[INDEXBOX];
	int data[]=new int[MAXNUM];
	Random rand=new Random();
	System.out.print("原始陣列值：\n");
	for(i=0;i<MAXNUM;i++)       //起始資料值
		data[i]=(Math.abs(rand.nextInt(20)))+1;
	for(i=0;i<INDEXBOX;i++)     //清除雜湊表
		index[i]=-1;
	print_data(data,MAXNUM);    //列印起始資料
	System.out.print("雜湊表內容：\n");
	for(i=0;i<MAXNUM;i++)       //建立雜湊表
	{  
		creat_table(data[i],index);
		System.out.print("  "+data[i]+" =>");  //列印單一元素的雜湊表位置
		print_data(index,INDEXBOX);
	}
	System.out.print("完成雜湊表：\n");     
	print_data(index,INDEXBOX);  //列印最後完成結果
   }
public static void print_data(int data[],int max)  //列印陣列副程式
   {  
	int i;
	System.out.print("\t");
	for(i=0;i<max;i++)
		System.out.print("["+data[i]+"] ");
	System.out.print("\n");
   }
public static void creat_table(int num,int index[])  //建立雜湊表副程式
 {  
	int tmp;
	tmp=num%INDEXBOX;    //雜湊函數=資料%INDEXBOX
	while(true)
	{  
	   if(index[tmp]==-1)      //如果資料對應的位置是空的
		{  
		   index[tmp]=num;     //則直接存入資料
			break;
		}
		else
		   tmp=(tmp+1)%INDEXBOX;    //否則往後找位置存放
    } 
 }
}
