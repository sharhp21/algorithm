package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public interface BOJ_1328_고층빌딩_200409 {
	static long mod = 1000000007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		long[][][] dp = new long[n + 1][l + 1][r + 1];
		
		dp[1][1][1] = 1;
		for(int i = 2; i <= n; i++) {
			for(int j = 1; j <= l; j++) {
				for(int k = 1; k <= r; k++) {
					if(j + k > n + 1) break;
					dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j - 1][k]) % mod;
					dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - 1]) % mod;
					dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k] * (i - 2) % mod) % mod;
				}
			}
		}
		
		System.out.println(dp[n][l][r] % mod);
	}
}
