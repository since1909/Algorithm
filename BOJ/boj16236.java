package BOJ;

import java.io.*;
import java.util.*;

public class boj16236 {
	public static int N;
	public static int[][] map, dist;
	public static int[] dx = {1, 0, -1, 0};
	public static int[] dy = {0, -1, 0, 1};
	public static Point babyShark;
	public static int sharkSize = 2;
	public static Point closestFish;
	public static int minDist;
	
	public static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static boolean isValid(int x, int y) {
		if(x < 0 | y < 0 | x >= N | y >=N) return false;
		return true;
	}
	
	public static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(!isValid(nx, ny)) continue;
				if(dist[nx][ny] != 0) continue;
				if(map[nx][ny] > sharkSize) continue;
				
				dist[nx][ny] = dist[p.x][p.y] + 1;
				q.add(new Point(nx, ny));
				
				//먹을 수 있는 것 중에 최솟값 찾기
				if(map[nx][ny] != 0 && map[nx][ny] < sharkSize) {
					if(minDist > dist[nx][ny]) {
						minDist = dist[nx][ny];
						closestFish = new Point(nx, ny);
					}
					else if(minDist == dist[nx][ny]) {
						if(closestFish.x > nx) {
							closestFish = new Point(nx, ny);
						}
						else if(closestFish.x == nx) {
							if(closestFish.y > ny) {
								closestFish = new Point(nx, ny);
							}
						}
					}
				}
			}
		}
	}
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					babyShark = new Point(i, j);
					map[i][j] = 0;
				}
			}
		}
		
		int count = 0;
		int time = 0;
		
		while(true) {
			dist = new int[N][N];
			closestFish = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
			minDist = Integer.MAX_VALUE;
			
			bfs(babyShark.x, babyShark.y);
			if(closestFish.x == Integer.MAX_VALUE || closestFish.y == Integer.MAX_VALUE) break;
			
			count++;
			time += dist[closestFish.x][closestFish.y];
			map[closestFish.x][closestFish.y] = 0;
			
			if(count == sharkSize) {
				count = 0;
				sharkSize++;
			}
			
			babyShark = closestFish;
		}
		System.out.println(time);
	}
}
