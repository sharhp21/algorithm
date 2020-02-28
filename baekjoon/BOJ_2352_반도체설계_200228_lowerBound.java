import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2352_�ݵ�ü����_200228_lowerBound {
	static int[] arr;
	static int ans = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int index = 0;
		for(int i = 0; i < n; i++) {
			int x = Integer.parseInt(st.nextToken());
			if(x > arr[index]) { // �� �������� x�� ũ�� ���� ���� +1
				arr[++index] = x;
				ans++;
			} else { // �׷��� ������ x�̻��� ���� ó������ ������ �ִ� index�� ã�� �� ����
				int it = lowerBound(index, x);
				arr[it] = x;
			}
		}
		
		System.out.print(ans);
	}
	
	public static int lowerBound(int index, int x) { // �̺�Ž������ x�̻��� ��ġ�� ã��
		int left = 1;
		int right = index;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(arr[mid] < x) left = mid + 1;
			else if(arr[mid] > x) right = mid - 1;
			else {
				left = mid;
				break;
			};
		}
		
		return left;
	}
}
