package BOJ;

import java.util.*;
import java.io.*;

public class boj15685 {
	public static int[] dx = {1, 0, -1, 0};
	public static int[] dy = {0, -1, 0, 1};
	public static int N;
	public static int count = 0;
	public static int[][] map = new int[101][101];
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			makeCurve(x, y, d, g);
		}
		System.out.println(countSquare());
	}
	
	public static boolean isValid(int x, int y) {
		if(x < 0 || y < 0 || x > 100 || y > 100) {
			return false;
		}
		return true;
	}
	
	public static void makeCurve(int x, int y, int d, int g) {
		LinkedList<Integer> direction = new LinkedList<>();
		direction.add(d);
		map[y][x] = 1;
		x = x + dx[d];
		y = y + dy[d];
		map[y][x] = 1;
		while(g-- > 0) {
			for(int i = direction.size()-1; i >= 0; i--) {
				int nDir = (direction.get(i)+1) % 4 ;
				int nx = x + dx[nDir];
				int ny = y + dy[nDir];
				if(isValid(nx, ny)) {
					map[ny][nx] = 1;
					direction.add(nDir);
					x = nx;
					y = ny;
				}
			}
		}
	}
	
	public static int countSquare() {
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(map[i][j] == 0) continue;
				else if(map[i][j] == 1 && map[i+1][j] == 1 &&
						map[i][j+1] == 1 && map[i+1][j+1] == 1) count++;
			}
		}
		return count;
	}
}
