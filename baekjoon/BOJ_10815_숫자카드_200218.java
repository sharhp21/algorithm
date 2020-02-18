package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_10815_숫자카드_200218 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		HashSet<Integer> hs = new HashSet<>();
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) hs.add(Integer.parseInt(st.nextToken()));
		
		int m = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < m; i++) {
			if(hs.contains(Integer.parseInt(st.nextToken()))) {
				sb.append(1).append(" ");
			} else {
				sb.append(0).append(" ");
			}
		}
		
		System.out.print(sb);
	}
}
