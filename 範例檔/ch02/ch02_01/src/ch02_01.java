// 一維陣列的應用:求質數
class ch02_01
{
  public static void main(String args[])
  {
     final int MAX=300;
     //false為質數,true為非質數
     //宣告後若沒有給定初值,其預設值為false
     boolean prime[]=new boolean[MAX];
     prime[0]=true;//0為非質數
     prime[1]=true;//1為非質數
     int num=2,i;
     //將1~MAX中不是質數者,逐一過濾掉,以此方式找到所有質數
     while(num<MAX)
     {
        if(!prime[num])
        {
            for(i=num+num;i<MAX;i+=num)
            {
               if(prime[i]) continue;
               prime[i]=true;//設定為true,代表此數為非質數
            }
         }
         num++;
     }
     //列印1~MAX間的所有質數
     System.out.println("1到"+MAX+"間的所有質數:");
     for(i=2,num=0;i<MAX;i++)
     {
         if(!prime[i])
         {
           System.out.print(i+"\t"); 
           num++;
         }
     }
     System.out.println("\n質數總數= "+num+"個");
   }
}
