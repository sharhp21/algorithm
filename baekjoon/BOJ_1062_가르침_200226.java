import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1062_����ħ_200226 {
	static int[] check;
	static char[][] arr;
	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		arr = new char[n][16];
		check = new int[26];
		// �׻� �ִ� ���ԵǾ� �ִ� ���� check
		check['a' - 'a'] = check['c' - 'a'] = check['i' - 'a'] = check['n' - 'a'] = check['t' - 'a'] = 1;
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		// k < 5�� �ƹ��͵� ������
		if (k < 5) {
			System.out.println(0);
			return;
		}
		
		// k >= 5
		k -= 5;
		comb(k, 0);
		System.out.println(max);
	}
	
	public static void comb(int k, int x) {
		if(k == 0) {
			ableToRead();
			return;
		}
		
		for(int i = x; i < 26; i++) {
			if(check[i] == 0) {
				check[i] = 1;
				comb(k - 1, i + 1);
				check[i] = 0;
			}
		}
	}
	
	public static void ableToRead() {
		int cnt = 0;
		for(int i = 0; i < arr.length; i++) {
			int flag = 0;
			for(int j = 0; j < arr[i].length; j++) {
				if(check[arr[i][j] - 'a'] == 0) { // ������ break
					flag = 1;
					break;
				}
			}
			if(flag == 0) cnt++; // �� �ִٸ� �ϳ� ����
 		}
		if(max < cnt) max = cnt;
	}
}
