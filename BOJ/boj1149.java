import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class boj1149 {
	public static int N;
	public static int[][] cost;
	public static int[][] dp;
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = new int[N][3];
		dp =  new int[N][3];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		}
		
		dp[0][0] = cost[0][0];
		dp[0][1] = cost[0][1];
		dp[0][2] = cost[0][2];
		
		int ans = Math.min(minCost(N-1, 0), Math.min(minCost(N-1, 1), minCost(N-1, 2)));
		System.out.println(ans);
	}
	
	public static int minCost(int N, int color) {
		if (dp[N][color] == 0) {
			if(color == 0) {
				dp[N][color] = cost[N][color] + Math.min(minCost(N-1, 1), minCost(N-1, 2));
			}
			else if(color == 1) {
				dp[N][color] = cost[N][color] + Math.min(minCost(N-1, 0), minCost(N-1, 2));
			}
			else {
				dp[N][color] = cost[N][color] + Math.min(minCost(N-1, 0), minCost(N-1, 1));
			}
		}
		return dp[N][color];
	}
}
