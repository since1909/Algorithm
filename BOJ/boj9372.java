package BOJ;

import java.io.*;
import java.util.*;

public class boj9372 {
	public static int T;
	public static int N, M;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		//MST에서 cost가 모두 0인 최소비용은 nodeCount - 1 == edgeCount
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			sb.append(N-1).append("\n");
			for(int j = 0; j < M; j++) br.readLine();
		}
		
		System.out.print(sb);
	}
}
