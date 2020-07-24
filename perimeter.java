//package usaco2019january;
//2 hours 30 min
//All cases work except 3,7,11
//Difficulty 9/10
//I thought this problem was pretty hard but in the end I learned how to flood fill

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class perimeter
{
	static int N;
	static int[][] grid;
	static int[][] CoveredArea;
	static int BlobArea=0;
	static int BlobPerimeter=0;
	
	
	public static void floodfill(int x, int y) {
		
		
		
		if(grid[x][y]==0) {
			BlobPerimeter++;
			CoveredArea[x][y]=1;
			return;
		}
		else if(CoveredArea[x][y]==1) {
			return;
		}
		else {
			CoveredArea[x][y]=1;
			BlobArea++;
			if(x==N-1) {
				
				if(y==0) {
					floodfill(x-1, y);
					floodfill(x, y+1);
					BlobPerimeter+=2;
				}
				else if(y==N-1) {
					floodfill(x-1, y);
					floodfill(x, y-1);
					BlobPerimeter+=2;
				}
				else {
					floodfill(x-1,y);
					floodfill(x, y+1);
					floodfill(x, y-1);
					BlobPerimeter++;
				}

			}
			else if(x==0) {
				
				if(y==0) {
					floodfill(x+1, y);
					floodfill(x, y+1);
					BlobPerimeter+=2;
				}
				else if(y==N-1) {
					floodfill(x+1, y);
					floodfill(x, y+1);
					BlobPerimeter+=2;
				}
				else {
					floodfill(x+1,y);
					floodfill(x, y+1);
					floodfill(x, y-1);
					BlobPerimeter++;
				}
			
			}
			else if(y==N-1) {
				floodfill(x+1,y);
				floodfill(x-1,y);
				floodfill(x, y-1);
				BlobPerimeter++;
			}
			else if(y==0) {
				floodfill(x+1,y);
				floodfill(x-1,y);
				floodfill(x, y+1);
				BlobPerimeter++;
			}
			else {
				floodfill(x+1,y);
				floodfill(x-1,y);
				floodfill(x, y+1);
				floodfill(x, y-1);
			}
		}
		
	}

	public static void main(String[] args) throws IOException
	{
		Scanner in = new Scanner(new File("perimeter.in"));
		N=in.nextInt();
		grid=new int[N][N];
		CoveredArea=new int[N][N];
		
		//input   # = 1 , . = 0
		for(int i=0; i<N; i++) {
			String substring=in.next();
			for(int j=0; j<N; j++) {
				if(substring.substring(j,j+1).equals("#")) {
					grid[i][j]=1;
				}
				else {
					grid[i][j]=0;
				}
			}
		}
		//-----------------------------------------------------------------------------------------------
		
		int MaxBlobArea=0;
		int MinBlobPerimeter=0;
		
		for(int i=0; i<N; i++) {
			
			for(int j=0; j<N; j++) {
				if(CoveredArea[i][j]==0 && grid[i][j]==1) {
					floodfill(i, j);
					if(BlobArea>MaxBlobArea) {
						MaxBlobArea=BlobArea;
						MinBlobPerimeter=BlobPerimeter;
					}	
					else if(BlobArea==MaxBlobArea) {
						if(BlobPerimeter<MinBlobPerimeter || MinBlobPerimeter==0) {
							MinBlobPerimeter=BlobPerimeter;
						}
					}	
				}
				BlobArea=0;
				BlobPerimeter=0;
			}
			
		}
		
		//-----------------------------------------------------------------------------------------------
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));
		pw.println(MaxBlobArea+" "+MinBlobPerimeter);
		pw.close();
		
		
		
		
		
	}

}
