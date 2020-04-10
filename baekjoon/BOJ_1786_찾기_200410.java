package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1786_찾기_200410 {
	static int[] pi;
	static int cnt;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		String T = br.readLine();
		String P = br.readLine();

		pi = new int[P.length()];
		cnt = 0;

		getPi(P);

		KMP(T, P);

		System.out.println(cnt);
		System.out.print(sb);
	}

	static void getPi(String P) {
		int j = 0;
		for (int i = 1; i < P.length(); i++) {
			while (j > 0 && P.charAt(i) != P.charAt(j)) {
				j = pi[j - 1];
			}
			if (P.charAt(i) == P.charAt(j)) {
				pi[i] = ++j;
			}
		}
	}

	static void KMP(String T, String P) {
		int j = 0;
		for (int i = 0; i < T.length(); i++) {
			while (j > 0 && T.charAt(i) != P.charAt(j)) {
				j = pi[j - 1];
			}
			if (T.charAt(i) == P.charAt(j)) {
				if (j == P.length() - 1) {
					cnt++;
					sb.append(i - P.length() + 2).append('\n');
					j = pi[j];
				} else
					j++;
			}
		}
	}
}
