package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10868_최솟값_200214 {
	static int[] treeMin;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int h = (int)Math.ceil(Math.log(n) / Math.log(2)) + 1;
		treeMin = new int[1 << h];
		arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		initMin(0, 0, n - 1);
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int min = min(0, 0, n - 1, start, end);
			sb.append(min).append('\n');
		}
		
		System.out.print(sb);
	}

	public static int initMin(int index, int start, int end) {
		if(start == end) {
			return treeMin[index] = arr[start];
		}
		
		int mid = (start + end) / 2;
		
		treeMin[index] = Math.min(initMin(index * 2 + 1, start, mid), initMin(index * 2 + 2, mid + 1, end));
		
		return treeMin[index];
	}

	public static int min(int index, int start, int end, int left, int right) {
		if(start > right || end < left) {
			return Integer.MAX_VALUE;
		} else if(start >= left && end <= right) {
			return treeMin[index];
		} else {
			int mid = (start + end) / 2;
			return Math.min(min(index * 2 + 1, start, mid, left, right), min(index * 2 + 2, mid + 1, end, left, right));
		}
	}
}
