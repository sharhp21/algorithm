import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Castle {
	int x;
	int y;
	public Castle(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class SWEA_1907_�𷡼��ױ�_200303 {
	static int ans;
	static int[][] map;
	static List<Castle> list;
	static Queue<Castle> q;
	static int[][] visited;
	static int[] dx = {0, 0, 1, 1, 1, -1, -1, -1};
	static int[] dy = {1, -1, 0, 1, -1, 0, 1, -1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for(int testcase = 1; testcase <= TC; ++testcase) {
			st = new StringTokenizer(br.readLine(), " ");
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			map = new int[h][w];
			q = new LinkedList<Castle>();
			for(int i = 0; i < h; i++) {
				String str = br.readLine();
				for(int j = 0; j < w; j++) {
					char ch = str.charAt(j);
					if(ch == '.') map[i][j] = 0;
					else {
						map[i][j] = ch - '0';
					}
					
				}
			} // input
			visited = new int[h][w]; // �ֺ� 8���� �� 0�� �κ��� �ڽź��� ū�� ������ �˷��ִ� �迭
			ans = 0;
			
			// ó�� ������ ���� ť�� ����
			for(int i = 1; i < h - 1; i++) {
				for(int j = 1; j < w - 1; j++) {
					if(map[i][j] > 0 && map[i][j] < 9) {
						for(int k = 0; k < 8; k++) {
							if(map[i + dx[k]][j + dy[k]] == 0) {
								visited[i][j]++;
							}
						}
						// �ֺ� 8���� �� 0�� �ڱ��ڽź��� ũ�� q�� ����
						if(map[i][j] <= visited[i][j]) q.offer(new Castle(i, j));
					}	
				}
			}

			while(true) {
				list = new ArrayList<>();
				int size = q.size();
				for(int i = 0; i < size; i++) {
					Castle c = q.poll();
					list.add(new Castle(c.x, c.y)); // ���� �𷡼� �����ϴ� list�� �ֱ�
					for(int j = 0; j < 8; j++) {
						// ���� �ٶ��� �Ҷ� ���� �𷡼� ã�� ����
						if(map[c.x + dx[j]][c.y + dy[j]] > visited[c.x + dx[j]][c.y + dy[j]] && map[c.x + dx[j]][c.y + dy[j]] < 9) {
							visited[c.x + dx[j]][c.y + dy[j]]++;
							// ������ ���� �𷡼� ã���� q�� ����
							if(map[c.x + dx[j]][c.y + dy[j]] <= visited[c.x + dx[j]][c.y + dy[j]]) q.offer(new Castle(c.x + dx[j], c.y + dy[j]));
						}
					}
				}
				
				// ������ �𷡼� ���ֱ�
				for(int i = 0; i < list.size(); i++) {
					Castle c = list.get(i);
					map[c.x][c.y] = 0;
				}

				// ���� �𷡼��� ������ break;
				if(list.size() == 0) break;
				ans++;
			}

			sb.append("#").append(testcase).append(" ").append(ans).append('\n');
		}
		System.out.print(sb);
		
	}
}
