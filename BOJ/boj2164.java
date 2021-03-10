import java.io.*;
import java.util.*;

public class boj2164 {
	public static int N;

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		int cnt = 0;
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		while(queue.size() > 1) {
			if(cnt % 2 == 0) {
				queue.poll();
				cnt++;
			}
			else {
				queue.add(queue.peek());
				queue.poll();
				cnt++;
			}
		}
		System.out.print(queue.peek());
	}
}
