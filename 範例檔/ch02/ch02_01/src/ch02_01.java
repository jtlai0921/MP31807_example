// �@���}�C������:�D���
class ch02_01
{
  public static void main(String args[])
  {
     final int MAX=300;
     //false�����,true���D���
     //�ŧi��Y�S�����w���,��w�]�Ȭ�false
     boolean prime[]=new boolean[MAX];
     prime[0]=true;//0���D���
     prime[1]=true;//1���D���
     int num=2,i;
     //�N1~MAX�����O��ƪ�,�v�@�L�o��,�H���覡���Ҧ����
     while(num<MAX)
     {
        if(!prime[num])
        {
            for(i=num+num;i<MAX;i+=num)
            {
               if(prime[i]) continue;
               prime[i]=true;//�]�w��true,�N���Ƭ��D���
            }
         }
         num++;
     }
     //�C�L1~MAX�����Ҧ����
     System.out.println("1��"+MAX+"�����Ҧ����:");
     for(i=2,num=0;i<MAX;i++)
     {
         if(!prime[i])
         {
           System.out.print(i+"\t"); 
           num++;
         }
     }
     System.out.println("\n����`��= "+num+"��");
   }
}
