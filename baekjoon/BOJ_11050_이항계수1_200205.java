import java.util.Scanner;

public class BOJ_11050_이항계수1_200205 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int k = input.nextInt();
		
		int[][] dp = new int[n - k + 1][k + 1];
		
		for(int i = 0; i <= n - k; i++) {
			dp[i][0] = 1;
		}
		for(int i = 0; i <= k; i++) {
			dp[0][i] = 1;
		}
		
		for(int i = 1; i <= n - k; i++) {
			for(int j = 1; j <= k; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		
		System.out.println(dp[n - k][k]);
	}
}
