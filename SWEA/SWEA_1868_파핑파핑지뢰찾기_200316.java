package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1868_파핑파핑지뢰찾기_200316 {
	static class Pos {
		int x, y;
		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static char[][] map;
	static boolean[][] visited;
	static boolean[][] check8dir;
	static int dx[] = {0, 0, 1, 1, 1, -1, -1, -1};
	static int dy[] = {1, -1, 1, 0, -1, 0, 1, -1};
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int testcase = 1; testcase <= TC; ++testcase) {
			int n = Integer.parseInt(br.readLine());
			
			map = new char[n][n];
			visited = new boolean[n][n];
			check8dir = new boolean[n][n];
			
			Queue<Pos> q = new LinkedList<>();
			
			for(int i = 0; i < n; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(check(i, j)) check8dir[i][j] = true;
				}
			}
			
			ans = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(map[i][j] == '.' && visited[i][j] == false && check8dir[i][j]) {
						ans++;
						visited[i][j] = true;
						q.offer(new Pos(i, j));
						
						while(!q.isEmpty()) {
							Pos p = q.poll();
							int px = p.x;
							int py = p.y;
							for(int k = 0; k < 8; k++) {
								int nx = px + dx[k];
								int ny = py + dy[k];
								if(nx >= 0 && ny >= 0 && ny < map[0].length && nx < map.length) {
									if(!visited[nx][ny]) {
										if(check8dir[nx][ny]) {
											q.offer(new Pos(nx, ny));
										}
										visited[nx][ny] = true;
									}
								}
							}
						}
					}
				}
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(map[i][j] == '.' && !visited[i][j]) ans++;
				}
			}
			
			sb.append("#").append(testcase).append(" ").append(ans).append('\n');
		}
		System.out.print(sb);
	}
	
	public static boolean check(int x, int y) {
		for(int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && ny >= 0 && ny < map[0].length && nx < map.length) {
				if(map[nx][ny] == '*') return false; 
			}
		}
		return true;
	}
}
