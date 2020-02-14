// 將數學式子由中序表示法轉為後序表示法

import java.io.*;
import java.lang.String;
//中序轉後序類別宣告
class ch04_07 
{
	static int MAX=50;
	static char[] infix_q = new char[MAX];
        //建構子
	ch04_07 () 
	{
		int i=0;

		for (i=0; i<MAX; i++)
			infix_q[i]='\0';
	}    
        // 運算子優先權的比較，若輸入運算子小於堆疊中運算子，則傳回值為1，否則為0
	public static int compare(char stack_o, char infix_o)
	{
		// 在中序表示法佇列及暫存堆疊中，運算子的優先順序表，其優先權值為INDEX/2
		char[] infix_priority = new char[9] ; 
		char[] stack_priority = new char[8] ;
		int index_s=0, index_i=0;

		infix_priority[0]='q';infix_priority[1]=')';
		infix_priority[2]='+';infix_priority[3]='-';
		infix_priority[4]='*';infix_priority[5]='/';
		infix_priority[6]='^';infix_priority[7]=' ';
		infix_priority[8]='(';      

		stack_priority[0]='q';stack_priority[1]='(';
		stack_priority[2]='+';stack_priority[3]='-';
		stack_priority[4]='*';stack_priority[5]='/';
		stack_priority[6]='^';stack_priority[7]=' ';

		while (stack_priority[index_s] != stack_o)
			index_s++;
		while (infix_priority[index_i] != infix_o)
			index_i++;
		return ((int)(index_s/2) >= (int)(index_i/2) ? 1 : 0);
	}
        //中序轉前序的方法
	public static void infix_to_postfix()
	{
		new DataInputStream(System.in);
		int rear=0, top=0, flag=0,i=0;
		char[] stack_t = new char[MAX];  

		for (i=0; i<MAX; i++)
			stack_t[i]='\0';

		while (infix_q[rear] !='\n')  {		
			System.out.flush();
			try {
				infix_q[++rear] = (char)System.in.read();
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		infix_q[rear-1] = 'q';  // 於佇列加入q為結束符號
		System.out.print("\t後序表示法 : ");
		stack_t[top]  = 'q';  // 於堆疊加入#為結束符號
		for (flag = 0; flag <= rear; flag++) {		
			switch (infix_q[flag]) {
				// 輸入為)，則輸出堆疊內運算子，直到堆疊內為(
				case ')':
					while(stack_t[top]!='(') 			
						System.out.print(stack_t[top--]);				
					top--;
					break;
				// 輸入為q，則將堆疊內還未輸出的運算子輸出
				case 'q':
					while(stack_t[top]!='q')
						System.out.print(stack_t[top--]);
					break;
				// 輸入為運算子，若小於TOP在堆疊中所指運算子，則將堆疊所指運算子輸出
				// 若大於等於TOP在堆疊中所指運算子，則將輸入之運算子放入堆疊
				case '(':
				case '^':
				case '*':
				case '/':
				case '+':
				case '-': 
					while (compare(stack_t[top], infix_q[flag])==1)                       
						System.out.print(stack_t[top--]);			
					stack_t[++top] = infix_q[flag];
					break;
				// 輸入為運算元，則直接輸出
				default :
					System.out.print(infix_q[flag]);
					break;
			}
		}
	}

	
        //主函數宣告
	public static void main (String args[]) 		
	{ 
		new ch04_07();
		System.out.print("\t==========================================\n");
		System.out.print("\t本程式會將其轉成後序運算式\n");
        System.out.print("\t請輸入中序運算式\n");
        System.out.print("\t例如:(9+3)*8+7*6-12/4 \n");
        System.out.print("\t可以使用的運算子包括:^,*,+,-,/,(,)等 \n");
        System.out.print("\t==========================================\n");
        System.out.print("\t請開始輸入中序運算式: ");
		ch04_07.infix_to_postfix();
        System.out.print("\t==========================================\n");
	}
}
