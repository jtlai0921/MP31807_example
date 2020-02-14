// 多維陣列的應用
import java.util.*;
public class ch02_02
{
   public static void main(String[] args)
   {
      //變數宣告
      int intCreate=1000000;//產生亂數次數
      int intRand;          //產生的亂數號碼
      int[][] intArray=new int[2][42];//置放亂數陣列
      //將產生的亂數存放至陣列
      while(intCreate-->0)
      {
         intRand=(int)(Math.random()*42);
         intArray[0][intRand]++;
         intArray[1][intRand]++;
      }
      //對intArray[0]陣列做排序
      Arrays.sort(intArray[0]);
      //找出最大數六個數字號碼
      for(int i=41;i>(41-6);i--)
      {
         //逐一檢查次數相同者
         for(int j=41;j>=0;j--)
         {
            //當次數符合時印出
            if(intArray[0][i]==intArray[1][j])
            {
               System.out.println("亂數號碼"+(j+1)+"出現"+intArray[0][i]+"次");
               intArray[1][j]=0; //將找到的數值將次數歸零
               break;            //中斷內迴圈，繼續外迴圈
            }  
         }
      }
   }
}