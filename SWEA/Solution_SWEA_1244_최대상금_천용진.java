package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1244_최대상금_천용진 {
	static char[] num;
	static int max = 0;
	static int cnt;
	static int flag;
	public static void swap(int a, int b) {
		char temp = num[a];
		num[a] = num[b];
		num[b] = temp;
	}
	
	public static void perm(int r, int k) {
		if(k == cnt || r / 2 + 1 == k) {
			if(max < change()) max = change();
			flag = cnt - k;
		} else {
			for(int i = 0; i < num.length; i++) {
				for(int j = i + 1; j < num.length; j++) {
					if(i != j) {
						swap(i, j);
						perm(r, k + 1);
						swap(i, j);
					}
				}
			}
		}
	}
	
	public static int change() {
		StringBuilder b = new StringBuilder();
		for(int i = 0; i < num.length; i++) {
			b.append(num[i]);
		}
		return Integer.parseInt(b.toString());
	}
	
	public static boolean check() {
		for(int i = 0; i < num.length - 1; i++) {
			if(num[i] == num[i + 1]) return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int testcase = 1; testcase <= TC; testcase++) {
			st = new StringTokenizer(br.readLine(), " ");

			num = st.nextToken().toCharArray();
			cnt = Integer.parseInt(st.nextToken());
			max = 0;
			flag = 0;
			
			perm(num.length, 0);
			
			if(flag % 2 == 1 && !check()) {
				int one = max % 100 / 10;
				int ten = max % 10 * 10;
				
				max = max / 100 * 100 + ten + one;
			}
			
			sb.append("#").append(testcase).append(" ").append(max).append('\n');
		}
		System.out.println(sb);
	}
}
