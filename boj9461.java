import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class boj9461 {
	public static int T;
	public static int[] N;
	public static long[] DP = new long[101];
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		N = new int[T];
		for(int i = 0; i < T; i++) {
			N[i] = Integer.parseInt(br.readLine());
		}
		for(int i = 4; i < DP.length; i++) {
			DP[i] = -1;
		}
		DP[0] = 0;
		DP[1] = 1;
		DP[2] = 1;
		DP[3] = 1;
		
		for(int i = 0; i < N.length; i++) {
			System.out.println(P(N[i]));
		}
	}
	
	public static long P(int N) {
		if(DP[N] == -1) {
			DP[N] = P(N-2) + P(N-3);
		}
		
		return DP[N];
	}
}