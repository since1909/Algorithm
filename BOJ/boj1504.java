import java.io.*;
import java.util.*;

public class boj1504 {
	public static int N, E;
	public static int[] dist;
	public static int[] visited;
	public static ArrayList<ArrayList<Node>> map = new ArrayList<>();
	static class Node implements Comparable<Node> {
		int to, len;
		public Node(int to, int len) {
			this.to = to;
			this.len = len;
		}
		@Override
		public int compareTo(Node o) {
			return this.len - o.len;
		}
	}
	
	public static long dijkstra(int start, int end) {
		Arrays.fill(dist, 987654321); //max value로 하면 나중에 더할때 overflow 발생
		Arrays.fill(visited, 0);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int currentTo = node.to;
			if(visited[currentTo] == 0) {
				visited[currentTo] = 1;
				ArrayList<Node> tmpList = map.get(currentTo);
				for(int i = 0; i < tmpList.size(); i++) {
					if(dist[tmpList.get(i).to] > dist[currentTo] + tmpList.get(i).len) {
						dist[tmpList.get(i).to] = dist[currentTo] + tmpList.get(i).len;
						pq.add(new Node(tmpList.get(i).to, dist[tmpList.get(i).to]));
					}
				}
			}
		}
		
		return dist[end];
	}
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		dist = new int[N+1];
		visited = new int[N+1];
		for(int i = 0; i < N+1; i++) {
			map.add(new ArrayList<>());
		}
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map.get(a).add(new Node(b, c));
			map.get(b).add(new Node(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		long answer = Math.min(dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N),
							dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N));
		if(answer >= 987654321) System.out.println("-1");
		else {
			System.out.println(answer);
		}
	}
}
