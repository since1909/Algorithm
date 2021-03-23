import java.io.*;
import java.util.*;

public class boj20055 {
	public static int N, K;
	public static int[] belt;
	public static boolean[] robot;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		belt = new int[2*N];
		robot = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 2*N; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}
		int k = K;
		int ans = 0;
		while(true) {
			K = k;
			//rotate belt & robot
			int tmp = belt[2*N -1];
			for(int i = 2*N -1; i > 0; i--) {
				belt[i] = belt[i-1];
			}
			belt[0] = tmp;
			for(int i = N-1; i > 0; i--) {
				robot[i] = robot[i-1];
			}
			robot[0] = false;
			robot[N-1] = false;
			
			//move robot
			for(int i = N-1; i > 0; i--) {
				if(!robot[i] && robot[i-1] && belt[i] > 0) {
					robot[i] = true;
					robot[i-1] = false;
					belt[i]--;
				}
			}
			
			//load robot
			if(!robot[0] && belt[0] > 0) {
				robot[0] = true;
				belt[0]--;
			}
			
			//count zero
			for(int i = 0; i < 2*N; i++) {
				if(belt[i] == 0) K--;
			}
			
			if(K <= 0) {
				ans++;
				break;
			}else {
				ans++;
			}
		}
		
		System.out.println(ans);
		
	}
}
