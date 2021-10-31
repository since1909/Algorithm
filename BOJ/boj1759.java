package BOJ;

import java.io.*;
import java.util.*;

public class boj1759 {
	public static int L, C;
	public static String[] arr;
	public static StringBuilder sb = new StringBuilder();
	
	public static boolean isVowel(String s) {
		String[] str = {"a", "e", "i", "o", "u"};
		return Arrays.stream(str).anyMatch(s::equals);
	}
	
	public static void recur(String str, int depth, int start, int vowel, int conso) {
		if(depth == L) {
			if(vowel >= 1 && conso >= 2) {
				sb.append(str).append("\n");
			}
			return;
		}
		
		if(start >= arr.length) return;
		
		if(isVowel(arr[start])) {
			recur(str + arr[start], depth + 1, start + 1, vowel + 1, conso);
		}
		else recur(str + arr[start], depth + 1, start + 1, vowel, conso+1);
		
		recur(str, depth, start + 1, vowel, conso);
	}
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new String[C];
		
		String[] strs = br.readLine().split(" ");
		for(int i = 0; i < strs.length; i++) arr[i] = strs[i];
		Arrays.sort(arr);
		
		String str = "";
		recur(str, 0, 0, 0, 0);
		System.out.println(sb);
		
	}
}
