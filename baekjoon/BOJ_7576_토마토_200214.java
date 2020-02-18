package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato {
	int x;
	int y;
	
	public Tomato(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class BOJ_7576_토마토_200214 {
	static Queue<Tomato> q;
	static int max = 0;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		int[][] visited = new int[n][m];
		for(int[] i : visited) {
			Arrays.fill(i, -1);
		}
		q = new LinkedList<Tomato>();
		
		int flag = 0;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					q.offer(new Tomato(i, j));
					visited[i][j] = 0;
				} else if(map[i][j] == 0) flag = 1;
			}
		}
		
		if(flag == 0) {
			System.out.println(0);
			return;
		} else {
			bfs(map, visited);
			if(!mapFull(map)) {
				System.out.println(-1);
				return;
			} else {
				max(visited);
				System.out.println(max);
			}
		}
	}
	
	public static void bfs(int[][] map, int[][] visited) {
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();
			for(int i = 0; i < 4; i++) {
				if(x + dx[i] >= 0 && y + dy[i] >= 0 && x + dx[i] < map.length && y + dy[i] < map[0].length) {
					if(visited[x + dx[i]][y + dy[i]] == -1 && map[x + dx[i]][y + dy[i]] == 0) {
						map[x + dx[i]][y + dy[i]] = 1;
						visited[x + dx[i]][y + dy[i]] = visited[x][y] + 1;
						q.offer(new Tomato(x + dx[i], y + dy[i]));
					}
				}
			}
		}
	}
	
	public static boolean mapFull(int[][] map) {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if(map[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static int max(int[][] visited) {
		for(int i = 0; i < visited.length; i++) {
			for(int j = 0; j < visited[i].length; j++) {
				if(visited[i][j] > max) max = visited[i][j];
			}
		}
		
		return max;
	}
}
