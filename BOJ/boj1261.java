package BOJ;

import java.util.*;
import java.io.*;

public class boj1261 {
	public static int N, M;
	public static int[] dx = {1, 0, -1, 0};
	public static int[]	dy = {0, -1, 0, 1};
	
	public static int[][] map;
	public static boolean[][] visited;
	
	static class Node implements Comparable<Node> {
		int x;
		int y;
		int cost;
		
		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
 	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String row = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = row.charAt(j) - '0';
			}
		}
		
		System.out.println(bfs());
 		
	}
 	
 	public static boolean isValid(int x, int y) {
 		if(x < 0 || x >= N || y < 0 || y >= M) return false;
 		return true;
 	}
 	
 	public static PriorityQueue<Node> pq = new PriorityQueue<>();
 	public static int bfs() {
 		int answer = 0;
 		pq.add(new Node(0, 0, 0));
 		visited[0][0] = true;
 		
 		while(!pq.isEmpty()) {
 			Node node = pq.poll();
 			
 			if(node.x == N-1 && node.y == M-1) {
 				answer = node.cost;
 				break;
 			}
 			
 			for(int i = 0; i < 4; i++) {
 				int nx = node.x + dx[i];
 				int ny = node.y + dy[i];
 				
 				if(!isValid(nx, ny) || visited[nx][ny]) continue;
 				
 				visited[nx][ny] = true;
 				if(map[nx][ny] == 0) {
 					pq.add(new Node(nx, ny, node.cost));
 				}
 				else {
 					pq.add(new Node(nx, ny, node.cost + 1));
 				}
 			}
 		}
 		
 		return answer;
 	}
}
