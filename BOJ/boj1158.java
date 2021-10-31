package BOJ;

import java.io.*;
import java.util.*;

public class boj1158 {
	public static int N, K;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i < N+1; i++) {
			q.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		while(!q.isEmpty()) {
			for(int i = 0; i < K-1; i++) {
				q.offer(q.poll());
			}
			sb.append(q.poll()).append(", ");
		}
		
		String ans = sb.toString().substring(0, sb.length()-2) + ">";
		System.out.println(ans);
	}
}
