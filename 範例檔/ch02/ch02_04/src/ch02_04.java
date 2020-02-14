// 程式目的： 兩個矩陣相加的運算

import java.io.*;
public    class ch02_04
{
public static void MatrixAdd(int arrA[][],int arrB[][],int arrC[][],int dimX,int dimY)
{
	int row,col;
	if(dimX<=0||dimY<=0)
	{
		System.out.println("矩陣維數必須大於0");
		return;
	}
	for(row=1;row<=dimX;row++)
		{
		for(col=1;col<=dimY;col++)
			{
			arrC[(row-1)][(col-1)]=arrA[(row-1)][(col-1)]+arrB[(row-1)][(col-1)];
			}
		}
}
public static void main(String args[]) throws IOException

{
	int i;
	int j;
	final int ROWS = 3;
	final int COLS =3;
	int [][] A= {{1,3,5},
						{7,9,11},
						{13,15,17}};
	int [][] B= {{9,8,7},
						{6,5,4},
						{3,2,1}};
	int [][] C= new int[ROWS][COLS];
		System.out.println("[矩陣A的各個元素]");  //印出矩陣A的內容
	for(i=0;i<3;i++)
	{
		for(j=0;j<3;j++)
		System.out.print(A[i][j]+" \t");
		System.out.println();
	}
	System.out.println("[矩陣B的各個元素]");	  //印出矩陣B的內容
	for(i=0;i<3;i++)
	{
		for(j=0;j<3;j++)
		System.out.print(B[i][j]+" \t");
		System.out.println();
	}
	MatrixAdd(A,B,C,3,3);
	System.out.println("[顯示矩陣A和矩陣B相加的結果]");	//印出A+B的內容
	for(i=0;i<3;i++)
	{
		for(j=0;j<3;j++)
		System.out.print(C[i][j]+" \t");
		System.out.println();
	}
}
}