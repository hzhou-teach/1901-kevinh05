//package usaco2019january;
//40 min
//all ten cases work
//Difficulty 3/10
//THought this was pretty simple I just ran through all the possibilities
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class shell
{
	
	public static int[] swap (int shell1, int shell2, int[] positions) {
		
		int temp=positions[shell1-1];
		positions[shell1-1]=positions[shell2-1];
		positions[shell2-1]=temp;
		return positions;
	}

	public static void main(String[] args) throws IOException
	{
		Scanner in = new Scanner(new File("shell.in"));
		
		int N=in.nextInt();
		int [] possibilities = {0,0,0};
		int [] positions= {1,2,3};
		
		//-----------------------------------------------------------------------------------------------
		for(int i=0; i<N; i++) {
			
			swap(in.nextInt(),in.nextInt(),positions);
			int guess=in.nextInt()-1;
			if(positions[guess]==1) {
				possibilities[0]++;
			}
			if(positions[guess]==2) {
				possibilities[1]++;
			}
			if(positions[guess]==3) {
				possibilities[2]++;
			}
			
		}
		in.close();
		//-----------------------------------------------------------------------------------------------
		int max=0;
		for(int element:possibilities) {
			if(element>max) {
				max=element;
			}
		}
		
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));
		pw.println(max);
		pw.close();
		
	}

}
