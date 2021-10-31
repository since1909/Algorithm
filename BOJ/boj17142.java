package BOJ;

import java.io.*;
import java.util.*;

public class boj17142 {
	public static class Virus{
		int x, y, time;
		Virus(int x, int y, int time){
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	public static int N, M, empty = 0;
	public static int[][] lab;
	public static int[] dx = {1, 0, -1, 0};
	public static int[] dy = {0, -1, 0, 1};
	public static ArrayList<Virus> virus = new ArrayList<>();
	public static Virus[] activatedVirus;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lab = new int[N][N];
		activatedVirus = new Virus[M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				if(lab[i][j] == 0) empty++;
				if(lab[i][j] == 2) virus.add(new Virus(i, j, 0));
			}
		}
		activeVirus(0, 0);
		if(empty == 0) System.out.println(0);
		else {
			int ans = minTime == Integer.MAX_VALUE ? -1 : minTime;
			System.out.println(ans);
		}
		
	}
	public static boolean isValid(int r, int c) {
		if(r < 0 || r >= N || c < 0 || c >= N) return false;
		return true;
	}
	
	public static void activeVirus(int start, int depth) {
		if(depth == M) {
			spreadVirus(empty);
			return;
		}
		for(int i = start; i < virus.size(); i++) {
			activatedVirus[depth] = virus.get(i);
			activeVirus(i+1, depth+1);
		}
		
	}
	public static int minTime = Integer.MAX_VALUE;
	public static void spreadVirus(int emptyCount) {
		Queue<Virus> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		
		for(int i = 0; i < M; i++) {
			Virus v = activatedVirus[i];
			queue.add(v);
			visited[v.x][v.y] = true;
		}
		
		while(!queue.isEmpty()) {
			Virus v = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nx = v.x + dx[i];
				int ny = v.y + dy[i];
				
				if(!isValid(nx,ny)) continue;
				if(!visited[nx][ny] && lab[nx][ny] != 1) {
					if(lab[nx][ny] == 0) emptyCount--;
					if(emptyCount == 0) {
						minTime = Math.min(v.time+1, minTime);
						return;
					}
					
					visited[nx][ny] = true;
					queue.add(new Virus(nx, ny, v.time+1));
				}
			}
		}
	}
}
