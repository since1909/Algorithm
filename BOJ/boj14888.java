import java.util.Scanner;

public class boj14888 {
	public static int N;
	public static int[] nums;
	public static int[] op = new int[4];
	public static int MAX = Integer.MIN_VALUE;
	public static int MIN = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		nums = new int[N];
		for(int i = 0; i < N; i++) {
			nums[i] = in.nextInt();
		}
		for(int i = 0; i < 4; i++) {
			op[i] = in.nextInt();
		}
		findMax(1, nums[0]);
		
		System.out.println(MAX);
		System.out.println(MIN);
	}
	
	public static void findMax(int depth, int num) {
		if(depth == N) {
			MAX = Math.max(MAX, num);
			MIN = Math.min(MIN, num);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(op[i] > 0) {
				op[i]--;
				switch(i){
					case 0: findMax(depth + 1,num + nums[depth]); break;
					case 1: findMax(depth + 1,num - nums[depth]); break;
					case 2: findMax(depth + 1,num * nums[depth]); break;
					case 3: findMax(depth + 1, (int)(num / nums[depth])); break;
				}
				op[i]++;
			}
		}
	}

}
