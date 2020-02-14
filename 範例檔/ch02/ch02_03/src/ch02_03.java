// т蝴皚い┮纗计い程
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
                     {90,101,89}}};//蝴皚 
      int min=num[0][0][0];//砞﹚mainnum皚材じ 
    
      for(int i=0;i<2;i++)
         for(int j=0;j<3;j++)    
            for(int k=0;k<3;k++)   
               if(min>=num[i][j][k])
                  min=num[i][j][k]; //ノ糷癹伴т程 
    
      System.out.println("程= "+min+'\n');   
   }                                  
}
