import java.io.*;
import java.util.*;

public class boj9012 {
	public static int N;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		Stack<Character> paren = new Stack<>();
		String str;
		for(int i = 0; i < N; i++) {
			str = br.readLine();
			int count = 0;
			for(int j = 0; j < str.length(); j++){
				if(str.charAt(j) == '(') {
					paren.push('(');
					count++;
				}
				if(str.charAt(j) == ')' && !paren.empty()) {
					paren.pop();
					count++;
				}
			}
			if(paren.empty() && count == str.length()) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
			paren.clear();
		}
	}
}
