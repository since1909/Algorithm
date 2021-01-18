import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class boj1904 {
	public static int N;
	public static int[] DP = new int[1000001];
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		DP[0] = 0;
		DP[1] = 1;
		DP[2] = 2;
		
		for(int i = 3; i < DP.length; i++) {
			DP[i] = -1;
		}
		System.out.println(Tile(N));
		
	}
	
	public static int Tile(int N) {
		if(DP[N] == -1) {
			DP[N] = Tile(N-1) + Tile(N-2);
		}
		
		return DP[N] % 15746;
	}
}