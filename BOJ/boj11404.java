package BOJ;

import java.io.*;
import java.util.*;

public class boj11404 {
	public static int N, M;
	public static int[][] map;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		
		for(int i = 0; i < N+1; i++) {
			Arrays.fill(map[i], 987654321);
			map[i][i] = 0;
		}
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			if(map[from][to] > cost) map[from][to] = cost;
		}
		
		//Floyd
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
