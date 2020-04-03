package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4530_극한의청소작업_200403 {
	static long[] dp;
	static long answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		dp = new long[12]; // 4의 개수
		dp[0] = 1;
		for(int i = 1; i < 12; i++) {
			dp[i] = dp[i - 1] * 9 + (long)Math.pow(10, i);
		}
		int TC = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= TC; ++testcase) {
			st = new StringTokenizer(br.readLine(), " ");
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			
			answer = 0;
			
			if((a > 0 && b < 0) || (a < 0 && b > 0)) {
				answer += stairs(1, Math.abs(a));
				answer += stairs(1, Math.abs(b));
			} else {
				if(a < 0) answer += stairs(-b, -a);
				else answer += stairs(a, b);
				answer--;
			}
			answer = b - a - answer - 1;
			
			sb.append('#').append(testcase).append(' ').append(answer).append('\n');
		}
		System.out.print(sb);
	}
	
	public static long stairs(long a, long b) {
		long res = 0;
		int digitB = (int)(Math.log10(b));
		
		if(digitB <= 0) {
			if(b >= 4) return 1;
			return 0;
		}
		
		long digit10 = (long)Math.pow(10, digitB);
		int front = (int)(b / digit10);

		while(digitB >= 1) {
			res += dp[digitB - 1] * front;
			if(front > 4) {
				res += digit10;
				res -= dp[digitB - 1];
			}
			
			b = b % digit10;
			digitB--;
			digit10 = (long)Math.pow(10, digitB);
			
			front = (int)(b / digit10);
		}
		
		if(b >= 4) res++;

		if(a != 1) {
			res -= stairs(1, a);
		}
		
		return res;
	}
}
