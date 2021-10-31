package BOJ;

import java.io.*;
import java.util.*;

public class boj2468 {
	public static int N;
	public static int[][] map;
	public static int MIN = Integer.MAX_VALUE;
	public static int MAX = Integer.MIN_VALUE;
	
	public static int[] dx = {1, 0, -1, 0};
	public static int[] dy = {0, -1, 0, 1};
	
	public static class Pos {
		int x;
		int y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][i] > MAX) MAX = map[i][j];
				if (map[i][j] < MIN) MIN = map[i][j];
			}
		}
		
		int safeArea = 0;
		for(int i = MIN; i < MAX; i++) {
			int count = bfs(i);
			if(safeArea < count) safeArea = count;
		}
		
		System.out.println(safeArea);
	}
	
	public static boolean isValid(int x, int y) {
		if(x < 0 || y < 0 || x >= N || y >= N) return false;
		return true;
	}
	
	public static int bfs(int water) {
		boolean[][] visited = new boolean[N][N];
		Queue<Pos> q = new LinkedList<>();
		
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] <= water || visited[i][j]) continue;
				
				q.offer(new Pos(i, j));
				while(!q.isEmpty()) {
					Pos pos = q.poll();
					
					for(int k = 0; k < 4; k++) {
						int nx = pos.x + dx[k];
						int ny = pos.y + dy[k];
						
						if(isValid(nx, ny) && !visited[nx][ny] && map[nx][ny] > water) {
							q.offer(new Pos(nx,ny));
							visited[pos.x][pos.y] = true;
							visited[nx][ny] = true;
						}
					}
				}
				
				count++;
			}
		}
		
		return count;
	}
}
