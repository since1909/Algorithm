import java.util.*;
import java.io.*;

public class boj11724 {
	public static int node, edge;
	public static boolean[] visited;
	public static boolean[][] graph;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		node = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		
		visited = new boolean[node+1];
		graph = new boolean[node+1][node+1];
		for(int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x][y] = true;
			graph[y][x] = true;
		}
		
		int answer = 0;
		for(int i = 1; i <= node; i++) {
			if(!visited[i]) {
				dfs(i);
				answer++;
			}
		}
		System.out.println(answer);
	}
	public static void dfs(int v) {
		if(visited[v]) {
			return;
		}
		else {
			visited[v] = true;
			for(int i = 1; i <= node; i++) {
				if(graph[v][i]) {
					dfs(i);
				}
			}
		}
	}
}
