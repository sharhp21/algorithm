package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_8382_방향전환_200403 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= TC; ++testcase) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int x = Math.abs(x2 - x1);
			int y = Math.abs(y2 - y1);
			int sub = Math.abs(x - y);
			if(sub % 2 == 1) sub--;
			int ans = x + y + sub;
			
			sb.append('#').append(testcase).append(' ').append(ans).append('\n');
		}
		System.out.print(sb);
	}
}
