// �u�ʱ����k

import java.io.*;
import java.util.*;
public    class ch09_04 extends Object
{
final static int INDEXBOX=10;   //�����̤j����
final static int MAXNUM=7;      //�̤j��ƭӼ�
public static void main(String args[]) throws IOException

   {  
	int i;
	int index[]=new int[INDEXBOX];
	int data[]=new int[MAXNUM];
	Random rand=new Random();
	System.out.print("��l�}�C�ȡG\n");
	for(i=0;i<MAXNUM;i++)       //�_�l��ƭ�
		data[i]=(Math.abs(rand.nextInt(20)))+1;
	for(i=0;i<INDEXBOX;i++)     //�M�������
		index[i]=-1;
	print_data(data,MAXNUM);    //�C�L�_�l���
	System.out.print("������e�G\n");
	for(i=0;i<MAXNUM;i++)       //�إ������
	{  
		creat_table(data[i],index);
		System.out.print("  "+data[i]+" =>");  //�C�L��@������������m
		print_data(index,INDEXBOX);
	}
	System.out.print("���������G\n");     
	print_data(index,INDEXBOX);  //�C�L�̫᧹�����G
   }
public static void print_data(int data[],int max)  //�C�L�}�C�Ƶ{��
   {  
	int i;
	System.out.print("\t");
	for(i=0;i<max;i++)
		System.out.print("["+data[i]+"] ");
	System.out.print("\n");
   }
public static void creat_table(int num,int index[])  //�إ������Ƶ{��
 {  
	int tmp;
	tmp=num%INDEXBOX;    //������=���%INDEXBOX
	while(true)
	{  
	   if(index[tmp]==-1)      //�p�G��ƹ�������m�O�Ū�
		{  
		   index[tmp]=num;     //�h�����s�J���
			break;
		}
		else
		   tmp=(tmp+1)%INDEXBOX;    //�_�h������m�s��
    } 
 }
}
