package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2240_자두나무_200407 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int t = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<>();
		int[] arr = new int[t];
		int before = 1;
		for(int i = 0; i < t; i++) {
			int num = Integer.parseInt(br.readLine()) - 1;
			arr[i] = num;
			if(before != num) {
				list.add(i);
				before = num;
			}
		}
		
		int[][][] dp = new int[2][t][w + 1];
		if(arr[0] == 0) dp[0][0][0] = 1;
		else {
			dp[1][0][1] = 1;

		}
		for(int i = 1; i < t; i++) {
			for(int j = 0; j < 2; j++) {
				for(int k = 0; k <= w; k++) {
					if(arr[i] == j) {
						if(arr[i] == arr[i - 1]) {
							dp[j][i][k] = dp[j][i - 1][k] + 1;
						} else {
							if(k == 0) dp[j][i][k] = dp[j][i - 1][k] + 1;
							else dp[j][i][k] = Math.max(dp[j][i - 1][k], dp[j ^ 1][i - 1][k - 1]) + 1;
						}
					} else {
						if(arr[i] == arr[i - 1]) {
							dp[j][i][k] = dp[j][i - 1][k];
						} else {
							dp[j][i][k] = dp[j][i - 1][k];
						}
					}
				}
			}
		}
		
		int ans = 0;
		for(int i = 0; i <= w; i++) {
			if(ans < dp[0][t - 1][i]) ans = dp[0][t - 1][i];
			if(ans < dp[1][t - 1][i]) ans = dp[1][t - 1][i];
		}
		System.out.println(ans);
	}
}
