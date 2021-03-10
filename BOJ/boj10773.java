import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj10773 {
	public static int N;

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		
		N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				stack.pop();
			}
			else {
				stack.push(num);
			}
		}
		int sum = 0;
		for(int i = 0; i < stack.size(); i++) {
			sum += stack.elementAt(i);
		}
		System.out.println(sum);
	}
}
