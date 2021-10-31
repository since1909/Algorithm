package BOJ;

import java.io.*;

public class boj1100 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = 0;
		for(int i = 0; i < 8; i++) {
			char[] row = br.readLine().toCharArray();
			for(int j = 0; j < 8; j++) {
				if(i % 2 == 0) {
					if(j % 2 == 0 && row[j] == 'F') count++; 
				}
				else {
					if(j % 2 == 1 && row[j] == 'F') count++; 
				}
				
			}
		}
		System.out.println(count);
	}
}
