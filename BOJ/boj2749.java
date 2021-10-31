package BOJ;

import java.io.*;

public class boj2749 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine());
		int pisano = 1500000;
		long[] arr = new long[pisano];
		arr[0] = 0; arr[1] = 1;
		
		for(int i = 2; i < pisano && i <= n; i++) {
			arr[i] = (arr[i-1] + arr[i-2]) % 1000000;
		}
		
		if(n >= pisano) n %= pisano;
		System.out.println(arr[(int)n]);
	}
}
