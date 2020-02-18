package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1395_스위치_200217 {
	static int[] tree;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int h = (int)Math.ceil(Math.log(n) / Math.log(2)) + 1;
		tree = new int[1<<h];
		arr = new int[n];
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int o = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			
			if(o == 0) { // s부터 t까지 스위치 반전
				update(0, 0, n - 1, s - 1, t - 1);
			} else { // s부터 t까지 켜져있는 스위치의 개수
				sb.append(sum(0, 0, n - 1, s - 1, t - 1)).append('\n');
			}
		}
		
		System.out.print(sb);
	}
	
	public static int sum(int index, int start, int end, int left, int right) {
		if(start > right || end < left) {
			return 0;
		} else if(start >= left && end <= right) {
			return tree[index];
		} else {
			int mid = (start + end) / 2;
			return sum(index * 2 + 1, start, mid, left, right) + sum(index * 2 + 2, mid + 1, end, left, right);
		}
	}
	
	public static void update(int index, int start, int end, int left, int right) {
		if(start > right || end < left) {
			return;
		} 
		
		if(start == end) {
			tree[index] = tree[index] ^ 1;
			return;
		}
		
		int mid = (start + end) / 2;
		update(index * 2 + 1, start, mid, left, right);
		update(index * 2 + 2, mid + 1, end, left, right);
		tree[index] = tree[index * 2 + 1] + tree[index * 2 + 2];
	}
}
