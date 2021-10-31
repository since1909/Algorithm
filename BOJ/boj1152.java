package BOJ;

import java.io.*;

public class boj1152 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		if(input.length() == 1) {
			if(input.equals(" ")) {
				System.out.println(0);
				return;
			}
		}
		if(input.charAt(0) == ' ') input = input.substring(1);
		
		String[] words = input.split(" ");
		System.out.println(words.length);
	}
}
