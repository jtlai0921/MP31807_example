// 鏈結串列製作堆疊

import java.io.*;

class Node //鏈結節點的宣告
{
	int data;
	Node next;
	public Node(int data)
	{
		this.data=data;
		this.next=null;
	}
}

class StackByLink 
{
	public Node front; //指向堆疊底端的指標
	public Node rear;  //指向堆疊頂端的指標
   //類別方法：isEmpty()
   //判斷堆疊如果為空堆疊,則front==null;
	public boolean isEmpty()
	{
		return front==null;
	}
   //類別方法：output_of_Stack()
   //列印堆疊內容
	public void output_of_Stack()
	{
		Node current=front;
		while(current!=null)
		{
		System.out.print("["+current.data+"]");
		current=current.next;
		}
		System.out.println();
	}
   //類別方法：insert()
   //在堆疊頂端加入資料
	public void insert(int data)
	{
		Node newNode=new Node(data);
		if(this.isEmpty())
		{
			front=newNode;
			rear=newNode;
		}
		else
		{
			rear.next=newNode;
			rear=newNode;
		}
	}
   //類別方法：pop()
   //在堆疊頂端刪除資料
	public void pop()
	{
		Node newNode;
		if(this.isEmpty())
		{
			System.out.print("===目前為空堆疊===\n");
			return;
		}
		newNode=front;
		if(newNode==rear) 
			{
			front=null;
			rear=null;
			System.out.print("===目前為空堆疊===\n");
			}
		else
		{
			while(newNode.next!=rear) 
				newNode=newNode.next;
			newNode.next=rear.next;
			rear=newNode;
		}

	}
}

class ch04_03
{
   public static void main(String args[]) throws IOException
   {
		BufferedReader buf;
		buf=new BufferedReader(new InputStreamReader(System.in));
		StackByLink stack_by_linkedlist =new StackByLink();
		int choice=0;
                while(true)
		{
			System.out.print("(0)結束(1)在堆疊加入資料(2)彈出堆疊資料:");
			choice=Integer.parseInt(buf.readLine());		
			if(choice==2)
			{
				stack_by_linkedlist.pop();
				System.out.println("資料彈出後堆疊內容:");
				stack_by_linkedlist.output_of_Stack();
			}
			else if(choice==1)
			{
				System.out.print("請輸入要加入堆疊的資料:");
				choice=Integer.parseInt(buf.readLine());
				stack_by_linkedlist.insert(choice);
				System.out.println("資料加入後堆疊內容:");
				stack_by_linkedlist.output_of_Stack();
			}
			else if(choice==0)
				break;
			else
			{
				System.out.println("輸入錯誤!!");
			}
		}
	}
}
