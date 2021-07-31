import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236_�Ʊ��� {
	static class Pos implements Comparable<Pos> {
		int x, y;
		int dist;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public Pos(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		@Override
		public int compareTo(Pos p) {
			if(this.x > p.x) {
				return 1;
			}
			else if(this.x == p.x) {
				if(this.y > p.y) {
					return 1;
				}
			}
			
			return -1;
		}
	}
	
	static int n;
	static int[][] map;
	static int[][] check;
	static int time = 0;
	static Queue<Pos> queue;
	static int babySharkSize = 2;
	static int babySharkEat = 0;
	static int babySharkPosX;
	static int babySharkPosY;
	static List<Pos> closePos;
	static boolean canEat = true;
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		queue = new LinkedList<Pos>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < n; j++) {
				int sharkSize = Integer.parseInt(st.nextToken());
				if(sharkSize == 9) {
					map[i][j] = 0;
					babySharkPosX = i;
					babySharkPosY = j;
				} else {
					map[i][j] = sharkSize;
				}
			}
		}
		
		// ���� ����Ⱑ ���̻� ������ ���� Ž��
		while(canEat) {
			// ���� �� �ִ� ����⸦ �ӽ� ������ ��ü
			//(������� �Ÿ��� ���� �� ��,���� �켱������ ���Ѿ� �ϹǷ�)
			closePos = new ArrayList<Pos>();
			check = new int[n][n];
			// �Ʊ��� ũ��� ���� ����� ������ ������ size up
			if(babySharkSize == babySharkEat) {
				babySharkSize++;
				babySharkEat = 0;
			}
			
			findShark(); // ����� Ž��
		}
		
		System.out.println(time);
		
	}
	
	
	public static void findShark() {
		// ���� ����Ⱑ �ִ��� �˷��� ���� �ʱ�ȭ
		canEat = false;
		// ���� �Ʊ��� ��ġ �������� bfs Ž��
		queue.offer(new Pos(babySharkPosX, babySharkPosY));
		while(!queue.isEmpty()) {
			Pos nPos = queue.poll();
			int nx = nPos.x;
			int ny = nPos.y;

			// ���� ����⸦ ã�Ҵµ�, �� ����� ��ġ���� �� �� ���� Ž���Ϸ� �Ҷ� ����
			if(canEat && check[nx][ny] + 1 > closePos.get(0).dist) {
				queue.clear();
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int px = nx + dx[i];
				int py = ny + dy[i];
				if(px >= 0 && px < n && py >= 0 && py < n) {
					// Ž������ �ʾҰ�, ����Ⱑ �ִµ� �Ʊ� ���� ������
					if(check[px][py] == 0 && map[px][py] != 0 && map[px][py] < babySharkSize) {
						check[px][py] = check[nx][ny] + 1;
						// ������ �ִ� ����� ����Ʈ�� �ӽ� ����
						closePos.add(new Pos(px, py, check[nx][ny] + 1));
						// �̹� turn���� ����� ��� ����
						canEat = true;
					}
					// ����Ⱑ ���ų�, ����Ⱑ ������ �Ʊ� ���� ũ�Ⱑ ������
					if(check[px][py] == 0 && (map[px][py] == babySharkSize || map[px][py] == 0)) {
						// �׳� ��������.
						queue.offer(new Pos(px, py));
						check[px][py] = check[nx][ny] + 1;
					}
				}
			}
		}
		
		// ���� �� �ִ� ����Ⱑ ������
		// �� �� ���� ��,���ʿ� �ִ� ����⸦ �Ծ�� �Ѵ�.
		if(canEat) {
			// Comparable�� ���� �켱���� ����
			Collections.sort(closePos);
			// �Ʊ��� ��ġ �̵�
			babySharkPosX = closePos.get(0).x;
			babySharkPosY = closePos.get(0).y;
			// ����� ��� �ð� ����
			time += closePos.get(0).dist;
			// ����� ���� ���� ����
			babySharkEat++;
			// ����⸦ ���� �ڸ� ����
			map[babySharkPosX][babySharkPosY] = 0;
		}
	}
}
