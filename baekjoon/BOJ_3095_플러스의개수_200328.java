package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3095_플러스의개수_200328 {
	static int[][] map;
	static int ans;
	static int[] dx = { 0, 0, 1, -1, 1, 1, -1, -1 };
	static int[] dy = { 1, -1, 0, 0, 1, -1, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		ans = 0;
		for (int i = 1; i < n - 1; i++) {
			for (int j = 1; j < n - 1; j++) {
				if (map[i][j] == 1)
					find(i, j, 1);
			}
		}

		System.out.println(ans);
	}

	public static void find(int x, int y, int cnt) {
		if (x - cnt < 0 || y - cnt < 0 || x + cnt >= map.length || y + cnt >= map.length)
			return;
		for (int i = x - cnt; i <= x + cnt; i += cnt * 2) {
			for (int j = y - cnt; j <= y + cnt; j++) {
				if (x == i || y == j) {
					if (map[i][j] != 1)
						return;
				} else {
					if (map[i][j] != 0)
						return;
				}
			}
		}

		for (int i = x - cnt + 1; i < x + cnt; i++) {
			for (int j = y - cnt; j <= y + cnt; j += cnt * 2) {
				if (x == i || y == j) {
					if (map[i][j] != 1)
						return;
				} else {
					if (map[i][j] != 0)
						return;
				}
			}
		}
		ans++;
		find(x, y, cnt + 1);
	}
}
