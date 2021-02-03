import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class boj1912 {
	public static int N;
	public static int[] arr;
	public static Integer[] dp;
	public static int max;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		dp = new Integer[N]; 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = arr[0];
		max = arr[0];
		
		seqSum(N-1);
		System.out.println(max);
	}
	
	public static int seqSum(int n) {
		if(dp[n] == null) {
			dp[n] = Math.max(seqSum(n-1) + arr[n], arr[n]);
			max = Math.max(max, dp[n]);
		}
		return dp[n];
	}
}
