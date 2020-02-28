import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1300_K��°��_200226 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		int left = 1;
		int right = k; // min(10^9, n^2), right�� k�� �δ� ���� : k��°���� �ƹ��� Ŀ���� k���ٴ� ���ų� �۴�
		while(left <= right) {
			int mid = (left + right) / 2;
			int count = 0;
			
			for(int i = 1; i <= n; i++) {
				count += Math.min(n, mid / i); // mid���� ���� ���� ������ ���ϴ� ����
			}
			
			if(count < k) left = mid + 1;
			else right = mid - 1;
		}
		
		System.out.println(left);
	}
}
