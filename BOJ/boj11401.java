package BOJ;

import java.io.*;
import java.util.*;

// 분할정복, 모듈러,페르마의 소정리
public class boj11401 {
	final static long MOD = 1000000007;
	public static long N, K;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Long.parseLong(st.nextToken());
		K = Long.parseLong(st.nextToken());
		
		long up = factorial(N);
		long down = factorial(K) * factorial(N-K) % MOD;
		
		//페르마의 소정리로 역원 구하기
		System.out.println(up * pow(down, MOD -2) % MOD);
	}
	
	public static long factorial(long N) {
		long result = 1L;
		
		while(N > 1) {
			result  = (result * N) % MOD;
			N--;
		}
		return result;
	}
	
	public static long pow(long base, long exp) {
		long result = 1;
		
		while(exp > 0) {
			if(exp % 2 == 1) {
				result *= base;
				result %= MOD;
			}	
			
			base = (base * base) % MOD;
			exp /= 2;
		}
		return result;
	}
	
}
