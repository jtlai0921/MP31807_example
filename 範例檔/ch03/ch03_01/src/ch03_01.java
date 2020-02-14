// 建立五個學生成績的單向鏈結串列，
// 並走訪每一個節點來列印成績

import java.io.*;

public class ch03_01 
{
   public static void main(String args[]) throws IOException
   {
	BufferedReader buf;
	buf=new BufferedReader(new InputStreamReader(System.in));
	int num;
	String name;
	int score;
	
	System.out.println("請輸入5筆學生資料： ");
	LinkedList list=new LinkedList();
	for (int i=1;i<6;i++)
	{
		System.out.print("請輸入座號： ");
		num=Integer.parseInt(buf.readLine());
		System.out.print("請輸入姓名： ");
		name=buf.readLine();
		System.out.print("請輸入成績： ");
		score=Integer.parseInt(buf.readLine());
		list.insert(num,name,score);
		System.out.println("-------------");
	}
	System.out.println(" 學 生 成 績 ");
	System.out.println(" 座號  姓名 成績 ===========");
	list.print();
    }
}
