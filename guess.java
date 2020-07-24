//package usaco2019january;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class animal{
	public String Name;
	public int K;
	public String[]descriptions;
	
	public animal(String Name, int K, String[] descriptions) {
		this.Name=Name;
		this.K=K;
		this.descriptions=descriptions;
	}
}


public class guess
{
	
	public static int nMatches(animal animal1, animal animal2) {
		
		int match=0;
		
		for(int i=0; i<animal1.K; i++) {
			for(int j=0; j<animal2.K; j++) {
				if(animal1.descriptions[i].equals(animal2.descriptions[j])) {
					match++;
					break;
				}
			}
		}
		
		return match;
		
		
	}

	public static void main(String[] args) throws IOException 
	{
		Scanner in = new Scanner(new File("guess.in"));
		int N=in.nextInt();
		animal[] List = new animal[N];
		
		
		for(int i=0; i<N; i++) {
			String Name=in.next();
			int K=in.nextInt();
			String [] Descriptions=new String[K];
			for(int j=0; j<K; j++) {
				Descriptions[j]=in.next();
			}
			List[i]=new animal(Name,K,Descriptions);
		}
		in.close();
		//-----------------------------------------------------------------------------------------------------------
		
		int MaxMatch=0;
		
		for(int i=0; i<N; i++) {
			
			for(int j=i+1; j<N; j++) {
				MaxMatch=Math.max(MaxMatch, nMatches(List[i],List[j]));
			}
			
		}
		
		//-----------------------------------------------------------------------------------------------------------
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("guess.out")));
		pw.println(MaxMatch+1);
		pw.close();
		
		
		
	}

}
