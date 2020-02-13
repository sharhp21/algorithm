package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4408_자기방으로돌아가기_200212 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine().trim());
		for(int testcase = 1; testcase <= TC; testcase++) {
			int n = Integer.parseInt(br.readLine().trim());
			int[] map = new int[401];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int room1 = Integer.parseInt(st.nextToken());
				int room2 = Integer.parseInt(st.nextToken());
				if(room1 > room2) {
					int temp = room2;
					room2 = room1;
					room1 = temp;
				}
				if(room1 % 2 == 0) room1--;
				if(room2 % 2 == 1) room2++;
				for(int j = room1; j <= room2; j++) {
					map[j] += 1;
				}
			}
			
			int max = 0;
			for(int i = 0; i < 401; i++) {
				if(map[i] > max) max = map[i];
			}
			
			sb.append("#" + testcase + " " + max);
		}
		
		System.out.println(sb);
	}
}