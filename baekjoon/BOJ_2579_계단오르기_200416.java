package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579_계단오르기_200416 {
	static int[] arr;
	static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		if(n == 1) {
			System.out.println(arr[1]);
			return;
		}
		
		dp = new int[n + 1];
		dp[1] = arr[1];
		dp[2] = arr[1] + arr[2];
		for(int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
		}

		System.out.println(dp[n]);
	}
}
