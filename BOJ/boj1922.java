package BOJ;

import java.io.*;
import java.util.*;

public class boj1922 {
	public static int N, M;
	public static int[] parents;
	public static PriorityQueue<Node> pq = new PriorityQueue<>();
	
	public static class Node implements Comparable<Node> {
		int from;
		int to;
		int cost;
		
		public Node(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		parents = new int[N+1];
		for(int i = 0; i < N+1; i++) parents[i] = i;
		
		StringTokenizer st;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			pq.offer(new Node(from, to, cost));
		}
		
		int totalCost = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			if(find(node.from) != find(node.to)) {
				totalCost += node.cost;
				union(node.from, node.to);
			}
		}
		
		System.out.println(totalCost);
	}
	
	public static int find(int x) {
		if(parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}
	
	public static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA != rootB) parents[rootB] = rootA;
	}
}