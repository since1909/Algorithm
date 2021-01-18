import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class boj1932 {
	public static int N;
	public static int[][] cost;
	public static int[][] dp;
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = new int[N][N];
		dp =  new int[N][N];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j <= i; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			dp[N-1][i] = cost[N-1][i];
		}
		System.out.println(maxCost(0,0));
	}
	
	public static int maxCost(int i, int index) {
		if (i == N-1) return dp[i][index];
		if (dp[i][index] == 0) {
			dp[i][index] = cost[i][index] + Math.max(maxCost(i+1, index), maxCost(i+1, index+1));
		}
		return dp[i][index];
	}
}
