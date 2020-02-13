package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1861_정사각형방_200212 {
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int roomNum = Integer.MAX_VALUE;
	static int max = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for(int testcase = 1; testcase <= TC; ++testcase) {
			roomNum = Integer.MAX_VALUE;
			max = 0;
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					go(map, i, j);
				}
			}
			
			sb.append("#" + testcase + " " + roomNum + " " + max + '\n');
		}
		System.out.println(sb);
	}
	
	public static void go(int[][] map, int r, int c) {
		int cnt = 1;
		int x = r;
		int y = c;
		while(true) {
			int i = 0;
			for(i = 0; i < 4; i++) {
				if(x + dx[i] >= 0 && y + dy[i] >= 0 && x + dx[i] < map.length && y + dy[i] < map[0].length) {
					if(map[x + dx[i]][y + dy[i]] == map[x][y] - 1) {
						cnt++;
						x += dx[i];
						y += dy[i];
						break;
					}
				}
			}
			if(i == 4) {
				break;
			}
		}
		
		if(cnt > max) {
			max = cnt;
			roomNum = map[x][y];
		} else if(cnt == max && map[x][y] < roomNum) {
			roomNum = map[x][y];
		}
	}
}
