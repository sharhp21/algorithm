package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5656_벽돌깨기_200310 {
	static int[][] initMap;
	static int[][] map;
	static int[] order;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int cnt, initCnt, ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int testcase = 1; testcase <= TC; ++testcase) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			initMap = new int[h][w];
			map = new int[h][w];
			initCnt = 0;
			
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < w; j++) {
					initMap[i][j] = Integer.parseInt(st.nextToken());
					if(initMap[i][j] != 0) initCnt++;
				}
			}

			order = new int[n];
			ans = 0;
			cnt = 0;
			select(n, 0);
			
			ans = initCnt - ans;
			sb.append("#").append(testcase).append(" ").append(ans).append('\n');
		}
		System.out.print(sb);
	}
	
	public static void select(int n, int count) {
		if(ans == initCnt) return;
		
		if(n == count) {
			for(int i = 0; i < map.length; i++) map[i] = initMap[i].clone();	
			breaking();
			return;
		}
		
		for(int i = 0; i < map[0].length; i++) {
			order[count] = i;
			select(n, count + 1);
		}
	}
	
	public static void breaking() {
		cnt = 0;
		for(int o = 0; o < order.length; o++) {
			// 가장 위에 있는 벽돌 찾기
			int j = order[o];
			for(int i = 0; i < map.length; i++) {
				if(map[i][j] == 0) continue;
				else if(map[i][j] > 1) {
					remove(i, j);
					break;
				} else {
					map[i][j] = 0;
					cnt++;
					break;
				}
			}
			if(cnt == initCnt) {
				ans = cnt;
				return;
			}
			// 벽돌 내리기
			down();
		}
		if(ans < cnt) ans = cnt;
	}
	
	public static void remove(int x, int y) {
		int num = map[x][y];
		map[x][y] = 0;
		cnt++;
		for(int i = 0; i < 4; i++) {
			for(int j = 1; j < num; j++) {
				int nx = x + dx[i] * j;
				int ny = y + dy[i] * j;
				if(nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length) {
					if(map[nx][ny] == 0) continue;
					else if(map[nx][ny] > 1) {
						remove(nx, ny);
					} else {
						map[nx][ny] = 0;
						cnt++;
					}
				}
			}
		}
	}
	
	public static void down() {
		for(int j = 0; j < map[0].length; j++) {
			int count = 0;
			for(int i = map.length - 1; i >= 0; i--) {
				if(map[i][j] == 0) count++;
				else {
					if(count != 0) {
						map[i + count][j] = map[i][j];
						map[i][j] = 0;
					}
				}
			}
		}
	}
}
