//package usaco2019january;
//15 min
//All 12 Cases work
//Difficulty 2/10
//This was really simple you just need to find the index of the first number that is out of place starting from the end
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class sleepy
{

	public static void main(String[] args) throws IOException
	{
		Scanner in = new Scanner(new File("sleepy.in"));
		
		int N=in.nextInt();
		int[] line = new int[N];
		for(int i=0; i<N; i++) {
			line[i]=in.nextInt();
		}
		in.close();
		
		
		int minSorts=0;
		
		for(int i=N-1; i>0; i--) {
			if(line[i]<line[i-1]) {
				minSorts=i;
				break;
			}
		}
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sleepy.out")));
		pw.println(minSorts);
		pw.close();
		
		
		
	}

}
