import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2775_부녀회장이될테야_200205 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int testcase = 1; testcase <= TC; testcase++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			int[][] dp = new int[k + 1][n];
			for(int i = 0; i < n; i++) {
				dp[0][i] = i + 1;
			}
			
			for(int i = 0; i < k + 1; i++) {
				dp[i][0] = dp[0][0];
			}
			
			for(int i = 1; i < k + 1; i++) {
				for(int j = 1; j < n; j++) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
			
			System.out.println(dp[k][n - 1]);
		}
	}
}
