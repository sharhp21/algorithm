package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1699_제곱수의합_200403 {
	static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		
		dp = new int[n + 1];
		for(int i = 1; i <= n; i++) dp[i] = Integer.MAX_VALUE;
		dp[1] = 1;
		for(int i = 2; i <= n; i++) {
			for(int j = 1; j*j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}
		}
		
		System.out.println(dp[n]);
	}
}
