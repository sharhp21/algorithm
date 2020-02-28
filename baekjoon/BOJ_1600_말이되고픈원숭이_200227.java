import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Posi { // �� ��ġ, ���� k ȸ��, �ּ� �Ÿ�
	int x;
	int y;
	int k;
	int cnt;
	public Posi(int x, int y, int k, int cnt) {
		this.x = x;
		this.y = y;
		this.k = k;
		this.cnt = cnt;
	}
}

public class BOJ_1600_���̵ǰ��¿�����_200227 {
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {-1, 1, 0, 0};
	// �� ó�� ������ �� �ִ� ��ǥ
	static int[] horseX = {2, 1, 2, 1, -2, -1, -2, -1};
	static int[] horseY = {1, 2, -1, -2, 1, 2, -1, -2};
	static int[][] map;
	static int[][][] visited;
	static int px, py, pk, pc, nx, ny;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int k = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		map = new int[h][w];
		visited = new int[h][w][k + 1]; // �� ��ǥ�� ���� ����� ���� �������� ������ �޸� ����
		for(int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // input
		
		bfs(k); // go
	}
	
	public static void bfs(int k) {
		Queue<Posi> q = new LinkedList<>();
		q.offer(new Posi(0, 0, k, 0));
		visited[0][0][k] = 1;
		while(!q.isEmpty()) {
			px = q.peek().x;
			py = q.peek().y;
			pk = q.peek().k; // ���� ��ó�� ������ �� �ִ� Ƚ��
			pc = q.peek().cnt; // �ִ� �Ÿ�
			q.poll();
			if(px == map.length - 1 && py == map[0].length - 1) { // ���� �����ߴٸ� return
				System.out.println(pc);
				return;
			}
			
			// �׳� �����̱�
			for(int i = 0; i < 4; i++) {
				nx = px + dx[i];
				ny = py + dy[i];
				if(nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length) {
					if(visited[nx][ny][pk] == 0 && map[nx][ny] == 0) {
						visited[nx][ny][pk] = 1; // ��ó�� ������ Ƚ�� ���� ����
						q.offer(new Posi(nx, ny, pk, pc + 1)); // �ִܰŸ� + 1 �ؼ� queue�� ����
					}
				}
			}

			// ��ó�� �����̱�
			if(pk > 0) { // ��ó�� ������ �� �ִ� Ƚ���� �����־�� ����
				for(int i = 0; i < 8; i++) {
					nx = px + horseX[i];
					ny = py + horseY[i];
					if(nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length) {
						if(visited[nx][ny][pk - 1] == 0 && map[nx][ny] == 0) {
							visited[nx][ny][pk - 1] = 1; // ��ó�� ������ Ƚ�� �ϳ� ����
							q.offer(new Posi(nx, ny, pk - 1, pc + 1)); // �ִܰŸ� + 1�ؼ� queue�� ����
						}
					}
				}
			}
		}
		System.out.println(-1); // return ���ߴٸ� -1 ���
	}
}
