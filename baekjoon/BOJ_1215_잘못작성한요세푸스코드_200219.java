package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1215_잘못작성한요세푸스코드_200219 {
	 public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long n = (long)Integer.parseInt(st.nextToken());
		long k = (long)Integer.parseInt(st.nextToken());
		long r = 0;
		
		if(n > k) {
			r += k * (n - k);
			n = k;
		}
		long m = (long)Math.sqrt(k);
		
		for(long i = 1; i < m; i++) {
			long left = Math.min(k / i, n);
			long right = k / (i + 1) + 1;
			
			if(left < right) {
				continue;
			}
			
			r += k * (left - right + 1) - (left + right) * (left - right + 1) * i / 2;
		}
		
		for(long i = 1; i <= Math.min(k / m, n); i++) {
	        r += k % i;
	    }

		System.out.println(r);
	}
}
