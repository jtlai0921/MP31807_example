// ��ܱƧǪk

public class ch08_03 extends Object
{
	int data[]=new int[]{9,7,5,3,4,6};
	
	public static void main(String args[])
	{
		System.out.print("��l��Ƭ��G");
		ch08_03 test=new ch08_03();		
		test.showdata ();
		test.select ();
	}
	
	void showdata ()
	{
		int i;
		for (i=0;i<6;i++)
		{
			System.out.print(data[i]+" ");
		}
		System.out.print("\n");
	}
	
	void select ()
	{
		int i,j,tmp,k;
		for(i=0;i<5;i++)    	    //���y5��
		{   
			for(j=i+1;j<6;j++)  //��i+1����_�A���5��
			{	
				if(data[i]>data[j])  //�����i�β�j�Ӥ���
				{	
					tmp=data[i];
					data[i]=data[j];
					data[j]=tmp;	
				}
			}
			System.out.print("��"+(i+1)+"���Ƨǵ��G�G");
		for (k=0;k<6;k++)
		{
			System.out.print(data[k]+" ");    //�C�L�Ƨǵ��G
		}
		System.out.print("\n");
	    }
	    System.out.print("\n");
	}
}
