import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * LIS algorithm
 */
public class BOJ_18353_�����ġ�ϱ� {
	static List<Integer> LIS;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		LIS = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		LIS.add(arr[0]); // ó������ �־���
		
		for(int i = 1; i < n; i++) {
			int idx = lowerBound(arr[i]);
			if (LIS.size() <= idx) { // list�� num���� �� ���� ���� ������, list �ڿ� �߰�����
				LIS.add(arr[i]);
			} else { // �� ū ������ ���Ƴ�
				LIS.remove(idx);
				LIS.add(idx, arr[i]);
			}
		}
		
		// ����
		System.out.println(n - LIS.size());
	}
	
	// �̺�Ž�� num�� �� index ã��
	public static int lowerBound(int num) {
		int start = 0;
		int end = LIS.size();
		int mid;
		while(start < end) {
			mid = (start + end) / 2;
			if(LIS.get(mid) > num) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return end;
	}
}
