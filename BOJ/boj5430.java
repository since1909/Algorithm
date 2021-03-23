import java.util.*;
import java.io.*;

public class boj5430 {
	public static int T;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			String p = br.readLine();
			int N = Integer.parseInt(br.readLine());
			ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
			while(st.hasMoreTokens()) {
				deque.offer(Integer.parseInt(st.nextToken()));
			}
			
			String[] functions = p.split("");
			boolean isOkay = true;
			int count = 0;
			for(int i = 0; i < p.length(); i++) {
				if(!isOkay) {
					break;
				}
				switch(functions[i]) {
				case "R":
					count++;
					break;
				case "D":
					if(count % 2 == 0) {
						if(deque.pollFirst() == null) {
							sb.append("error\n");
							isOkay = false;
							break;
						}
					}
					else {
						if(deque.pollLast() == null) {
							sb.append("error\n");
							isOkay = false;
							break;
						}
					}
				}
			}
			if(!isOkay) {
				continue;
			}
			if(deque.isEmpty()) {
				sb.append("[]\n");
				continue;
			}
			StringBuilder subSb = new StringBuilder();
			subSb.append("[");
			if(count % 2 == 0) {
				while(!deque.isEmpty()) {
					subSb.append(deque.pollFirst()).append(",");
				}
			}
			else {
				while(!deque.isEmpty()) {
					subSb.append(deque.pollLast()).append(",");
				}
			}
			subSb.deleteCharAt(subSb.length()-1).append("]");
			sb.append(subSb).append("\n");
		}
		System.out.println(sb);
	}
}
