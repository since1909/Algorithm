import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;
import java.io.IOException;

public class boj1931 {
	public static int N;
	public static int[][] times;
	public static int answer = 0;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		times = new int[N][2];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			times[i][0] = Integer.parseInt(st.nextToken());
			times[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(times, new Comparator<int[]>(){
			@Override
			public int compare(int[] t1, int[] t2) {
				if(t1[1] == t2[1]) {
					return t1[0] - t2[0];
				}
				return t1[1] - t2[1];
			}
		});
		int endTime = 0;
		for(int i = 0; i < N; i++) {
			if(endTime <= times[i][0]) {
				endTime = times[i][1];
				answer++;
			}
		}
		System.out.println(answer);
		
	}
}
