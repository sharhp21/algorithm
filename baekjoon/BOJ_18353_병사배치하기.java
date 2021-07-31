import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * LIS algorithm
 */
public class BOJ_18353_병사배치하기 {
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
		
		LIS.add(arr[0]); // 처음값은 넣어줌
		
		for(int i = 1; i < n; i++) {
			int idx = lowerBound(arr[i]);
			if (LIS.size() <= idx) { // list에 num보다 더 작은 값이 없으면, list 뒤에 추가해줌
				LIS.add(arr[i]);
			} else { // 더 큰 값으로 갈아낌
				LIS.remove(idx);
				LIS.add(idx, arr[i]);
			}
		}
		
		// 열외
		System.out.println(n - LIS.size());
	}
	
	// 이분탐색 num이 들어갈 index 찾기
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
