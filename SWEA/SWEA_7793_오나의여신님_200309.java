package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_7793_오나의여신님_200309 {
	static class Pos{
		int x, y;
		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static char[][] map;
	static int[][] visited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static Queue<Pos> dq = new LinkedList<>();
	static Queue<Pos> sq = new LinkedList<>();
	static int gx, gy;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int testcase = 1; testcase <= TC; ++testcase) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			map = new char[n][m];
			visited = new int[n][m];
			for(int i = 0; i < n; i++) Arrays.fill(visited[i], -1);
			
			for(int i = 0; i < n; i++) {
				String str = br.readLine();
				for(int j = 0; j < m; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == '*') dq.offer(new Pos(i, j));
					else if(map[i][j] == 'S') {
						sq.offer(new Pos(i, j));
						visited[i][j] = 0;
					} else if(map[i][j] == 'D') {
						gx = i; gy = j;
					}
				}
			} // input
			
			// S : 수연, D : 여신, X : 돌, * : 악마
			while(true) {
				// 악마의 손아귀
				int size = dq.size();
				for(int i = 0; i < size; i++) {
					Pos p = dq.poll();
					int px = p.x;
					int py = p.y;
					for(int j = 0; j < 4; j++) {
						int nx = p.x + dx[j];
						int ny = p.y + dy[j];
						if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
							if(map[nx][ny] == '.' || map[nx][ny] == 'S') {
								dq.offer(new Pos(nx, ny));
								map[nx][ny] = '*';
							}
						}
					}
				}
				
				// 수연이 이동
				size = sq.size();
				for(int i = 0; i < size; i++) {
					Pos p = sq.poll();
					int px = p.x;
					int py = p.y;
					for(int j = 0; j < 4; j++) {
						int nx = p.x + dx[j];
						int ny = p.y + dy[j];
						if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
							if((map[nx][ny] == 'D' || map[nx][ny] == '.') && visited[nx][ny] == -1) {
								sq.offer(new Pos(nx, ny));
								visited[nx][ny] = visited[px][py] + 1;
								if(map[nx][ny] == 'D') {
									size = 0;
									break;
								}
							}
						}
					}
				}
				if(size == 0) break;
			}
			
			dq.clear();
			sq.clear();
			
			sb.append("#").append(testcase).append(" ");
			if(visited[gx][gy] == -1) sb.append("GAME OVER");
			else sb.append(visited[gx][gy]);
			sb.append('\n');
		}
		System.out.print(sb);
	}
}
