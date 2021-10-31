package BOJ;

import java.io.*;
import java.util.*;

public class boj17779 {
	public static int N, total = 0;
	public static int[][] A;
	public static boolean[][] Area;
	public static int[] people;
	public static int ans = Integer.MAX_VALUE;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		A = new int[N+1][N+1];
		
		StringTokenizer st;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				total += A[i][j];
			}
		}
		
		
		for(int x = 1; x < N; x++) {
			for(int y = 2; y < N; y++) {
				for(int d1 = 1; d1 < N; d1++) {
					for(int d2 = 1; d2 < N; d2++) {
						if(x+d1+d2 > N) continue;
						if(y-d1 < 1 || y+d2 > N) continue;
						people = new int[6];
						setBoundary(x, y, d1, d2);
						setArea(x, y, d1, d2);
					}
				}
			}
		}
		
		System.out.println(ans);
	}
	public static void setArea(int x, int y, int d1, int d2) {
		//area1
		for(int r = 1; r < x+d1; r++) {
			for(int c = 1; c <= y; c++) {
				if(Area[r][c]) break;
				people[1] += A[r][c];
			}
		}
		//area2
		for(int r = 1; r <= x+d2; r++) {
			for(int c = N; c > y; c--) {
				if(Area[r][c]) break;
				people[2] += A[r][c];
			}
		}
		//area3
		for(int r = x+d1; r <= N ; r++) {
			for(int c = 1; c < y-d1+d2; c++) {
				if(Area[r][c]) break;
				people[3] += A[r][c];
			}
		}		
		//area4
		for(int r = x+d2+1; r <= N ; r++) {
			for(int c = N; c >= y-d1+d2; c--) {
				if(Area[r][c]) break;
				people[4] += A[r][c];
			}
		}
		people[5] = total - people[1] - people[2] - people[3] - people[4];
		
		Arrays.sort(people);
		if(people[5] - people[1] < ans) {
			ans = people[5] - people[1];
			
		}
	}
	
	public static void setBoundary(int x, int y, int d1, int d2) {
		Area = new boolean[N+1][N+1];
		for(int i = 0; i <= d1; i++) {
			Area[x+i][y-i] = true;
		}
		for(int i = 0; i <= d2; i++) {
			Area[x+i][y+i] = true;
		}
		for(int i = 0; i <= d2; i++) {
			Area[x+d1+i][y-d1+i] = true;
		}
		for(int i = 0; i <= d1; i++) {
			Area[x+d2+i][y+d2-i] = true;
		}
	}
}
