package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17136_색종이붙이기_200420 {
	static int[][] map = new int[10][10];
	static int[] colorPaper = { 0, 5, 5, 5, 5, 5 };
	static int ans = 26;
	static int res = 0;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) cnt++;
			}
		}

		fill(5);

		if(ans == 26) ans = -1;
		System.out.println(ans);
	}

	public static void fill(int size) {
		if(res >= ans) return;
		
		if (cnt == 0) {
			if (res < ans)
				ans = res;
			return;
		}
		
		if(size == 1) {
			if(cnt <= 5) {
				if (res + cnt < ans)
					ans = res + cnt;
			}
			return;
		}
		
		int tmp = 0;
		for(int i = size; i > 0; i--) {
			tmp += i * i * colorPaper[i];
		}
		if(tmp < cnt) return;

		
		for (int i = 0; i <= 10 - size; i++) {
			for (int j = 0; j <= 10 - size; j++) {
				if (check(i, j, size) && colorPaper[size] > 0) {
					res++;
					cnt-= size * size;
					colorPaper[size]--;
					change(i, j, size, 0);
					fill(size);
					res--;
					cnt+= size * size;
					colorPaper[size]++;
					change(i, j, size, 1);
				}
			}
		}

		fill(size - 1);
	}

	public static void change(int x, int y, int size, int flag) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				map[i][j] = flag;
			}
		}
	}

	public static boolean check(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (map[i][j] == 0)
					return false;
			}
		}
		return true;
	}
}
