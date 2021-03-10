import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class boj1541 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = Integer.MAX_VALUE;
		StringTokenizer sub = new StringTokenizer(br.readLine(), "-");
		
		while(sub.hasMoreTokens()) {
			StringTokenizer plus = new StringTokenizer(sub.nextToken(), "+");
			
			int subSum = 0;
			while(plus.hasMoreTokens()) {
				subSum += Integer.parseInt(plus.nextToken());
			}
			
			if(sum == Integer.MAX_VALUE) {
				sum = subSum;
			}
			else {
				sum -= subSum;
			}
		}
		System.out.println(sum);
	}
}
