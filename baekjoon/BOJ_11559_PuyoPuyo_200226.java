import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Pos {
	int x;
	int y;
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ_11559_PuyoPuyo_200226 {
	static char[][] map = new char[12][6];
	static int[][] visited = new int[12][6];
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int cnt;
	static List<Pos> list;
	static int flag;
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int i = 0; i < 12; i++) {
			map[i] = br.readLine().toCharArray();
		} // input
		
		while(true) {
			flag = 0;
			for(int i = 0; i < 12; i++) {
				for(int j = 0; j < 6; j++) {
					if(map[i][j] != '.') { // ���� ���� � ���ִ��� ã�ƺ���
						cnt = 0; // ��� ���� ���ֳ� Ȯ���ϱ� ���� variable
						list = new ArrayList<>(); // ������ �ѿ䰡 �� ����Ʈ �ʱ�ȭ
						visited = new int[12][6]; // �湮 �迭 �ʱ�ȭ
						dfs(i, j);
						if(cnt >= 4) { // 4�� �̻� �������� ���� ����
							flag = 1; // �̹� ���� ������ ���� �����ϴ� ���� ������ �������� flag on
							for(int k = 0; k < list.size(); k++) {
								Pos p = list.get(k);
								map[p.x][p.y] = '.'; // �ϴ� ������
							}
						}
					}
				}
			}
			
			if(flag == 0) break; // ������ �ѿ䰡 ������ ����
			ans++; // ������ �ѿ䰡 ������ + 1 ����
			down(); // �ѿ���� ��������� �����ش�
		}
		
		System.out.println(ans);
	}
	
	public static void down() {
		for(int j = 0; j < 6; j++) {
			for(int i = 10; i >= 0; i--) { // �ؿ��� ���� Ȯ��
				if(map[i][j] != '.') {
					int count = 0;
					for(int k = i + 1; k < 12; k++) {
						if(map[k][j] == '.') count++; // �ؿ� �� ������ �󸶳� �ֳ� Ȯ����
					}
					if(count != 0) { // �� ������ŭ ������
						map[i + count][j] = map[i][j];
						map[i][j] = '.';
					}
				}
			}
		}
	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = 1; // �湮üũ
		list.add(new Pos(x, y)); // ������ �ѿ� ����Ʈ�� �ֱ�
		cnt++; // ��� ���ִ��� ����
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && ny >= 0 && nx < 12 && ny < 6) {
				if(map[nx][ny] == map[x][y] && visited[nx][ny] == 0) {
					dfs(nx, ny);
				}
			}
		}
	}
}
