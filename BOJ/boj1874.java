import java.io.*;
import java.util.*;

public class boj1874 {
	public static int N;
	public static int[] arr;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr =  new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		for(int j = 1; j <= N;) {
			if(!stack.empty() && arr[i] == stack.peek()) {
				stack.pop();
				sb.append("-").append("\n");
				i++;
			}
			else {
				stack.push(j);
				sb.append("+").append("\n");
				j++;
			}
		}
		while(!stack.empty()) {
			if(stack.peek() != arr[i]) {
				System.out.println("NO");
				break;
			}
			else {
				stack.pop();
				sb.append("-").append("\n");
			}
			i++;
		}
		if(stack.empty()) {
			System.out.print(sb);
		}
	}
}
