import java.util.Scanner;

public class SWEA_Solution_3307_최장증가부분수열_D3_천용진 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int testCase = 1; testCase <= TC; testCase++) {
			int n = sc.nextInt();
			int max = 0;
			int[] array = new int[n];
			for(int i = 0; i < n; i++) {
				array[i] = sc.nextInt();
			}
			
			int[] dp = new int[n];
			for(int i = 0; i < n; i++) dp[i] = 1;
			
			for(int i = 1; i < n; i++) {
				for(int j = 0; j < i; j++) {
					if(array[i] >= array[j]) {
						if(dp[j] >= dp[i]) {
							if(dp[j] + 1 <= i + 1) {
								dp[i] = dp[j] + 1;
							}
						}
					}
				}
			}
			
//			for(int i = 0; i < n; i++) {
//				System.out.println(dp[i]);
//			}
//			
			for(int i = 0; i < n; i++) {
				if(max < dp[i]) max = dp[i];
			}
			System.out.println("#" + testCase + " " + max);
		}
	} // end of for testCase
} // end of main