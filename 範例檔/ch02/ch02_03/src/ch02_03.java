// 找出三維陣列中所儲存數值中的最小值
import java.io.*;
class ch02_03
{
   public static void main(String[] args)
   {
      int num[][][]={{{33,45,67},
                     {23,71,56},
                     {55,38,66}},
                     {{21,9,15 },
                     {38,69,18},
                     {90,101,89}}};//宣告三維陣列 
      int min=num[0][0][0];//設定main為num陣列的第一個元素 
    
      for(int i=0;i<2;i++)
         for(int j=0;j<3;j++)    
            for(int k=0;k<3;k++)   
               if(min>=num[i][j][k])
                  min=num[i][j][k]; //利用三層迴圈找出最小值 
    
      System.out.println("最小值= "+min+'\n');   
   }                                  
}
