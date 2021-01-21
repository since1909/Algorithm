import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class boj2156 {
	public static int N;
	public static int[] wine;
	public static Integer[] dp;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		wine = new int[N+1];
		dp = new Integer[N+1];
		for(int i = 1; i < N+1; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		dp[0] = 0;
		dp[1] = wine[1];
		if(N > 1) {
			dp[2] = wine[1] + wine[2];
		}
		System.out.println(recur(N));
		
	}
	public static int recur(int index) {
		if(dp[index] == null) {
			//계단 오르기와의 차이점:
			//마지막 계단을 밟아야 한다는 조건 없음
			//이전의 와인잔에서 이미 최대일 경우도 챙겨줘야함
			dp[index] = Math.max(recur(index-1), wine[index] + Math.max(recur(index-2), recur(index-3) + wine[index-1]));
		}
		return dp[index];
	}
}
