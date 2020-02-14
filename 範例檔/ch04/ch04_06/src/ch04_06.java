// �K�ӦZ���D

import java.io.*;
class ch04_06
{
	static int TRUE=1, FALSE=0, EIGHT=8;
	static int[] queen=new int [EIGHT]; // �s��8�ӬӦZ���C��m					
	static int number=0; //// �p��@���X�ոѪ��`��
        //�غc�l
	ch04_06()
	{
		number = 0 ;
	}
	//��Enter����
	public static void PressEnter()  
	{
		char tChar;
		System.out.print("\n\n");
		System.out.println("...���UEnter���~��...");
		try {
			tChar=(char)System.in.read();
		} catch(IOException e) {}
	}
        //�M�w�ӦZ�s�񪺦�m
	public static void decide_position(int value)
	{
		int i=0;
		while ( i < EIGHT ) 
		{
		// �O�_����������P�_��
			if ( attack(i, value) !=1) 
			{       
				queen[value] = i ; 
				if ( value == 7 )
					print_table() ; 
				else
					decide_position(value+1) ;  
			}
			i++ ;
		}
	}
	// ���զb(row,col)�W���ӦZ�O�_�D������
	// �Y�D�������h�Ǧ^�Ȭ�1�A�_�h�Ǧ^0
	public static int attack(int row,int col)
	{
		int i=0, atk=FALSE ;
		int offset_row=0, offset_col=0 ;

		while ( (atk!=1) && i < col ) {
			offset_col = Math.abs(i - col) ;
			offset_row = Math.abs(queen[i] - row) ;
			// �P�_��ӦZ�O�_�b�P�@�C�Φb�P�@�﨤�u�W
			if  ((queen[i] == row)||(offset_row == offset_col) )
				atk=TRUE ;
			i++ ;
		}
		return atk ;
	}

	// ��X�һݭn�����G
	public static void print_table()
	{
		int x=0, y=0;
		number+=1 ;		
		System.out.print("\n");
		System.out.print("�K�ӦZ���D����"+number + "�ո�\n\t") ;
		for ( x = 0 ; x < EIGHT ; x++ ) {			
			for ( y =0 ; y< EIGHT ;y++ )
				if ( x == queen[y] )
					System.out.print("<*>") ;
				else
					System.out.print("<->") ;
			System.out.print("\n\t") ;	
		}      
		PressEnter();
	}
	public static void main (String args[])  		
	{
		ch04_06.decide_position(0) ;	
	}
}
