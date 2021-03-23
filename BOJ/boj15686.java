import java.io.*;
import java.util.*;

public class boj15686 {
	public static int N, M;
	public static int min = Integer.MAX_VALUE;
	public static int[][] map;
	public static LinkedList<int[]> house = new LinkedList<>();
	public static LinkedList<int[]> chicken = new LinkedList<>();
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					house.add(new int[] {i, j});
				}
			}
		}
		chooseChicken(0, 0, 0);
		System.out.println(min);
	}
	
	private static void chooseChicken(int r, int c, int depth) {
		if(depth == M) {
			findMin(calculateDis());
			return;
		}
		for(int i = r; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i == r && j < c) continue;
				if(map[i][j]  == 2) {
					chicken.add(new int[] {i, j});
					chooseChicken(i, j+1, depth+1);
					chicken.pollLast();
				}
			}
		}
	}
	
	private static int calculateDis() {
		int disSum = 0;
		for(int i = 0; i < house.size(); i++) {
			int[] h = house.get(i);
			int min_c = Integer.MAX_VALUE;
			for(int j = 0; j < chicken.size(); j++) {
				int[] store = chicken.get(j);
				int dis = Math.abs(h[0] - store[0]) + Math.abs(h[1] - store[1]);
				if(dis < min_c) {
					min_c = dis;
				}
			}
			//System.out.print(min_c + " ");
			disSum += min_c;
		}
		return disSum;
	}
	
	private static void findMin(int sum) {
		if(sum < min) min = sum;
	}
}
