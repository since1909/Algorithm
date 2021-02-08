import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class boj11047 {
	public static int N;
	public static int K;
	public static int[] A;
	public static int ans = 0;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int[N];
		
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = N-1; i >= 0; i--) {
			if(K / A[i] == 0) {
				continue;
			}
			else {
				ans += K / A[i];
				K = K % A[i];
			}
		}
		
		System.out.println(ans);
	}
}
