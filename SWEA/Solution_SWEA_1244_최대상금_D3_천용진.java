package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_1244_최대상금_천용진 {
	static char[] num;
	static int max = 0;
	static int maxVal;
	static int cnt;
	public static void swap(int a, int b) {
		char temp = num[a];
		num[a] = num[b];
		num[b] = temp;
	}
	
	public static void perm(int r, int k) {
		if(max == maxVal) return;

		if(r / 2 + 1 == k) {
			if(max < change()) max = change();
			return;
		}
		
		if(k == cnt) {
			if(max < change()) max = change();
		} else {
			for(int i = 0; i < num.length; i++) {
				for(int j = 0; j < num.length; j++) {
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
			
			char[] sortingNum = num.clone();
			Arrays.sort(sortingNum);
			StringBuilder b = new StringBuilder();
			for(int i = sortingNum.length - 1; i >= 0; i--) {
				b.append(sortingNum[i]);
			}
			maxVal = Integer.parseInt(b.toString());
			
			perm(num.length, 0);
			
			sb.append("#").append(testcase).append(" ").append(max).append('\n');
		}
		System.out.println(sb);
	}
}
