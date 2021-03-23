import java.util.*;
import java.io.*;

public class boj14502 {
	public static int N, M;
	public static int[][] map;
	public static int[][] wallMap;
	public static int max = 0;
	public static LinkedList<int[]> virus = new LinkedList<>();
	public static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		wallMap = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					virus.add(new int[] {i, j});
				}
			}
		}
		
		makeWall(0, 0, 0);
		System.out.println(max);
	}
	
	
	private static void makeWall(int x, int y, int depth) {
		if(depth == 3) {
			spreadVirus();
			countSafeZone();
			return;
		}
		for(int i = x; i < N; i++) {
			for(int j = 0; j < M; j++) {
				//그 행에서 y열 이전의 건 검사할 필요 없음
				if(i == x && j < y) continue;
				//빈칸일
				if(map[i][j] == 0) {
					map[i][j] =1;
					makeWall(i, j+1, depth+1);
					map[i][j] = 0;
				}
			}
		}
		
	}
	
	private static void spreadVirus() {
		copyMap();
		LinkedList<int[]> vq = copyVirusQ();
		
		while(!vq.isEmpty()) {
			int[] tmp = vq.poll();
			int x = tmp[0];
			int y = tmp[1];
			
			for(int i = 0; i < 4; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M || wallMap[nextX][nextY] != 0) continue;
				wallMap[nextX][nextY] = 2;
				vq.add(new int[] {nextX, nextY});
			}
			
		}
		
	}
	
	private static void copyMap() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				wallMap[i][j] = map[i][j];
			}
		}
	}
	
	private static LinkedList<int[]> copyVirusQ(){
		LinkedList<int[]> vq = new LinkedList<>();
		for(int i = 0; i < virus.size(); i++) {
			vq.add(virus.get(i));
		}
		return vq;
	}
	
	private static void countSafeZone() {
		int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(wallMap[i][j] == 0) count++;
			}
		}
		
		if(max < count) max = count;
	}
}
