package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11404_플로이드_200416 {
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		for(int i = 0; i < n; i++) Arrays.fill(map[i], Integer.MAX_VALUE);
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.parseInt(st.nextToken()) - 1;
			int v2 = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			if(map[v1][v2] > cost)
				map[v1][v2] = cost;
		}
		
		for(int k = 0; k < n; k++) {
			for(int i = 0; i < n; i++) {
				if(i == k) continue;
				for(int j = 0; j < n; j++) {
					if(i == j || j == k || map[i][k] == Integer.MAX_VALUE || map[k][j] == Integer.MAX_VALUE) continue;
					map[i][j] = Math.min(map[i][k] + map[k][j], map[i][j]);
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int num = map[i][j] == Integer.MAX_VALUE ? 0 : map[i][j];
				sb.append(num).append(' ');
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
}
