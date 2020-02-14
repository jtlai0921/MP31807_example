// 運算兩個矩陣相乘的結果

import java.io.*;
public    class ch02_05
{
public static void main(String args[]) throws IOException

{
	int M,N,P;
	int i,j;
	String strM;
	String strN;
	String strP;
	String tempstr;
	BufferedReader keyin=new BufferedReader(new InputStreamReader(System.in));
	System.out.println("請輸入矩陣A的維數(M,N): ");
	System.out.print("請先輸入矩陣A的M值: ");
	strM=keyin.readLine();
	M=Integer.parseInt(strM);
	System.out.print("接著輸入矩陣A的N值: ");
	strN=keyin.readLine();
	N=Integer.parseInt(strN);
	int A[][]=new int[M][N];
	System.out.println("[請輸入矩陣A的各個元素]");
	System.out.println("注意！每輸入一個值按下Enter鍵確認輸入");
	for(i=0;i<M;i++)
		for(j=0;j<N;j++)
			{
			System.out.print("a"+i+j+"=");
			tempstr=keyin.readLine();
			A[i][j]=Integer.parseInt(tempstr);
			}
	System.out.println("請輸入矩陣B的維數(N,P): ");
	System.out.print("請先輸入矩陣B的N值: ");
	strN=keyin.readLine();
	N=Integer.parseInt(strN);
	System.out.print("接著輸入矩陣B的P值: ");
	strP=keyin.readLine();
	P=Integer.parseInt(strP);
	int B[][]=new int[N][P];
	System.out.println("[請輸入矩陣B的各個元素]");
	System.out.println("注意！每輸入一個值按下Enter鍵確認輸入");
	for(i=0;i<N;i++)
		for(j=0;j<P;j++)
			{
			System.out.print("b"+i+j+"=");
			tempstr=keyin.readLine();
			B[i][j]=Integer.parseInt(tempstr);
			}
	int C[][]=new int[M][P];
	MatrixMultiply(A,B,C,M,N,P);
	System.out.println("[AxB的結果是]");
	for(i=0;i<M;i++)
	{
		for(j=0;j<P;j++)
			{
			System.out.print(C[i][j]);
			System.out.print('\t');
			}
		System.out.println();
	}
}
public static void MatrixMultiply(int arrA[][],int arrB[][],int arrC[][],int M,int N,int P)
{
	int i,j,k,Temp;
	if(M<=0||N<=0||P<=0)
	{
		System.out.println("[錯誤:維數M,N,P必須大於0]");
		return;
	}
	for(i=0;i<M;i++)
		for(j=0;j<P;j++)
		{
			Temp = 0;
			for(k=0;k<N;k++)
				Temp = Temp + arrA[i][k]*arrB[k][j];
			arrC[i][j] = Temp;
		}
}
}