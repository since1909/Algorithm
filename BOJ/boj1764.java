package BOJ;

import java.io.*;
import java.util.*;

public class boj1764 {
	public static int N, M;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		HashSet<String> hs = new HashSet<>();
		while(N-- > 0) {
			hs.add(br.readLine());
		}
		
		LinkedList<String> arr = new LinkedList<>();
		int count = 0;
		while(M-- > 0) {
			String name = br.readLine();
			if(hs.contains(name)) {
				count++;
				arr.add(name);
			}
		}
		
		Collections.sort(arr);
		System.out.println(count);
		for(String s : arr) {
			System.out.println(s);
		}
	}
}
