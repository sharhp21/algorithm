package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_9659_다항식계산_200403 {
	static long mod = 998244353;
	static int[] t;
	static int[] a;
	static int[] b;
	static int[] x;
	static long[] func;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= TC; ++testcase) {
			int n = Integer.parseInt(br.readLine());
			
			t = new int[n + 1];
			a = new int[n + 1];
			b = new int[n + 1];
			func = new long[n + 1];
			
			for(int i = 2; i <= n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				t[i] = Integer.parseInt(st.nextToken());
				a[i] = Integer.parseInt(st.nextToken());
				b[i] = Integer.parseInt(st.nextToken());
			}
			
			int m = Integer.parseInt(br.readLine());
			x = new int[m];
			sb.append('#').append(testcase);
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < m; i++) {
				x[i] = Integer.parseInt(st.nextToken());
				func[0] = 1; func[1] = (long)x[i];
				for(int x = 2; x <= n; x++) {
					if(t[x] == 1) {
						func[x] = (func[a[x]] + func[b[x]]) % mod;
					} else if(t[x] == 2) {
						func[x] = (a[x] * func[b[x]]) % mod;
					} else {
						func[x] = (func[a[x]] * func[b[x]]) % mod;
					}
				}
				sb.append(' ').append(func[n]);
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
}
