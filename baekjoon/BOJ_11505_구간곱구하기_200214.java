package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11505_구간곱구하기_200214 {
	static long[] arr;
	static long[] tree;
	final static long MOD = 1000000007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int h = (int)Math.ceil(Math.log(n) / Math.log(2)) + 1;
		tree = new long[1<<h];
		Arrays.fill(tree, 1);
		arr = new long[n];
		for(int i = 0; i < n; i++) {
			arr[i] = (long)Integer.parseInt(br.readLine());
		}
		
		init(0, 0, n - 1);
		
		long res = 1;
		for(int i = 0; i < m + k; i++) {
//			System.out.println(Arrays.toString(arr));
//			System.out.println(Arrays.toString(tree));
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a == 1) {
				update(b - 1, c, 0, 0, n - 1);
				arr[b - 1] = c;
			} else if(a == 2) {
				res = multiply(0, 0, n - 1, b - 1, c - 1) % MOD;
				sb.append(res).append('\n');
			}
		}
		
		System.out.print(sb);
	}
	
	public static long init(int index, int start, int end) {
		if(start == end) {
			return tree[index] = arr[start];
		}
		
		int mid = (start + end) / 2;
		
		tree[index] = (tree[index] * init(index * 2 + 1, start, mid)) % MOD;
		tree[index] = (tree[index] * init(index * 2 + 2, mid + 1, end)) % MOD;
		
		return tree[index];
	}
	
	public static long multiply(int index, int start, int end, int left, int right) {
		if(start > right || end < left) {
			return 1;
		} else if(start >= left && end <= right) {
			return tree[index];
		} else {
			int mid = (start + end) / 2;
			return (multiply(index * 2 + 1, start, mid, left, right) * multiply(index * 2 + 2, mid + 1, end, left, right)) % MOD;
		}
	}
	
	public static void update(int changeIndex, int diff, int index, int start, int end) {
		if(changeIndex < start || changeIndex > end) {
			return;
		}
		
		if(start == end) tree[index] = diff;
		
		if(start != end) {
			int mid = (start + end) / 2;
			update(changeIndex, diff, index * 2 + 1, start, mid);
			update(changeIndex, diff, index * 2 + 2, mid + 1, end);
			tree[index] = (tree[index * 2 + 1] * tree[index * 2 + 2]) % MOD;
		}
	}
}
