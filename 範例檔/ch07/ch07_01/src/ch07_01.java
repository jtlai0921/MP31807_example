// 無向圖形矩陣

import java.io.*;
public    class ch07_01
{
public static void main(String args[]) throws IOException

   {  
	int [][] data={{1,2},{2,1},{1,5},{5,1}, //圖形各邊的起點值及終點值
					{2,3},{3,2},{2,4},{4,2},
					{3,4},{4,3},{3,5},{5,3},
					{4,5},{5,4}};
	//宣告矩陣arr
	int arr[][] =new int[6][6];
	int i,j,k,tmpi,tmpj;            
	
	for (i=0;i<6;i++)          //把矩陣清為0
		for (j=0;j<6;j++)
			arr[i][j]=0;
	for (i=0;i<14;i++)         //讀取圖形資料
		for (j=0;j<6;j++)      //填入arr矩陣
			for (k=0;k<6;k++)
			{  
				tmpi=data[i][0];    //tmpi為起始頂點
				tmpj=data[i][1];    //tmpj為終止頂點
				arr[tmpi][tmpj]=1;  //有邊的點填入1
			}
	System.out.print("無向圖形矩陣：\n");
	for (i=1;i<6;i++)
	{  
		for (j=1;j<6;j++)
	    System.out.print("["+arr[i][j]+"] ");   //列印矩陣內容
		System.out.print("\n");
	}
   }
}
