import java.util.*;
import java.io.*;

public class boj1966 {
	public static int T;
	public static int N, M;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		LinkedList<int[]> printer;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < T; i++) {
			printer = new LinkedList<>();
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				printer.offer(new int[] {j, Integer.parseInt(st.nextToken())});
			}
			
			int count = 0;
			while(!printer.isEmpty()) {
				int [] front = printer.poll();
				boolean isMax = true;
				for(int k = 0; k < printer.size(); k++) {
					if(front[1] < printer.get(k)[1]) {
						printer.offer(front);
						for(int l = 0; l < k; l++) {
							printer.offer(printer.poll());
						}
						isMax = false;
						break;
					}
				}
				if(isMax) {
					count++;
					if(front[0] == M) {
						break;
					}
				}
			}
			sb.append(count).append("\n");	
		}
		System.out.println(sb);
	}
}
