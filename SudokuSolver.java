import java.util.Scanner;

public class SudokuSolver
{	
	static int [][] arr= new int[9][9];
	static int [][] arr2 = new int [9][9];
	static int [][] arr3 = new int [9][9];
	public static void main(String args[])
	{	
		int i,j=0,count=0,k=0,a=0,b=0,flag=0,flag2=0;
		String [] temp=  new String[9];
		Scanner s = new Scanner(System.in);
		for(i=0;i<9;i++)
		{	
			temp = s.nextLine().split(" ");
			for(j=0;j<9;j++)
				{
				arr[i][j] = Integer.parseInt(temp[j]);
				}
		}
		//------------------------------------------------------------------
		// counting number of places to be filled and backing up the array 
		//------------------------------------------------------------------
		for(i=0;i<9;i++)
		{
			for(j=0;j<9;j++)
			{
				if(arr[i][j] == 0)
					{
					count++;
					arr2[i][j] = 1;
					}
			}
		}
		solve(arr,0,0);
		//printboard(arr2);
		//f();
		//printboard(arr3);
		//printboard(arr);
		
		//--------------------------------------------------------=---
		
		//---------------------------------------------------------------
		// solving of Sudoku begins
}	//---------------------------------------------------------------
		public static void solve(int[][] arr,int row,int col)
		{	
			f();
			if(row>8)
				{	
				printboard(arr);
				}
			else{
				
			if(arr[row][col] != 0)
				{
				next(arr,row,col);
				}
			else
				{
				for(int a=1;a<10;a++)
				{
					if(check(arr,row,col,a))
						{
						arr[row][col]=a;
						next(arr,row,col);
						}
				}
				arr[row][col]=0;
				}
			}
		}
		public static void next(int[][] arr,int row,int col)
		{
			if(col<8)
				solve(arr,row,col+1);
			else solve(arr,row+1,0);
				
		}
		/*for(i=0;i<9;i++)
		{
			for(j=0;j<9;j++)
			{
				if(arr2[i][j] == 1)
				{
					for(k=1;k<10;k++)
					{
					if(check(arr,i,j,k))
						{
						arr[i][j] = k;
						flag=1;
						break;
						}
					else flag=0;
					}
				}
				if(flag == 0)
				{
					for(a=i;a>-1;a--)
					{
						for(b=j-1;b>-1;b--)
						{
							if(arr2[a][b] == 1)
							{
								if(arr[a][b]==9)
									break;
								else
								{
								arr[a][b]++;
								i=a+1;j=b+1;
								flag2=1;
								break;
								}
							}
							else flag2=0;
						}
						if(flag2==1)
							break;
						else j=9;
					}		
				}
			}
		}
		printboard(arr);
	*/
	//-------------------- end of main method------------------------------
	
