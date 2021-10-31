package BOJ;
import java.util.*;
import java.io.*;

public class boj17144 {
	public static int R, C, T;
	public static int[][] map;
	public static int airRow;
	
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	
 	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					airRow = i;
				}
			}
		}
		
		while(T-- > 0) {
			map = diffusion();
			swap(airRow);
		}
		
		int sum = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				sum += map[i][j];
			}
		}
		//air cleaner 자리 -1 고려해서 2 더함
		System.out.println(sum + 2);
	}
 	
 	//air cleaner 중 아래 row를 인자로 받음
 	public static void swap(int row) {
 		int top = row -1;
 		//top down
 		for(int i = top-1; i > 0; i--) {
 			map[i][0] = map[i-1][0];
 		}
 		//top left
 		for(int j = 1; j < C; j++) {
 			map[0][j-1] = map[0][j];
 		}
 		//top up
 		for(int i = 1; i <= top; i++) {
 			map[i-1][C-1] = map[i][C-1];
 		}
 		//top right
 		for(int j = C-1; j > 0; j--) {
 			map[top][j] = map[top][j-1];
 		}
 		map[top][0] = -1;
 		map[top][1] = 0;
 		//down up
 		for(int i = row+1; i < R; i++) {
 			map[i-1][0] = map[i][0];
 		}
 		//down left
 		for(int j = 0; j < C-1; j++) {
 			map[R-1][j] = map[R-1][j+1];
 		}
 		//down down
 		for(int i = R-1; i > row; i--) {
 			map[i][C-1] = map[i-1][C-1];
 		}
 		//down right
 		for(int j = C-1; j > 0; j--) {
 			map[row][j] = map[row][j-1];
 		}
 		map[row][1] = 0;
 		map[row][0] = -1;
 	}
 	
 	
	public static boolean isValid(int r, int c) {
		if(r < 0 || c < 0 || r >= R || c >= C) return false;
		return true;
	}
	
	public static int[][] diffusion() {
		int[][] diffMap = new int[R][C];
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] != 0 && map[i][j] != -1) {
					int spread = (int)(map[i][j] / 5);
					for(int k = 0; k < 4; k++) {
						int nR = i + dx[k % 4];
						int nC = j + dy[k % 4];
						if(isValid(nR, nC) && map[nR][nC] != -1) {
							diffMap[nR][nC] += spread;
							map[i][j] -= spread;
						}
					}
					diffMap[i][j] += map[i][j];
				}
				else if(map[i][j] == -1) {
					diffMap[i][j] = -1;
				}
			}
		}
		return diffMap;
	}
}
