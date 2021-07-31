import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1261_알고스팟 {
	static class Pos implements Comparable<Pos> {
		int x, y;
		int dist;
		public Pos(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		@Override
		public int compareTo(Pos p) {
			if(this.dist > p.dist) {
				return 1;
			}
			return -1;
		}
	}
	
	static int m, n;
	static int[][] map;
	static int[][] distance;
	static int[][] check;
	static PriorityQueue<Pos> pq;
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		distance = new int[n][m];
		check = new int[n][m];
		// 거리가 작은것 부터 뽑아내기 위해 priority queue 사용
		pq = new PriorityQueue<Pos>();
		
		for(int i = 0; i < n; i++) {
			String[] arr = br.readLine().split("");
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(arr[j]);
				distance[i][j] = 100000;
			}
		}
		
		// 시작점 거리 0으로 초기화
		distance[0][0] = 0;
		
		dijkstra(); // 다익스트라 알고리즘
		
		System.out.println(distance[n - 1][m - 1]);
	}
	
	public static void dijkstra() {
		pq.offer(new Pos(0, 0, 0));
		while(!pq.isEmpty()) {
			Pos nPos = pq.poll();
			int nx = nPos.x;
			int ny = nPos.y;
			
			// 끝점에 도달하면 종료
			if(nx == n - 1 && ny == m - 1) {
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int px = nx + dx[i];
				int py = ny + dy[i];
				if(px >= 0 && px < n && py >= 0 && py < m) {
					if(check[px][py] == 0) {
						// 장애물이 없을때
						if (map[px][py] == 0) {
							// 거리가 더 짧을때만 갱신
							if(distance[px][py] > distance[nx][ny]) {
								distance[px][py] = distance[nx][ny];
								pq.offer(new Pos(px, py, distance[nx][ny]));
								check[px][py] = 1;
							}
						} 
						// 장애물이 있을때
						else {
							// 거리가 더 짧을때만 갱신
							if(distance[px][py] > distance[nx][ny] + 1) {
								distance[px][py] = distance[nx][ny] + 1;
								pq.offer(new Pos(px, py, distance[nx][ny] + 1));
								check[px][py] = 1;
							}
						}
					}
				}
			}
		}
		
	}
}
