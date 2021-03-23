import java.io.*;
import java.util.*;

public class boj3190 {
	public static int[] dx = {1, 0, -1, 0};
	public static int[] dy = {0, 1, 0, -1};
	public static int N, K, L;
	public static LinkedList<int[]> snake;
	public static int[][] board;
	public static int[][] dir;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N+1][N+1];
		
		K = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			board[row][col] = 1;
		}
		
		L = Integer.parseInt(br.readLine());
		dir = new int[L][2];
		for(int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			dir[i][0] = Integer.parseInt(st.nextToken());
			dir[i][1] = (st.nextToken().equals("D")) ? 1 : -1; //D가 시계방향 L이 반시계방
		}
		
		System.out.println(solution(1, 1, 0));
			
	}
	
	public static boolean gameOver(int x, int y) {
		if (x == 0 || y == 0 || x == N+1 || y == N+1) {
			return true;
		}
		for(int i = 0; i < snake.size(); i++) {
			if(snake.get(i)[0] == y && snake.get(i)[1] == x ) return true;
		}
		return false;
	}
	
	public static int solution(int x, int y, int direction) {
		int time = 0;
		int index = 0;
		
		snake = new LinkedList<>();
		snake.add(new int[] {1, 1});
		
		while(true) {
			time++;
			
			int nextX = x + dx[direction];
			int nextY = y + dy[direction];
			
			if(gameOver(nextX, nextY)) break;
			
			if(board[nextY][nextX] == 1) {
				snake.add(new int[] {nextY, nextX});
				board[nextY][nextX] = 0;
			}else {
				snake.add(new int[] {nextY, nextX});
				snake.pollFirst();
			}
			
			if(index < L && time == dir[index][0]) {
				direction = (direction + dir[index][1]) % 4;
				if(direction == -1) {direction = 3;}
				index++;
			}
			
			x = nextX;
			y = nextY;
		}
		
		return time;
	}
}
