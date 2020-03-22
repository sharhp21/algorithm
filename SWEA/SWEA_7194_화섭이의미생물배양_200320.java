package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7194_화섭이의미생물배양_200320 {
	static int ans, cnt;
	static int s, t, a, b;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for(int testcase = 1; testcase <= TC; testcase++) {
			st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			ans = Integer.MAX_VALUE;
			cnt = 0;
			
			if(b == 1) {
				if((t-s)%a == 0) {
					ans = (t-s)/a;
				}
			} else {
				go(t, cnt);
			}
			
			if(ans == Integer.MAX_VALUE) ans = -1;
			sb.append('#').append(testcase).append(' ').append(ans).append('\n');
		}
		System.out.print(sb);
	}
	
	public static void go(int tt, int cnt) {
		if(cnt >= ans) return;
		
		if(s >= tt) {
			if(s == t && ans > cnt) ans = cnt;
			return;
		}
		
		if(t % b == 0) {
			go(tt / b, cnt + 1);
			//go(s, t - a, a, b);
		} else {
			go(tt - a, cnt + 1);
		}
	}
}
