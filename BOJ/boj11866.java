import java.util.*;
import java.io.*;

public class boj11866 {
	public static int N;
	public static int K;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int cnt = 1;
		while(queue.size() > 1) {
			if(cnt % K != 0) {
				queue.add(queue.peek());
				queue.poll();
				cnt++;
			}
			else {
				sb.append(queue.peek()).append(", ");
				queue.poll();
				cnt = 1;
			}
		}
		sb.append(queue.peek()).append(">");
		System.out.println(sb);
	}
}
