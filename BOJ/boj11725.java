package BOJ;

import java.io.*;
import java.util.*;

public class boj11725 {
	public static int N;
	public static ArrayList<ArrayList<Integer>> tree;
	public static int[] parents;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		parents = new int[N+1];
		tree = new ArrayList<>();
		
		for(int i = 0; i < N+1; i++)
			tree.add(new ArrayList<Integer>());
		
		for(int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		
		find();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 2; i < N+1; i++) sb.append(parents[i] + "\n");
		System.out.println(sb);
	}
	
	public static void find() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		
		while(!q.isEmpty()) {
			int current = q.poll();
			for(int next : tree.get(current)) {
				if(parents[next] == 0) {
					q.offer(next);
					parents[next] = current;
				}
			}
		}
	}
}
