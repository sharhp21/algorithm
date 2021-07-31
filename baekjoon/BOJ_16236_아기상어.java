import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236_아기상어 {
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
		
		// 먹을 물고기가 더이상 없을때 까지 탐색
		while(canEat) {
			// 먹을 수 있는 물고기를 임시 저장할 객체
			//(물고기의 거리가 같을 때 위,왼쪽 우선순위를 지켜야 하므로)
			closePos = new ArrayList<Pos>();
			check = new int[n][n];
			// 아기상어 크기와 먹은 물고기 개수가 같으면 size up
			if(babySharkSize == babySharkEat) {
				babySharkSize++;
				babySharkEat = 0;
			}
			
			findShark(); // 물고기 탐색
		}
		
		System.out.println(time);
		
	}
	
	
	public static void findShark() {
		// 먹을 물고기가 있는지 알려줄 변수 초기화
		canEat = false;
		// 현재 아기상어 위치 기준으로 bfs 탐색
		queue.offer(new Pos(babySharkPosX, babySharkPosY));
		while(!queue.isEmpty()) {
			Pos nPos = queue.poll();
			int nx = nPos.x;
			int ny = nPos.y;

			// 먹을 물고기를 찾았는데, 그 물고기 위치보다 더 먼 곳을 탐색하려 할때 멈춤
			if(canEat && check[nx][ny] + 1 > closePos.get(0).dist) {
				queue.clear();
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int px = nx + dx[i];
				int py = ny + dy[i];
				if(px >= 0 && px < n && py >= 0 && py < n) {
					// 탐색하지 않았고, 물고기가 있는데 아기 상어보다 작을때
					if(check[px][py] == 0 && map[px][py] != 0 && map[px][py] < babySharkSize) {
						check[px][py] = check[nx][ny] + 1;
						// 먹을수 있는 물고기 리스트에 임시 저장
						closePos.add(new Pos(px, py, check[nx][ny] + 1));
						// 이번 turn에는 물고기 사냥 성공
						canEat = true;
					}
					// 물고기가 없거나, 물고기가 있지만 아기 상어와 크기가 같을때
					if(check[px][py] == 0 && (map[px][py] == babySharkSize || map[px][py] == 0)) {
						// 그냥 지나간다.
						queue.offer(new Pos(px, py));
						check[px][py] = check[nx][ny] + 1;
					}
				}
			}
		}
		
		// 먹을 수 있는 물고기가 있을때
		// 이 중 가장 위,왼쪽에 있는 물고기를 먹어야 한다.
		if(canEat) {
			// Comparable를 통해 우선순위 정렬
			Collections.sort(closePos);
			// 아기상어 위치 이동
			babySharkPosX = closePos.get(0).x;
			babySharkPosY = closePos.get(0).y;
			// 물고기 잡는 시간 갱신
			time += closePos.get(0).dist;
			// 물고기 먹은 개수 갱신
			babySharkEat++;
			// 물고기를 먹은 자리 갱신
			map[babySharkPosX][babySharkPosY] = 0;
		}
	}
}
