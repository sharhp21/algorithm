package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1266_소수완제품확률_D6_천용진 {
	static int[] notsosu = new int[] {0, 1, 4, 6, 8, 9, 10, 12, 14, 15, 16, 18};
	static int[] comb = new int[19];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		comb[0] = 1;
		for(int i = 1; i <= 18; i++) {
			comb[i] = comb[i - 1] * (19 - i) / i;
		}

		int TC = Integer.parseInt(br.readLine());
		for(int testcase = 1; testcase <= TC; testcase++) {
			st = new StringTokenizer(br.readLine(), " ");
			double a = (double)Integer.parseInt(st.nextToken()) / 100.0;
			double b = (double)Integer.parseInt(st.nextToken()) / 100.0;
			
			double tmpA = 1;
			double tmpB = 1;
			double resA = 0;
			double resB = 0;
			double res = 0;
			
			for(int i = 0; i < notsosu.length; i++) {
				tmpA = 1;
				tmpB = 1;
				for(int j = 0; j < notsosu[i]; j++) {
					tmpA *= a;
					tmpB *= b;
				}
				
				for(int j = 0; j < 18 - notsosu[i]; j++) {
					tmpA *= (1.0 - a);
					tmpB *= (1.0 - b);
				}
				
				tmpA *= comb[notsosu[i]];
				tmpB *= comb[notsosu[i]];
				
				resA += tmpA;
				resB += tmpB;
			}

			res = resA * resB;
			
			double ans = 1 - res;
			System.out.print("#" + testcase + " ");
			System.out.printf("%.6f", ans);
			System.out.println();
		}
	}
}
