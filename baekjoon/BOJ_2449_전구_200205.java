import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2449_전구_200205 {
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[n][n];
		
		for(int i = 0; i < n - 1; i++) {
			if(arr[i] != arr[i + 1])
				dp[i][i + 1] = 1;
		}

		for(int sub = 2; sub <= n - 1; sub++) {
			for(int i = 0; i < n - sub; i++) {
				int j = i + sub;
				int min = Integer.MAX_VALUE;
				for(int m = i; m <= j - 1; m++) {
					int tmp = 1;
					if(arr[i] == arr[j]) {
						tmp = 0;
					}
					min = Math.min(dp[i][m] + dp[m + 1][j] + tmp, min);
				}
				dp[i][j] = min;
			}
		}

		System.out.println(dp[0][n - 1]);
	}
}
