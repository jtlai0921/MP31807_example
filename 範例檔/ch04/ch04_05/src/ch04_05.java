// �ѹ����g�c

import java.io.*;
public    class ch04_05
{
public static int ExitX= 8;			//�w�q�X�f��X�y�Цb�ĤK�C
public static int ExitY= 10;			//�w�q�X�f��Y�y�Цb�ĤQ��
public static int [][] MAZE= {{1,1,1,1,1,1,1,1,1,1,1,1},	//�ŧi�g�c�}�C
			  {1,0,0,0,1,1,1,1,1,1,1,1},
				  {1,1,1,0,1,1,0,0,0,0,1,1},
				  {1,1,1,0,1,1,0,1,1,0,1,1},
				  {1,1,1,0,0,0,0,1,1,0,1,1},					
                                  {1,1,1,0,1,1,0,1,1,0,1,1},
				  {1,1,1,0,1,1,0,1,1,0,1,1},
				  {1,1,1,1,1,1,0,1,1,0,1,1},
			          {1,1,0,0,0,0,0,0,1,0,0,1},
			          {1,1,1,1,1,1,1,1,1,1,1,1}};
public static void main(String args[]) throws IOException
   {
	int i,j,x,y;
	TraceRecord path=new TraceRecord();
	x=1;	
	y=1;   
	System.out.print("[�g�c�����|(0������)]\n"); 
	for(i=0;i<10;i++)
	{
		for(j=0;j<12;j++)
			System.out.print(MAZE[i][j]);
		System.out.print("\n");
	}
	while(x<=ExitX&&y<=ExitY)
	{
		MAZE[x][y]=2;
		if(MAZE[x-1][y]==0)
		{
			x -= 1;		
			path.insert(x,y);
		}
		else if(MAZE[x+1][y]==0)
		{
			x+=1;
			path.insert(x,y);
		}
		else if(MAZE[x][y-1]==0)
		{
			y-=1;
			path.insert(x,y);
		}
		else if(MAZE[x][y+1]==0)
		{
			y+=1;
			path.insert(x,y);
		}
		else if(chkExit(x,y,ExitX,ExitY)==1) 
			break;
		else
		{
			MAZE[x][y]=2;
			path.delete();
			x=path.last.x;
			y=path.last.y;
		}
	}
	System.out.print("[�ѹ����L�����|(2������)]\n"); 
	for(i=0;i<10;i++)
	{
		for(j=0;j<12;j++)
			System.out.print(MAZE[i][j]);
		System.out.print("\n");
	}
   }

public static int chkExit(int x,int y,int ex,int ey)
{
	if(x==ex&&y==ey)
	{
		if(MAZE[x-1][y]==1||MAZE[x+1][y]==1||MAZE[x][y-1] ==1||MAZE[x][y+1]==2)
			return 1;
		if(MAZE[x-1][y]==1||MAZE[x+1][y]==1||MAZE[x][y-1] ==2||MAZE[x][y+1]==1)
			return 1;
		if(MAZE[x-1][y]==1||MAZE[x+1][y]==2||MAZE[x][y-1] ==1||MAZE[x][y+1]==1)
			return 1;
		if(MAZE[x-1][y]==2||MAZE[x+1][y]==1||MAZE[x][y-1] ==1||MAZE[x][y+1]==1)
			return 1;
    }
	return 0;
}
}
