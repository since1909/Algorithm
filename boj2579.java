import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class boj2579 {
	public static int N;
	public static int [] steps;
	public static Integer [] dp;
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		steps = new int[N+1];
		dp = new Integer[N+1];
		
		for(int i = 1; i < N+1; i++) {
			steps[i] = Integer.parseInt(br.readLine());
		}
		dp[0] = steps[0];
		dp[1] = steps[1];
		if(N >= 2) {
			dp[2] = steps[1] + steps[2];
		}
		System.out.println(maxSteps(N));
	}
	public static int maxSteps(int i) {
		if(dp[i] == null) {
			dp[i] = steps[i] + Math.max(maxSteps(i-2), maxSteps(i-3) + steps[i-1]); 
		}
		return dp[i];
	}
}
