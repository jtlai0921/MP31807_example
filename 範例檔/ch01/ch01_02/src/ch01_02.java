// ���|������-�O��ż�
import java.io.*;
class ch01_02
{
   public static void main(String args[]) throws IOException    
   {
      int num;
      String str;
      BufferedReader buf;
      buf=new BufferedReader(new InputStreamReader(System.in));
      System.out.print("�ϥλ��j�p��O��ż�\n");
      System.out.print("�п�J�@�Ӿ��:");
      str=buf.readLine();
      num=Integer.parseInt(str);
      if (num<0)
         System.out.print("��J�Ʀr�����j��0\n");
      else
         System.out.print("Fibonacci("+num+")="+Fibonacci(num)+"\n") ; 
   }
   public static int Fibonacci(int n)
   {  
      if (n==0)      // ��0���� 0
         return (0) ;
      else if (n==1) // ��1���� 1
         return (1) ;
      else
         return( Fibonacci(n-1)+Fibonacci(n-2));
      // ���j�I�s��� ��N����n-1 �� n-2�����M
   }
}