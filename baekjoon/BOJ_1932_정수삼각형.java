import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1932_�����ﰢ�� {
	static int arr[][] ;
	static int dp[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int ans = 0;
		
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		dp = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < i + 1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = arr[0][0];
		
		/**
		 * 7 0 0 0 0
		 * 3 8 0 0 0
		 * 8 1 0 0 0
		 * 2 7 4 4 0
		 * 4 5 2 6 5
		 */
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i + 1; j++) {
				// ���� ���� ������ + �ڱ��ڽ�
				if(j == 0) {
					dp[i][0] = arr[i][0] + dp[i - 1][0];
				} else { // ��� Ÿ�� �������°� �� Ŭ��
					dp[i][j] = Math.max(dp[i - 1][j] + arr[i][j], dp[i - 1][j - 1] + arr[i][j]);
				}
				
				if(i == n - 1 && dp[i][j] > ans) { // �� �ؿ��� ���� ū��
					ans = dp[i][j];
				}
				
			}
		}
		
		System.out.println(ans);
		
	}

}
