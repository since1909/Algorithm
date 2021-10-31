package BOJ;

import java.io.*;
import java.util.*;

public class boj1987 {
	public static int R, C, max = 1;
	public static String[][] map;
	public static boolean[] alpha = new boolean[26];
	
	public static int[] dx = {1, 0, -1, 0};
	public static int[] dy = {0, -1, 0, 1};
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new String[R][C];
		
		for(int i = 0; i < R; i++) {
			String line = br.readLine();
			for(int j = 0; j < C ; j++) {
				map[i][j] = Character.toString(line.charAt(j));
			}
		}
		alpha[map[0][0].charAt(0) - 'A'] = true;
		find(1, 0, 0);
		System.out.println(max);
	}
	
	public static void find(int count, int row, int col) {
		for(int i = 0; i < 4; i++) {
			int nr = row + dx[i];
			int nc = col + dy[i];
			
			if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
			if(alpha[map[nr][nc].charAt(0) - 'A']) continue;
			
			alpha[map[nr][nc].charAt(0) - 'A'] = true;
			find(count+1, nr, nc);	
			max = Math.max(count+1, max);
			alpha[map[nr][nc].charAt(0) - 'A'] = false;
		}
		
		
	}
	
	
}
