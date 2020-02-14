// 先廣後深搜尋法(BFS) 

class Node {
   int x;
   Node next;
   public Node(int x) {
      this.x=x;
      this.next=null;
   }
}
class GraphLink {
   public Node first;
   public Node last;
   public boolean isEmpty() {
      return first==null;
   }
   public void print() {
      Node current=first;
      while(current!=null) {
         System.out.print("["+current.x+"]");
	 current=current.next;
      }
      System.out.println();
   }
   public void insert(int x) {
      Node newNode=new Node(x);
      if(this.isEmpty()) {
         first=newNode;
	 last=newNode;
      }
      else {
	 last.next=newNode;
	 last=newNode;
      }
   }
}

public class ch07_05 {	
   public static int run[]=new int[9];//用來記錄各頂點是否走訪過
   public static GraphLink Head[]=new GraphLink[9];	
   public final static int MAXSIZE=10; //定義佇列的最大容量	
   static int[] queue= new int[MAXSIZE];//佇列陣列的宣告
   static int front=-1; //指向佇列的前端
   static int rear=-1; //指向佇列的後端
   //佇列資料的存入
   public static void enqueue(int value) {
      if(rear>=MAXSIZE) return;
      rear++;
      queue[rear]=value;
   }
   //佇列資料的取出
   public static int dequeue() {
      if(front==rear) return -1;
      front++;
      return queue[front];
   }
   //廣度優先搜尋法
   public static void bfs(int current) {
      Node tempnode; //臨時的節點指標
      enqueue(current); //將第一個頂點存入佇列
      run[current]=1; //將走訪過的頂點設定為1
      System.out.print("["+current+"]"); //印出該走訪過的頂點
      while(front!=rear) { //判斷目前是否為空佇列
         current=dequeue(); //將頂點從佇列中取出
         tempnode=Head[current].first; //先記錄目前頂點的位置
         while(tempnode!=null) {
            if(run[tempnode.x]==0) {
               enqueue(tempnode.x);
               run[tempnode.x]=1; //記錄已走訪過
               System.out.print("["+tempnode.x+"]");
            }
	    tempnode=tempnode.next;
         }
      }
   }

   public static void main (String args[]) {
      int Data[][] =  //圖形邊線陣列宣告
      { {1,2},{2,1},{1,3},{3,1},{2,4},{4,2},{2,5},{5,2},{3,6},{6,3},
      {3,7},{7,3},{4,5},{5,4},{6,7},{7,6},{5,8},{8,5},{6,8},{8,6} };
      int DataNum;			
      int i,j;				
      System.out.println("圖形的鄰接串列內容："); //列印圖形的鄰接串列內容
      for( i=1 ; i<9 ; i++ ) { //共有八個頂點
	 run[i]=0; //設定所有頂點成尚未走訪過
	 Head[i]=new GraphLink();	
	 System.out.print("頂點"+i+"=>");
	 for( j=0 ; j<20 ;j++) {
	    if(Data[j][0]==i) { //如果起點和串列首相等，則把頂點加入串列
	       DataNum = Data[j][1];
	       Head[i].insert(DataNum);
	    }
	 }
	 Head[i].print();  //列印圖形的鄰接串列內容
      }		
      System.out.println("廣度優先走訪頂點：");   //列印廣度優先走訪的頂點
      bfs(1);
      System.out.println("");
   }
}
