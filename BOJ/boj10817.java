package BOJ;

import java.io.*;
import java.util.*;

public class boj10817 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(Integer.parseInt(st.nextToken()));
		pq.add(Integer.parseInt(st.nextToken()));
		pq.add(Integer.parseInt(st.nextToken()));
		
		pq.poll();
		System.out.println(pq.peek());
	}
}
