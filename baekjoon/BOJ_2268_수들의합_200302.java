import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2268_수들의합_200302 {
	static long[] tree;
	static long[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int h = (int)Math.ceil(Math.log(n) / Math.log(2)) + 1;
		tree = new long[1 << h];
		arr = new long[n];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int flag = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(flag == 0) { // sum
				long res = 0;
				if(a > b) res = sum(0, 0, n - 1, b - 1, a - 1);
				else res = sum(0, 0, n - 1, a - 1, b - 1);
				sb.append(res).append('\n');
			} else { // modify
				modify(a - 1, (long)b - arr[a - 1], 0, 0, n - 1);
				arr[a - 1] = b;
			}
		}
		
		System.out.print(sb);
	}
	
	public static long sum(int index, int start, int end, int left, int right) {
		if(start > right || end < left) {
			return 0;
		} else if(start >= left && end <= right) {
			return tree[index];
		} else {
			int mid = (start + end) / 2;
			return sum(index * 2 + 1, start, mid, left, right) + sum(index * 2 + 2, mid + 1, end, left, right);
		}
	}
	
	public static void modify(int changedIndex, long diff, int index, int start, int end) {
		if(changedIndex < start || changedIndex > end) {
			return;
		}
		
		tree[index] += diff;
		
		if(start != end) {
			int mid = (start + end) / 2;
			modify(changedIndex, diff, index * 2 + 1, start, mid);
			modify(changedIndex, diff, index * 2 + 2, mid + 1, end);
		}
	}
}
