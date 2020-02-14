// 利用河內塔函數求出不同盤子數的盤子移動步驟

import java.io.*;
public    class ch04_04
{
public static void main(String args[]) throws IOException  
	{  
	int j;
	String str;
	BufferedReader keyin=new BufferedReader(new InputStreamReader(System.in));
	System.out.print("請輸入盤子數量： ");
	str=keyin.readLine();
	j=Integer.parseInt(str);
	hanoi(j,1, 2, 3);
	}
public static void hanoi(int n, int p1, int p2, int p3)
	{  
	if (n==1)
		System.out.println("盤子從 "+p1+" 移到 "+p3);
	else
		{  
		hanoi(n-1, p1, p3, p2);
		System.out.println("盤子從 "+p1+" 移到 "+p3);
		hanoi(n-1, p2, p1, p3);
		}
	}
}
