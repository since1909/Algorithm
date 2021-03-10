import java.util.*;
import java.io.*;

public class boj10828 {
	public static int N;
	public static int[] stack;
	public static int size = 0;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		stack = new int[N];
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			switch(st.nextToken()) {
			
			case "push":
				push(Integer.parseInt(st.nextToken()));
				break;
				
			case "pop":
				sb.append(pop()).append("\n");
				break;
				
			case "size":
				sb.append(size).append("\n");
				break;
				
			case "empty":
				sb.append(empty()).append("\n");
				break;
				
			case "top":
				sb.append(top()).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}
	
	public static void push(int n) {
		stack[size] = n;
		size++;
	}
	public static int pop() {
		if(size == 0) {
			return -1;
		}
		else {
			int top = stack[size-1];
			stack[size-1] = 0;
			size--;
			return top;
		}
	}
	public static int empty() {
		if(size == 0) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public static int top() {
		if(size == 0) {
			return -1;
		}
		else {
			return stack[size-1];
		}
	}
	
}
