package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16916_부분문자열_200410 {
	static int[] pi;
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String substr = br.readLine();
		
		pi = new int[substr.length()];
		
		getPi(substr);
		KMP(str, substr);
		
		System.out.println(ans);
	}
	
	public static void getPi(String substr) {
		int j = 0;
		for(int i = 1; i < substr.length(); i++) {
			while(j > 0 && substr.charAt(i) != substr.charAt(j)) {
				j = pi[j - 1];
			}
			
			if(substr.charAt(i) == substr.charAt(j)) {
				pi[i] = ++j;
			}
		}
	}
	
	public static void KMP(String str, String substr) {
		int j = 0;
		for(int i = 0; i < str.length(); i++) {
			while(j > 0 && str.charAt(i) != substr.charAt(j)) {
				j = pi[j - 1];
			}
			
			if(str.charAt(i) == substr.charAt(j)) {
				if(j == substr.length() - 1) {
					ans = 1;
					return;
				} else j++;
			}
		}
	}
}
