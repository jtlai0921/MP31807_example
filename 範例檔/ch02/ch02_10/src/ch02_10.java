// 將兩個最高次方相等的多項式相加後輸出結果

import java.io.*;
public    class ch02_10
{
final static int ITEMS=6;
public static void main(String args[]) throws IOException
   {  
	int [] PolyA={4,3,7,0,6,2};		//宣告多項式A
	int [] PolyB={4,1,5,2,0,9};		//宣告多項式B
	System.out.print("多項式A=> ");
	PrintPoly(PolyA,ITEMS);				//印出多項式A
	System.out.print("多項式B=> ");
	PrintPoly(PolyB,ITEMS);				//印出多項式B
	System.out.print("A+B => ");
	PolySum(PolyA,PolyB);				//多項式A+多項式B
}
public static void PrintPoly(int Poly[],int items)
{  
	int i,MaxExp;
	MaxExp=Poly[0];
	for(i=1;i<=Poly[0]+1;i++)
	{  
		MaxExp--;
		if(Poly[i]!=0)				//如果該項式0就跳過
		{  
			if((MaxExp+1)!=0)
				System.out.print(Poly[i]+"X^"+(MaxExp+1));
			else
				System.out.print(Poly[i]);
			if(MaxExp>=0)
				System.out.print('+');      
		}
	}
	System.out.println();
}
public static void PolySum(int Poly1[],int Poly2[])
{  
	int i;
	int result[]= new int [ITEMS];
	result[0] = Poly1[0];
	for(i=1;i<=Poly1[0]+1;i++)
		result[i]=Poly1[i]+Poly2[i];		//等羃的係數相加
	PrintPoly(result,ITEMS);
   }
}
