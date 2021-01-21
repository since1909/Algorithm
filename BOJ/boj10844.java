import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class boj10844 {
	public static int N;
	public static Long[][] dp;
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new Long[N+1][10];
		for(int i = 0; i < 10; i++) {
			dp[1][i] = 1L;
		}
		
		long ans = 0;
		for(int i = 1; i < 10; i++) {
			ans += steps(N, i);
		}
		System.out.println(ans % 1000000000);
	}
	public static long steps(int index, int value) {
		if(index == 1) {
			return dp[index][value];
		}
		if(dp[index][value] == null) {
			if(value == 0) {
				dp[index][value] = steps(index-1, 1);
			}
			else if(value == 9) {
				dp[index][value] = steps(index-1, 8);
			}
			else {
				dp[index][value] = steps(index-1, value-1) + steps(index-1, value+1);
			}
		}
		//N이 최대 100, 즉 자릿수만 100자리라 경우의 수일지라도 long타입을 벗어날 수 있다.(아니 벗어난다.) 
		//때문에 long 범위에서 벗어나지 않도록 각 return마다 나머지값을 return시켜주어야 한다.
		//(https://st-lab.tistory.com/134)
		return dp[index][value] % 1000000000;
	}
}
