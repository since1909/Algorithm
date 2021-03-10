import java.io.*;
import java.util.*;

public class boj4949 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> paren = new Stack<>();
		while(true) {
			String str = br.readLine();
			if(str.equals(".")) {
				return;
			}
			int count = 0;
			for(int j = 0; j < str.length(); j++){
				if(str.charAt(j) == '(') {
					paren.push('(');
				}
				else if(str.charAt(j) == '[') {
					paren.push('[');
				}
				else if(str.charAt(j) == ')') {
					if(!paren.empty() && paren.peek() == '(') {
						paren.pop();
					}
					else {
						count++;
						break;
					}
				}
				else if(str.charAt(j) == ']') {
					if(!paren.empty() && paren.peek() == '[' ) {
						paren.pop();	
					}
					else {
						count++;
						break;
					}
				}
			}
			if(paren.empty() && count == 0) {
				System.out.println("yes");
			}
			else {
				System.out.println("no");
			}
			paren.clear();
		}
	}
}
