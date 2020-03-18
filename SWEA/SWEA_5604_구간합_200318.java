package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5604_구간합_200318 {
	static long ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for(int testcase = 1; testcase <= TC; ++testcase) {
			st = new StringTokenizer(br.readLine(), " ");
			long start = Long.parseLong(st.nextToken());
			long end = Long.parseLong(st.nextToken());
			long digit = 1L;
			
			ans = 0L;
			while(start <= end) {
				while(start % 10 != 0 && start <= end) {
					calc(start++, digit);
				}
				
				while(end % 10 != 9 && start <= end) {
					calc(end--, digit);
				}
				
				if(start > end) break;
				
				start /= 10;
				end /= 10;
				ans += (end - start + 1) * digit * 45;
				
				digit *= 10L;
			}
			
			sb.append('#').append(testcase).append(' ').append(ans).append('\n');
		}
		System.out.print(sb);
	}
	
	public static void calc(long n, long digit) {
		while(n > 0) {
			ans += (n % 10) * digit;
			n /= 10;
		}
	}
}
