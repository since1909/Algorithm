package BOJ;

import java.io.*;
import java.util.*;

public class boj4963 {
	public static int w, h;
	public static int[][] map;
	public static StringBuilder sb = new StringBuilder();
	
	public static int[] dx = {1, 0, -1, 0, 1, -1, 1, -1};
	public static int[] dy = {0, -1, 0, 1, 1, 1, -1, -1};
	
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		while(w != 0 && h != 0) {
			map = new int[w][h];
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					map[j][i] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append(bfs(w, h)).append("\n");
			
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
		}
		
		System.out.print(sb);
	
	}
	
	public static int bfs(int w, int h) {
		boolean[][] visited = new boolean[w][h];
		Queue<Pos> q = new LinkedList<>();
		
		int count = 0;
		
		for(int n = 0; n < w; n++) {
			for(int m = 0; m < h; m++) {
				if(map[n][m] == 0 || visited[n][m]) continue;
				q.offer(new Pos(n, m));
				
				while(!q.isEmpty()) {
					Pos pos = q.poll();
					
					for(int i = 0; i < 8; i++) {
						int nx = pos.x + dx[i];
						int ny = pos.y + dy[i];
						
						if(isValid(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
							q.offer(new Pos(nx, ny));
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
	
	public static boolean isValid(int x, int y) {
		if(x < 0 || y < 0 || x >= w || y >= h) return false;
		return true;
	}
}
