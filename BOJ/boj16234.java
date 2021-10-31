package BOJ;

import java.io.*;
import java.util.*;

public class boj16234 {
	public static int N, L, R;
	public static int[][] map;
	public static boolean[][] visited;
	public static int[] dr = {1, 0, -1, 0};
	public static int[] dc = {0, -1, 0, 1};
	public static Queue<int[]> findArea;
	
	public static boolean isValid(int r, int c) {
		if(r < 0 | r >= N | c < 0 | c >= N) return false;
		return true;
	}
	
	public static boolean moving(int startR, int startC) {
		findArea = new LinkedList<>();
		ArrayList<int[]> unite = new ArrayList<>();
		int sum = 0;
		
		
		findArea.add(new int[] {startR, startC});
		unite.add(new int[] {startR, startC});
		visited[startR][startC] = true;
		sum += map[startR][startC];
		
		while(!findArea.isEmpty()) {
			int[] node = findArea.poll();
			int cr = node[0];
			int cc = node[1];
			for(int i = 0; i < 4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				if(isValid(nr, nc) && !visited[nr][nc] &&
						Math.abs(map[cr][cc] - map[nr][nc]) >= L &&
						Math.abs(map[cr][cc] - map[nr][nc]) <= R) {
					visited[nr][nc] = true;
					findArea.add(new int[] {nr, nc});
					unite.add(new int[] {nr, nc});
					sum += map[nr][nc];
				}
			}
		}
		if(unite.size() == 1) return false;
		
		int people = (int)(sum / unite.size());
		for(int[] p : unite) {
			map[p[0]][p[1]] = people;
		}
		return true;
	}
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			//Arrays.fill(visited[i], false);
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		while(true) {
			visited = new boolean[N][N];
			boolean canMove = false;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!visited[i][j] && moving(i, j)) canMove = true;
				}
			}
			
			if(canMove) answer++;
			else break;
		}
		
		System.out.println(answer);
		
		
	}
}
