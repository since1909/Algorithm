package BOJ;

import java.io.*;
import java.util.*;

public class boj10830 {
	final static int MOD = 1000;
	public static int N;
	public static int[][] matrix;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		matrix = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken()) % MOD;
			}
		}
		
		int[][] result = pow(matrix, B);
		
		StringBuilder sb = new StringBuilder();
		for(int[] row : result) {
			for(int r : row) {
				sb.append(r).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	public static int[][] pow(int[][] A, long B){
		if(B == 1L) return A;
		
		int[][] temp = pow(A, B / 2);
		
		temp = multiply(temp, temp);
		
		if(B % 2 == 1L) return multiply(temp, matrix);
		return temp;
		
	}
	
	//행렬 곱 연산 함수
	public static int[][] multiply(int[][] m1, int[][] m2) {
		int[][] result = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					result[i][j] += m1[i][k] * m2[k][j];
					result[i][j] %= MOD;
				}
			}
		}
		
		return result;
	}

}
