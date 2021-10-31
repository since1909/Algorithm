package BOJ;
import java.io.*;
import java.util.*;

public class boj1753 {
	static class Node implements Comparable<Node>{
	    int end, weight;
	    public Node(int end,int weight){
	        this.end = end;
	        this.weight = weight;
	    }

	    @Override
	    public int compareTo(Node o) {
	        return this.weight - o.weight;
	    }
	}
	
	public static int v, e;
	public static int s;
	public static int[] dis;
	public static int[] visited;
	public static ArrayList<ArrayList<Node>> map = new ArrayList<>();
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(br.readLine());
		for(int i=0; i < v+1; i++){
            map.add(new ArrayList<>());
        }
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map.get(a).add(new Node(b, c));
		}
		dis = new int[v+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		visited = new int[v+1];
		dijkstra(s);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < dis.length; i++) {
			if(dis[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
				continue;
			}
			sb.append(dis[i] + "\n");
		}
		System.out.print(sb);
		
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dis[start] = 0;
		
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			int end = current.end;
			int weight = current.weight;
			if(visited[end] == 0) {
				visited[end] = 1;
				ArrayList<Node> arr = map.get(end);
				for(int i = 0; i < arr.size(); i++) {
					Node tmp = arr.get(i);
					if(tmp.weight + dis[end] < dis[tmp.end]) {
						dis[tmp.end] = tmp.weight + dis[end];
						pq.add(new Node(tmp.end, dis[tmp.end]));
					}
				}
			}
		}
	}
}
