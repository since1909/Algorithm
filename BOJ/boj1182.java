package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class boj1182 {
	public static int[] arr;
	public static int N, S, answer = 0;
	
	public static void recur(int sum, int depth) {
		if(depth == arr.length) {
			if(sum == S) {
				answer++;
			}
			return;
		}
		
		recur(sum + arr[depth], depth+1);
		recur(sum, depth+1);
	}
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		String[] strs = br.readLine().split(" ");
		for(int i = 0; i < strs.length; i++) arr[i] = Integer.parseInt(strs[i]);
		recur(0, 0);
		
		System.out.println(S == 0 ? answer-1 : answer);
	}
}
