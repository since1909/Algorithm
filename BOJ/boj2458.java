package BOJ;

import java.io.*;
import java.util.*;

public class boj2458 {
	public static int N, M;
	public static int[][]	arr;
	public static void main(String argsp[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		
		for(int i = 0; i <= N; i++) {
			Arrays.fill(arr[i], 100_000);
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int small = Integer.parseInt(st.nextToken());
			int tall = Integer.parseInt(st.nextToken());
			
			arr[small][tall] = 1;
		}
		
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}
		
		int[] countArr = new int[N+1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j<= N; j++) {
				if(arr[i][j] != 100_000) {
					countArr[i]++;
					countArr[j]++;
				}
			}
		}
		
		int count = 0;
		for(int i = 1; i <= N; i++)
			if(countArr[i] == N-1)
				count++;
		
		System.out.println(count);
	}
}
