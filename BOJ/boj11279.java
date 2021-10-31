package BOJ;

import java.io.*;
import java.util.*;

public class boj11279 {
	public static int N;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		
		while(N-- > 0) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {
				if(pq.isEmpty()) sb.append(0).append("\n");
				else sb.append(pq.poll()).append("\n");
			}
			else {
				pq.offer(num);
			}
		}
		
		System.out.print(sb);
	}
}
