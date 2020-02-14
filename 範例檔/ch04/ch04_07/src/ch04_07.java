// �N�ƾǦ��l�Ѥ��Ǫ�ܪk�ର��Ǫ�ܪk

import java.io.*;
import java.lang.String;
//�����������O�ŧi
class ch04_07 
{
	static int MAX=50;
	static char[] infix_q = new char[MAX];
        //�غc�l
	ch04_07 () 
	{
		int i=0;

		for (i=0; i<MAX; i++)
			infix_q[i]='\0';
	}    
        // �B��l�u���v������A�Y��J�B��l�p����|���B��l�A�h�Ǧ^�Ȭ�1�A�_�h��0
	public static int compare(char stack_o, char infix_o)
	{
		// �b���Ǫ�ܪk��C�μȦs���|���A�B��l���u�����Ǫ�A���u���v�Ȭ�INDEX/2
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
        //������e�Ǫ���k
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
		infix_q[rear-1] = 'q';  // ���C�[�Jq�������Ÿ�
		System.out.print("\t��Ǫ�ܪk : ");
		stack_t[top]  = 'q';  // ����|�[�J#�������Ÿ�
		for (flag = 0; flag <= rear; flag++) {		
			switch (infix_q[flag]) {
				// ��J��)�A�h��X���|���B��l�A������|����(
				case ')':
					while(stack_t[top]!='(') 			
						System.out.print(stack_t[top--]);				
					top--;
					break;
				// ��J��q�A�h�N���|���٥���X���B��l��X
				case 'q':
					while(stack_t[top]!='q')
						System.out.print(stack_t[top--]);
					break;
				// ��J���B��l�A�Y�p��TOP�b���|���ҫ��B��l�A�h�N���|�ҫ��B��l��X
				// �Y�j�󵥩�TOP�b���|���ҫ��B��l�A�h�N��J���B��l��J���|
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
				// ��J���B�⤸�A�h������X
				default :
					System.out.print(infix_q[flag]);
					break;
			}
		}
	}

	
        //�D��ƫŧi
	public static void main (String args[]) 		
	{ 
		new ch04_07();
		System.out.print("\t==========================================\n");
		System.out.print("\t���{���|�N���ন��ǹB�⦡\n");
        System.out.print("\t�п�J���ǹB�⦡\n");
        System.out.print("\t�Ҧp:(9+3)*8+7*6-12/4 \n");
        System.out.print("\t�i�H�ϥΪ��B��l�]�A:^,*,+,-,/,(,)�� \n");
        System.out.print("\t==========================================\n");
        System.out.print("\t�ж}�l��J���ǹB�⦡: ");
		ch04_07.infix_to_postfix();
        System.out.print("\t==========================================\n");
	}
}
