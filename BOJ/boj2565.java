import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class boj2565 {
	public static int N;
	public static int[][] wires;
	public static Integer[] dp;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new Integer[N];
		wires = new int[N][2];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			 st = new StringTokenizer(br.readLine(), " ");
			 wires[i][0] = Integer.parseInt(st.nextToken());
			 wires[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//오름차순 정렬
		Arrays.sort(wires, new Comparator<int[]>() {
			@Override
			public int compare(int[] w1, int[] w2) {
				return w1[0] - w2[0];
			}
		});
		
		//오름차순 부분 수열찾기
		for(int i = 0; i < N; i++) {
		    dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(wires[j][1] < wires[i][1] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j]+1;
				}
			}
		}
		
		int max = -1;
		for(int i = 0; i < N; i++) {
			max = dp[i] > max ? dp[i] : max;
		}
		System.out.println(N-max);
	}
}
