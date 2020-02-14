// 八皇后問題

import java.io.*;
class ch04_06
{
	static int TRUE=1, FALSE=0, EIGHT=8;
	static int[] queen=new int [EIGHT]; // 存放8個皇后之列位置					
	static int number=0; //// 計算共有幾組解的總數
        //建構子
	ch04_06()
	{
		number = 0 ;
	}
	//按Enter鍵函數
	public static void PressEnter()  
	{
		char tChar;
		System.out.print("\n\n");
		System.out.println("...按下Enter鍵繼續...");
		try {
			tChar=(char)System.in.read();
		} catch(IOException e) {}
	}
        //決定皇后存放的位置
	public static void decide_position(int value)
	{
		int i=0;
		while ( i < EIGHT ) 
		{
		// 是否受到攻擊的判斷式
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
	// 測試在(row,col)上的皇后是否遭受攻擊
	// 若遭受攻擊則傳回值為1，否則傳回0
	public static int attack(int row,int col)
	{
		int i=0, atk=FALSE ;
		int offset_row=0, offset_col=0 ;

		while ( (atk!=1) && i < col ) {
			offset_col = Math.abs(i - col) ;
			offset_row = Math.abs(queen[i] - row) ;
			// 判斷兩皇后是否在同一列或在同一對角線上
			if  ((queen[i] == row)||(offset_row == offset_col) )
				atk=TRUE ;
			i++ ;
		}
		return atk ;
	}

	// 輸出所需要的結果
	public static void print_table()
	{
		int x=0, y=0;
		number+=1 ;		
		System.out.print("\n");
		System.out.print("八皇后問題的第"+number + "組解\n\t") ;
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
