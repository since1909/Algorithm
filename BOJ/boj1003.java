import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class boj1003 {
	public static int zeroCount;
	public static int oneCount;
	public static int zeroPlusOne;
	public static void fib(int num) {
		zeroCount = 1;
		oneCount = 0;
		zeroPlusOne = 1;
		for(int i = 0; i < num; i++) {
			zeroCount = oneCount;
			oneCount = zeroPlusOne;
			zeroPlusOne = zeroCount + oneCount;
		}
		
	}
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			fib(num);
			sb.append(zeroCount).append(" ").append(oneCount).append("\n");
		}
		System.out.println(sb);
	}
}