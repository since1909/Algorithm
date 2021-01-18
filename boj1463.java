import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class boj1463 {
	public static int N;
	public static Integer [] dp;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new Integer[N+1];
		dp[0] = 0;
		dp[1] = 0;
		System.out.println(DP(N));
	}
	
	//재귀함수 top- down 방식이면 시간 초과
	public static int recur(int n) {
		if(dp[n] == null) {
			if (n % 6 == 0) {
				dp[n] = 1 + Math.min(DP(n-1), Math.min(DP(n/3), DP(n/2)));
			}
			else if(n % 3 == 0) {
				dp[n] = 1 + Math.min(DP(n-1), DP(n/3));
			}
			else if(n % 2 == 0) {
				dp[n] = 1 + Math.min(DP(n-1), DP(n/2));
			}
			else {
				dp[n] = 1+ DP(n-1);
			}
		}			
		return dp[n];
	}

	//반복문 메모이제이션이면 bottom-up 방식으로 통과
	public static int DP(int n) {
		if(n == 1) return 0;
		
		for(int i = 2; i <= n; i++) {
			if(i % 6 == 0) {
				dp[i] = Math.min(dp[i/3], Math.min(dp[i/2], dp[i-1])) + 1;
			}
			else if(i%3 == 0) {
				dp[i] = Math.min(dp[i/3], dp[i-1]) + 1;
			}
			else if(i%2 == 0) {
				dp[i] = Math.min(dp[i/2], dp[i-1]) + 1;
			}
			else {
				dp[i] = dp[i-1] + 1;
			}
		}
		return dp[n];
	}
}
