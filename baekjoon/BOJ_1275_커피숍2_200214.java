package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1275_커피숍2_200214 {
	static long[] tree;
	static long[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int h = (int)Math.ceil(Math.log(n) / Math.log(2)) + 1;
		
		tree = new long[1 << h];
		arr = new long[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			arr[i] = (long)Integer.parseInt(st.nextToken());
		}
		
		init(0, 0, n - 1);
		
		int left = 0;
		int right = 0;
		int changedIndex = 0;
		long changeNum = 0;
		long sum = 0;
		for(int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			left = Integer.parseInt(st.nextToken()) - 1;
			right = Integer.parseInt(st.nextToken()) - 1;
			if(left > right) {
				left = left ^ right;
				right = left ^ right;
				left = left ^ right;
			}
			sum = sum(0, 0, n - 1, left, right);
			sb.append(sum).append('\n');
			changedIndex = Integer.parseInt(st.nextToken()) - 1;
			changeNum = (long)Integer.parseInt(st.nextToken());
			update(changedIndex, changeNum - arr[changedIndex], 0, 0, n - 1);
			arr[changedIndex] = changeNum;
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
	
	public static long sum(int index, int start, int end, int left, int right) {
		if(start > right || end < left) {
			return 0;
		} else if(left <= start && right >= end) {
			return (long)tree[index];
		} else {
			int mid = (start + end) / 2;
			return sum(index * 2 + 1, start, mid, left, right) + sum(index * 2 + 2, mid + 1, end, left, right);
		}
	}
	
	public static void update(int changedIndex, long diff, int index, int start, int end) {
		if(start > changedIndex || end < changedIndex) {
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