	public static void printboard(int[][] arr)
	{	
		int a=0,b=0;
		for(a=0;a<9;a++)
			{
			System.out.println(" ");
			for(b=0;b<9;b++)
				System.out.print(" " + arr [a][b]);
			}
	}
	// --------------------end of printboard method--------------------------
	public static boolean check(int[][] arr ,int x ,int y ,int z)
	{	int a,b;
		f();
		for(a=0;a<9;a++)
		{
			if(arr[x][a] == z) return false;
		}
		for(b=0;b<9;b++)
		{
			if(arr[b][y] == z) return false;
		}
		x = (x / 3) * 3 ;
	    y = (y / 3) * 3 ;
	    for( int r = 0; r < 3; r++ )
	         for( int c = 0; c < 3; c++ )
	         if( arr[x+r][y+c] == z )
	            return false ;

	    return true ;
		/*if(x<3 && y<3 ) 
			for(a=0;a<9;a++)
			{
				if(arr3[0][a]==z) return false;
			}
		if(x<3 && y>2 && y<6)
			for(a=0;a<9;a++)
			{
				if(arr3[1][a]==z) return false;
			}
		if(x<3 && y>5 && y<9)
			for(a=0;a<9;a++)
			{
				if(arr3[2][a]==z) return false;
			}
		if(x>2 && x<6 && y<3)
			for(a=0;a<9;a++)
			{
				if(arr3[3][a]==z) return false;
			}
		if(x>2 && x<6 && y>2 && y<6)
			for(a=0;a<9;a++)
			{
				if(arr3[4][a]==z) return false;
			}
		if(x>2 && x<6 && y>5 && y<9)
			for(a=0;a<9;a++)
			{
				if(arr3[5][a]==z) return false;
			}
		if(x>5 && x<9 && y<3)
			for(a=0;a<9;a++)
			{
				if(arr3[6][a]==z) return false;
			}
		if(x>5 && x<9 && y>2 && y<6)
			for(a=0;a<9;a++)
			{
				if(arr3[7][a]==z) return false;
			}
		if(x>5 && x<9 && y>5 && y<9)
			for(a=0;a<9;a++)
			{
				if(arr3[8][a]==z) return false;
			}
		else return true;
		return true;*/
		
	}
	//--------------------- end of check method------------------------
	public static void f(){
		arr3[0][0]=arr[0][0];arr3[0][1]=arr[0][1];arr3[0][2]=arr[0][2];
		arr3[0][3]=arr[1][0];arr3[0][4]=arr[1][1];arr3[0][5]=arr[1][2];
		arr3[0][6]=arr[2][0];arr3[0][7]=arr[2][1];arr3[0][8]=arr[2][2];
		
		arr3[1][0]=arr[0][3];arr3[1][1]=arr[0][4];arr3[1][2]=arr[0][5];
		arr3[1][3]=arr[1][3];arr3[1][4]=arr[1][4];arr3[1][5]=arr[1][5];
		arr3[1][6]=arr[2][3];arr3[1][7]=arr[2][4];arr3[1][8]=arr[2][5];
		
		arr3[2][0]=arr[0][6];arr3[2][1]=arr[0][7];arr3[2][2]=arr[0][8];
		arr3[2][3]=arr[1][6];arr3[2][4]=arr[1][7];arr3[2][5]=arr[1][8];
		arr3[2][6]=arr[2][6];arr3[2][7]=arr[2][7];arr3[2][8]=arr[2][8];
		
		arr3[3][0]=arr[3][0];arr3[3][1]=arr[3][1];arr3[3][2]=arr[3][2];
		arr3[3][3]=arr[4][0];arr3[3][4]=arr[4][1];arr3[3][5]=arr[4][2];
		arr3[3][6]=arr[5][0];arr3[3][7]=arr[5][1];arr3[3][8]=arr[5][2];
		
		arr3[4][0]=arr[3][3];arr3[4][1]=arr[3][4];arr3[4][2]=arr[3][5];
		arr3[4][3]=arr[4][3];arr3[4][4]=arr[4][4];arr3[4][5]=arr[4][5];
		arr3[4][6]=arr[5][3];arr3[4][7]=arr[5][4];arr3[4][8]=arr[5][5];
		
		arr3[5][0]=arr[3][6];arr3[5][1]=arr[3][7];arr3[5][2]=arr[3][8];
		arr3[5][3]=arr[4][6];arr3[5][4]=arr[4][7];arr3[5][5]=arr[4][8];
		arr3[5][6]=arr[5][6];arr3[5][7]=arr[5][7];arr3[5][8]=arr[5][8];
		
		arr3[6][0]=arr[6][0];arr3[6][1]=arr[6][1];arr3[0][2]=arr[6][2];
		arr3[6][3]=arr[7][0];arr3[6][4]=arr[7][1];arr3[0][5]=arr[7][2];
		arr3[6][6]=arr[8][0];arr3[6][7]=arr[8][1];arr3[0][8]=arr[8][2];
		
		arr3[7][0]=arr[6][3];arr3[7][1]=arr[6][4];arr3[1][2]=arr[6][5];
		arr3[7][3]=arr[7][3];arr3[7][4]=arr[7][4];arr3[1][5]=arr[7][5];
		arr3[7][6]=arr[8][3];arr3[7][7]=arr[8][4];arr3[1][8]=arr[8][5];
		
		arr3[8][0]=arr[6][6];arr3[8][1]=arr[6][7];arr3[2][2]=arr[6][8];
		arr3[8][3]=arr[7][6];arr3[8][4]=arr[7][7];arr3[2][5]=arr[7][8];
		arr3[8][6]=arr[8][6];arr3[8][7]=arr[8][7];arr3[2][8]=arr[8][8];
		}
}