package BOJ;

import java.io.*;

public class boj11718 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input = "";
		while((input = br.readLine()) != null) {
			sb.append(input).append("\n");
		}
		
		System.out.println(sb);
	}
}
