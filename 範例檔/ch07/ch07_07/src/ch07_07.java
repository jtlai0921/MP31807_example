//  Dijkstra演算法(單點對全部頂點的最短路徑) 

// 圖形的相鄰矩陣類別宣告
class Adjacency { 
   final int INFINITE = 99999;        
   public int[][] Graph_Matrix;         
   // 建構子
   public Adjacency(int[][] Weight_Path,int number) {
      int i, j;      
      int Start_Point, End_Point;            
      Graph_Matrix = new int[number][number]; 
      for ( i = 1; i < number; i++ )
         for ( j = 1; j < number; j++ )
            if ( i != j )
               Graph_Matrix[i][j] = INFINITE;     
            else
               Graph_Matrix[i][j] = 0;            
         for ( i = 0; i < Weight_Path.length; i++ ) { 
            Start_Point = Weight_Path[i][0];           
            End_Point = Weight_Path[i][1];             
            Graph_Matrix[Start_Point][End_Point] = Weight_Path[i][2];
         }
   }
   // 顯示圖形的方法
   public void printGraph_Matrix() {
      for ( int i = 1; i < Graph_Matrix.length; i++ ) {
         for ( int j = 1; j < Graph_Matrix[i].length; j++ )
            if ( Graph_Matrix[i][j] == INFINITE )
               System.out.print(" x ");
            else {  
                 if ( Graph_Matrix[i][j] == 0 ) System.out.print(" ");
                 System.out.print(Graph_Matrix[i][j] + " ");
            } 
            System.out.println();
      }
   }
}

// Dijkstra演算法類別
class Dijkstra extends Adjacency {
   private int[] cost;       
   private int[] selected;  
   // 建構子
   public Dijkstra(int[][] Weight_Path,int number) {
      super(Weight_Path,number);
      cost = new int[number];          
      selected = new int[number];
      for ( int i = 1; i < number; i++ )  selected[i] = 0;
   }
   // 單點對全部頂點最短距離
   public void shortestPath(int source) {
      int shortest_distance;                   
      int shortest_vertex= 1;                 
      int i,j;
      for ( i = 1; i < Graph_Matrix.length; i++ )
         cost[i] = Graph_Matrix[source][i]; 
      selected[source] = 1;          
      cost[source] = 0;              
      for ( i = 1; i < Graph_Matrix.length-1; i++ ) {
         shortest_distance = INFINITE;            
         for ( j = 1; j < Graph_Matrix.length; j++ )
            if ( shortest_distance>cost[j] && selected[j]==0 ) {
               shortest_vertex= j;            
               shortest_distance = cost[j];    
            }
         selected[shortest_vertex] = 1;        
         for ( j = 1; j < Graph_Matrix.length; j++ ) {
           if ( selected[j] == 0 &&
               cost[shortest_vertex]+Graph_Matrix[shortest_vertex][j] < cost[j]) {
             cost[j] = cost[shortest_vertex] + Graph_Matrix[shortest_vertex][j];
           }
         }
      }
      System.out.println("==================================");
      System.out.println("頂點1到各頂點最短距離的最終結果");
      System.out.println("==================================");
      for (j=1;j<Graph_Matrix.length;j++) 
         System.out.println("頂點1到頂點"+j+"的最短距離= "+cost[j]);
   }

}
// 主類別
public class ch07_07 {
   // 主程式
   public static void main(String[] args) {
      int Weight_Path[][] = { {1, 2, 10},{2, 3, 20}, 
                       {2, 4, 25},{3, 5, 18},
                       {4, 5, 22},{4, 6, 95},{5, 6, 77} };
      Dijkstra object=new Dijkstra(Weight_Path,7);  
      System.out.println("==========================");
      System.out.println("此範例圖形的相鄰矩陣如下: ");
      System.out.println("==========================");
      object.printGraph_Matrix();  
      object.shortestPath(1);     
   }
}
