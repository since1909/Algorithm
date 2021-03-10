import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class boj13305 {
	public static int N;
	public static long[] path;
	public static long[] price;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		path = new long[N-1];
		price = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N-1; i++) {
			path[i] = Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			price[i] = Long.parseLong(st.nextToken());
		}
		
		long sum = 0;
		long min = price[0];
		
		for(int i = 0; i < N-1; i++) {
			if(price[i] < min) {
				min = price[i];
			}
			sum += price[i] * path[i];
		}
		System.out.println(sum);
	}
}
