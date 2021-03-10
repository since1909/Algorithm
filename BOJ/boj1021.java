import java.util.*;
import java.io.*;

public class boj1021 {
	public static int N, M;
	public static int[] arr;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		LinkedList<Integer> deque = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			deque.offer(i);
		}
		
		int count = 0;
		int answer = 0;
		while(count < M) {
			int index = deque.indexOf(arr[count]);
			if( index <= deque.size()/2) {
				for(int i = 0; i < index; i++) {
					deque.addLast(deque.peekFirst());
					deque.pollFirst();
					answer++;
				}
				deque.pollFirst();
				count++;
			}
			else {
				for(int i = deque.size()-1; i > index; i--) {
					deque.addFirst(deque.peekLast());
					deque.pollLast();
					answer++;
				}
				deque.pollLast();
				answer++;
				count++;
			}
		}
		System.out.println(answer);
	}
}
