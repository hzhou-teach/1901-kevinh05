//package usaco2019january;
//1 hour
//All ten cases work
//Difficulty 7/10
//This took a while to think through but in the end I realized it was just the most paths a single land had + 1
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class planting
{

	public static void main(String[] args) throws IOException
	{
		Scanner in = new Scanner(new File("planting.in"));
		int N=in.nextInt();
		int[] Fields=new int[N];
		
		for(int i=0; i<N-1; i++) {
			Fields[in.nextInt()-1]++;
			Fields[in.nextInt()-1]++;
		}
		
		int Max=0;
		for(int i=0; i<N-1; i++) {
			Max=Math.max(Max, Fields[i]);
		}
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("planting.out")));
		pw.println(Max+1);
		pw.close();

	}

}
