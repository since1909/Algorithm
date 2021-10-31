package BOJ;

import java.util.*;
import java.io.*;

public class boj1238 {
	public static int N, M, X;
	public static int[] costs;
	public static int[] costsReverse;

	
	public static ArrayList<ArrayList<Node>> map = new ArrayList<>();
	public static ArrayList<ArrayList<Node>> mapReverse = new ArrayList<>();
	
	public static class Node implements Comparable<Node> {
		int to;
		int cost;
		
		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		costs = new int[N+1];
		costsReverse = new int[N+1];
		Arrays.fill(costs, 987654321);
		Arrays.fill(costsReverse, 987654321);
		
		for(int i = 0; i <= N; i++) {
			map.add(new ArrayList<>());
			mapReverse.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			map.get(from).add(new Node(to, cost));
			mapReverse.get(to).add(new Node(from, cost));
		}
		
		dijkstra(map, costs);
		dijkstra(mapReverse, costsReverse);
		
		 int ans = 0;
	     for (int i = 1; i <= N; i++) {
	        ans = Math.max(ans, costs[i] + costsReverse[i]);
	     }
	     System.out.println(ans);
	}
	
	public static boolean[] visited;
	public static void dijkstra(ArrayList<ArrayList<Node>> town, int[] dist) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		visited = new boolean[N+1];
		
		pq.offer(new Node(X, 0));
		dist[X] = 0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int current = node.to;
			
			if(!visited[current]) {
				visited[current] = true;
				for(Node n : town.get(current)) {
					if(dist[n.to] > dist[current] + n.cost) {
						dist[n.to] = dist[current] + n.cost;
						pq.offer(new Node(n.to, dist[n.to]));
					}
				}
			}
		}
	}
}
