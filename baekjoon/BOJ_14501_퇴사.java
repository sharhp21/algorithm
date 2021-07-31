import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501_��� {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		int[] dp = new int[n];
		int ans = 0;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			if(arr[i][0] + i <= n) {
				arr[i][1] = Integer.parseInt(st.nextToken());
			} else {
				st.nextToken();
				// ���޴� �ݾ�
				arr[i][1] = 0;
			}
			
			// �ʱ�ȭ
			dp[i] = arr[i][1];
		}
		
		/*
		3 10
		5 20
		1 10
		1 20
		2 15
		4 40
		2 200
		*/
		
	   // 3 5 1 1 2 4 2
	   // 10 20 10 20 15 0 0
	   // 10 20 10 30 45
	   
	   
		for(int i = 1; i < n; i++) {
			// ���� index ���鼭 �� ū�� ã��
			for(int j = 0; j < i; j++) {
				// �Ⱓ�� ��ġ�� �ȵ�
				if(arr[j][0] + j <= i) {
					dp[i] = Math.max(dp[j] + arr[i][1], dp[i]);
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			ans = (ans < dp[i]) ? dp[i] : ans;
		}
		
		System.out.println(ans);
	}
}
