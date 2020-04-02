package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5607_조합_200402 {
	static long mod = 1234567891;
	static long[] factorial;
	static long fermat;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		factorial = new long[1000001];
		factorial[0] = 1;
		factorial[1] = 1;
		for(int i = 2; i < 1000001; i++) {
			factorial[i] = (factorial[i - 1] * i) % mod;
		}
		
		int TC = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= TC; ++testcase) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
	        
			fermat = factorial[n] * powcal((factorial[n - r] * factorial[r]) % mod, mod - 2) % mod;
			
			sb.append('#').append(testcase).append(" ").append(fermat).append('\n');
		}
		System.out.print(sb);
	}
	
	public static long powcal(long num, long p) {
		if(p == 0) return 1;
		
		//System.out.println(p);
		long result = (powcal(num, p / 2)) % mod;
		result = (result * result) % mod;
		if(p % 2 == 1) {
			result = (result * num) % mod;
		}
		
		return result;
	}
}
