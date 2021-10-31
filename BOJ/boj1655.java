package BOJ;

//최대힙 최소힙으로 중간값 찾는 알고리즘
import java.io.*;
import java.util.*;

public class boj1655 {
	public static int N;
	public static PriorityQueue<Integer> maxHeap;
	public static PriorityQueue<Integer> minHeap;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		maxHeap = new PriorityQueue<>((o1, o2) -> (o2 - o1));
		minHeap = new PriorityQueue<>();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			if(i % 2 == 0) {
				maxHeap.add(Integer.parseInt(br.readLine()));
			}
			else {
				minHeap.add(Integer.parseInt(br.readLine()));	
			}
			
			if(!maxHeap.isEmpty() && !minHeap.isEmpty()) {
				if(maxHeap.peek() > minHeap.peek()) {
					minHeap.add(maxHeap.poll());
					maxHeap.add(minHeap.poll());
				}
			}
			
			sb.append(maxHeap.peek()).append("\n");
		}
		System.out.println(sb);
		
	}
}
