import java.io.*;
import java.util.*;

public class boj11399 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int[] answer = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		answer[0] = arr[0];
		int total = arr[0];
		for(int i = 1; i < N; i++) {
			answer[i] = answer[i-1]+arr[i];
			total += answer[i];
		}
		System.out.println(total);
	}
}
