import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1261_�˰��� {
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
		// �Ÿ��� ������ ���� �̾Ƴ��� ���� priority queue ���
		pq = new PriorityQueue<Pos>();
		
		for(int i = 0; i < n; i++) {
			String[] arr = br.readLine().split("");
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(arr[j]);
				distance[i][j] = 100000;
			}
		}
		
		// ������ �Ÿ� 0���� �ʱ�ȭ
		distance[0][0] = 0;
		
		dijkstra(); // ���ͽ�Ʈ�� �˰���
		
		System.out.println(distance[n - 1][m - 1]);
	}
	
	public static void dijkstra() {
		pq.offer(new Pos(0, 0, 0));
		while(!pq.isEmpty()) {
			Pos nPos = pq.poll();
			int nx = nPos.x;
			int ny = nPos.y;
			
			// ������ �����ϸ� ����
			if(nx == n - 1 && ny == m - 1) {
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int px = nx + dx[i];
				int py = ny + dy[i];
				if(px >= 0 && px < n && py >= 0 && py < m) {
					if(check[px][py] == 0) {
						// ��ֹ��� ������
						if (map[px][py] == 0) {
							// �Ÿ��� �� ª������ ����
							if(distance[px][py] > distance[nx][ny]) {
								distance[px][py] = distance[nx][ny];
								pq.offer(new Pos(px, py, distance[nx][ny]));
								check[px][py] = 1;
							}
						} 
						// ��ֹ��� ������
						else {
							// �Ÿ��� �� ª������ ����
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
