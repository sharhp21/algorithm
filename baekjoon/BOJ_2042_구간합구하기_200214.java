package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2042_구간합구하기_200214 {
	static long[] tree;
	static long[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int h = (int)Math.ceil(Math.log(n) / Math.log(2)) + 1;
		tree = new long[1 << h];
		arr = new long[n];
		for(int i = 0; i < n; i++) {
			arr[i] = (long)Integer.parseInt(br.readLine());
		}
		
		init(0, 0, n - 1);
		
		for(int i = 0; i < m + k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Integer.parseInt(st.nextToken());
			
			if(a == 1) {
				update(b - 1, c - arr[b - 1], 0, 0, n - 1);
				arr[b - 1] = c;
			} else if(a == 2) {
				long ans = sum(0, 0, n - 1, b - 1, (int)c - 1);
				sb.append(Long.toString(ans) + '\n');
			}
		}
		
		System.out.print(sb);
	}
	
	public static long init(int index, int start, int end) {
		if(start == end) {
			return tree[index] = arr[start];
		}
		
		int mid = (start + end) / 2;
		
		tree[index] += init(index * 2 + 1, start, mid);
		tree[index] += init(index * 2 + 2, mid + 1, end);

		return tree[index];
	}
	
	// left ~ right, 구간합을 구할 구간
	public static long sum(int index, int start, int end, int left, int right) {
		if(start > right || end < left) {
			return 0;
		} else if(start >= left && right >= end) {
			return tree[index];
		} else {
			int mid = (start + end) / 2;
			return sum(index * 2 + 1, start, mid, left, right) + sum(index * 2 + 2, mid + 1, end, left, right);
		}
	}
	
	// 값 바꾸기 - diff는 바꿀 값 - 바뀌기 전의 수임
	public static void update(int changedIndex, long diff, int index, int start, int end) {
		if(changedIndex < start || changedIndex > end) {
			return;
		}
		
		tree[index] += diff;
		
		if(start != end) {
			int mid = (start + end) / 2;
			update(changedIndex, diff, index * 2 + 1, start, mid);
			update(changedIndex, diff, index * 2 + 2, mid + 1, end);
		}
	}
}
