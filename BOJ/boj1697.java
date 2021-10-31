package BOJ;

import java.io.*;
import java.util.*;

public class boj1697 {
	public static int N;
	public static int K;
	public static int[] visited = new int[100001];
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bfs();
		System.out.println(visited[K]);
	}
	
	public static Queue<Integer> q = new LinkedList<>();
	public static void bfs() {
		q.offer(N);
		
		while(!q.isEmpty()) {
			int pos = q.poll();
			
			if(pos == K) return;
			
			if(pos - 1 >= 0 && visited[pos - 1] == 0) {
				q.offer(pos - 1);
				visited[pos-1] = visited[pos] + 1;
			}
			
			if(pos + 1 <= 100000 && visited[pos + 1] == 0) {
				q.offer(pos + 1);
				visited[pos+1] = visited[pos] + 1;
			}
			
			if(pos * 2 <= 100000 && visited[pos * 2] == 0) {
				q.offer(pos * 2);
				visited[pos*2] = visited[pos] + 1;
			}
		}
	}
}