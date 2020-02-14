// 堆疊的應用-費氏級數
import java.io.*;
class ch01_02
{
   public static void main(String args[]) throws IOException    
   {
      int num;
      String str;
      BufferedReader buf;
      buf=new BufferedReader(new InputStreamReader(System.in));
      System.out.print("使用遞迴計算費氏級數\n");
      System.out.print("請輸入一個整數:");
      str=buf.readLine();
      num=Integer.parseInt(str);
      if (num<0)
         System.out.print("輸入數字必須大於0\n");
      else
         System.out.print("Fibonacci("+num+")="+Fibonacci(num)+"\n") ; 
   }
   public static int Fibonacci(int n)
   {  
      if (n==0)      // 第0項為 0
         return (0) ;
      else if (n==1) // 第1項為 1
         return (1) ;
      else
         return( Fibonacci(n-1)+Fibonacci(n-2));
      // 遞迴呼叫函數 第N項為n-1 跟 n-2項之和
   }
}