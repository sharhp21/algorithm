package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9935_문자열폭발_200213 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String str = br.readLine();
		String findStr = br.readLine();
		
		if(!str.contains(findStr)) {
			System.out.println(str);
			return;
		}
		
		int len = str.length();
		int len2 = findStr.length();
		
		for(int i = 0; i < len; i++) {
			char ch = str.charAt(i);
			sb.append(ch);
			boolean check = false;
			for(int j = len2 - 1; j >= 0; j--) {
				int k = j - len2;
				if((sb.length() + k) >= 0 && sb.charAt(sb.length() + k) == findStr.charAt(j)) {
					check = true;
				} else {
					check = false;
					break;
				}
			}
			if(check) {
				for(int j = 0; j < len2; j++) {
					if(sb.length() != 0) sb.deleteCharAt(sb.length() - 1);
				}
			}
		}
		
		if(sb.length() == 0) {
			sb.append("FRULA");
		}
		
		System.out.println(sb);
	}
}
