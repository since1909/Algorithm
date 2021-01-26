import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class boj11054 {
	public static int N;
	public static int[] A;
	public static int[] dpUp;
	public static int[] dpDown;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		dpUp = new int[N];
		dpDown = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			dpUp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(A[j] < A[i] && dpUp[i] < dpUp[j] + 1) {
					dpUp[i] = dpUp[j] + 1;
				}
			}
		}
		for(int i = N-1; i >= 0; i--) {
			dpDown[i] = 1;
			for(int j = N-1; j > i; j--) {
				if(A[j] < A[i] && dpDown[i] < dpDown[j] + 1) {
					dpDown[i] = dpDown[j] + 1;
				}
			}
		}
		int max = -1;
		for(int i = 0; i < N; i++) {
			if(max < dpUp[i] + dpDown[i]) {
				max = dpUp[i] + dpDown[i];
			}
		}
		System.out.println(max-1);
	}
}
