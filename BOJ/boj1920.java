package BOJ;

import java.io.*;
import java.util.*;

public class boj1920 {
	public static int N, M;
	public static int[] arr, tmp;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int left = 0;
			int right = N-1;
			
			int num = Integer.parseInt(st.nextToken());
			int flag = 0;
			
			while(left <= right) {
				int mid = (left + right) / 2;
				
				if(arr[mid] == num) {
					flag = 1;
					break;
				}
				else if(arr[mid] > num) right = mid - 1;
				else if(arr[mid] < num) left  = mid + 1;
			}
			
			sb.append(flag).append("\n");
		}
		
		System.out.print(sb);
	}
}
