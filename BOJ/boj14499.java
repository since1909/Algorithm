import java.util.*;
import java.io.*;

public class boj14499 {
	public static int N, M, K, x, y;
	public static int[][] map;
	public static int[] dir;
	public static int[] dice = new int[7];
	public static StringBuilder sb = new StringBuilder();
	
	//east west north south
	public static int[] dx = {1, -1, 0, 0}; 
	public static int[] dy = {0, 0, -1, 1};
	
	public static void rollDice(int direction) {
		int[] curDice = dice.clone(); 
		switch(direction) {
		case 1:	//east
			dice[1] = curDice[4];
			dice[3] = curDice[1];
			dice[4] = curDice[6];
			dice[6] = curDice[3];
			break;
		case 2: //west
			dice[1] = curDice[3];
			dice[3] = curDice[6];
			dice[4] = curDice[1];
			dice[6] = curDice[4];
			break;
		case 3: //north
			dice[1] = curDice[5];
			dice[2] = curDice[1];
			dice[5] = curDice[6];
			dice[6] = curDice[2];
			break;
		case 4: //south
			dice[1] = curDice[2];
			dice[2] = curDice[6];
			dice[5] = curDice[1];
			dice[6] = curDice[5];
			break;
		}
	}
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		//map 초기화
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//명령어 초기화
		dir = new int[K];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < K; i++) {
			dir[i] = Integer.parseInt(st.nextToken());
		}
		
		solution(x, y);
		System.out.println(sb);
	}
	public static boolean isValid(int x, int y) {
		if(x < 0 || y < 0 || x >= M || y >= N)
			return false;
		return true;
	}
	
	public static void solution(int x, int y) {
		for(int i = 0; i < K; i++) {
			int nextX = x + dx[dir[i] - 1];
			int nextY = y + dy[dir[i] - 1];
			
			if(isValid(nextX, nextY)) {
				rollDice(dir[i]);
				if(map[nextY][nextX] == 0) {
					map[nextY][nextX] = dice[6];
				}
				else {
					dice[6] = map[nextY][nextX];
					map[nextY][nextX] = 0;
				}
				x = nextX;
				y = nextY;
				sb.append(dice[1] + "\n");
			}
		}
	}
}
