package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_6782_현주가좋아하는제곱근놀이_200402 {
	static long answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= TC; ++testcase) {
			long n = Long.parseLong(br.readLine());
			
			answer = 0;
			while(n > 2) {
				long tmp = (long)Math.sqrt(n);
				if(tmp * tmp == n) {
					n = tmp;
					answer++;
				} else {
					answer += (tmp + 1) * (tmp + 1) - n;
					n = (tmp + 1) * (tmp + 1);
				}
			}
			
			sb.append('#').append(testcase).append(" ").append(answer).append('\n');
		}
		System.out.print(sb);
	}
}
