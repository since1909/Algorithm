package BOJ;
import java.io.*;
import java.util.*;
public class boj1916 {
	public static int N, M;
	public static boolean[] visited;
	public static int[] dist;
	public static ArrayList<ArrayList<Node>> map = new ArrayList<>();
	static class Node implements Comparable<Node>{
		int dest;
		int fee;
		public Node(int dest, int fee){
			this.dest = dest;
			this.fee = fee;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.fee - o.fee;
		}
	}
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		dist = new int[N+1];
		visited = new boolean[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(visited, false);
		for(int i = 0; i< N+1; i++) {
			map.add(new ArrayList<Node>());
		}
		StringTokenizer st;
		for(int j = 0; j < M; j++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int fee = Integer.parseInt(st.nextToken());
			map.get(from).add(new Node(to, fee));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end  = Integer.parseInt(st.nextToken());
		System.out.println(dijkstra(start, end));
	}
	
	public static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start] = 0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int dest = node.dest;
			int fee = node.fee;
			if(!visited[dest]) {
				visited[dest] = true;
				ArrayList<Node> arr = map.get(dest);
				for(int i = 0; i < arr.size(); i++) {
					Node tmp = arr.get(i);
					if(dist[tmp.dest] > tmp.fee + dist[dest]) {
						dist[tmp.dest] = tmp.fee + dist[dest];
						pq.add(new Node(tmp.dest, dist[tmp.dest]));
					}
				}
			}
		}
		return dist[end];
	}
}
