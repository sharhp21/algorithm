package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6064_카잉달력_200325 {
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for(int testcase = 1; testcase <= TC; testcase++ ) {
			st = new StringTokenizer(br.readLine(), " ");
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int gcd = GCD(m, n);
			int a = 0;
			int b = 0;
			while(true) {
				if(m * a + x > gcd || n * b + y > gcd) {
					ans = -1;
					break;
				}
				if(m * a - n * b == y - x) {
					ans = m * a + x;
					break;
				} else if(m * a - n * b > y - x) {
					b++;
				} else {
					a++;
				}
			}
			
			sb.append(ans).append('\n');
		}
		System.out.print(sb);
	}
	
	public static int GCD(int x, int y) {
		int flag = 1;
		int res = 1;
		if(x > y) {
			int tmp = x;
			x = y;
			y = tmp;
		}
		while(true) {
			if(flag == 0) break;
			flag = 0;
			for(int i = 2; i <= x; i++) {
				if(x % i == 0 && y % i == 0) {
					x /= i;
					y /= i;
					res *= i;
					flag = 1;
					break;
				}
			}
		}
		
		return res * x * y;
	}
}
