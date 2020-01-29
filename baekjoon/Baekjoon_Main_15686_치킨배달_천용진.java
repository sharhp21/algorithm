import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * ���� ����� ġŲ�� ������ �Ÿ� = ġŲ�Ÿ�
 * M���� ������ ������ ġŲ�� ���������
 * ���� ���� ġŲ�Ÿ��� ���
 * 0�� �� ĭ, 1�� ��, 2�� ġŲ��
 * 
 * �ϴ�, ������ ġŲ�������� �Ÿ��� bfs�� ���� ����
 * �������Ѽ� ���� ū �Ÿ��� ġŲ���� M�� ���� ����
 */
public class Baekjoon_Main_15686_ġŲ���_õ���� {
	final static int[] dx = {0, 0, 1, -1};
	final static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
			
		int n = input.nextInt();
		int m = input.nextInt();
		
		int[][] map = new int[n][n];
		int[][] check = new int[n][n];
		int[][] dist = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = input.nextInt();
				check[i][j] = -1;
			}
		}
		
		bfs(map, check, dist);
		
		for(int a = 0; a < map.length; a++) {
			for(int b = 0; b < map[a].length; b++) {
				System.out.print(dist[a][b] + " ");
			}
			System.out.println();
		}
	}
	
	public static void bfs(int[][] map, int[][] check, int[][] dist) {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if(map[i][j] == 1) {
					Queue<Pair<Integer, Integer>> q = new LinkedList<>();
					q.add(Pair.of(i, j));
					check[i][j] = 0;
					while(!q.isEmpty()) {
						int x = q.peek().x;
						int y = q.peek().y;
						q.poll();
						for(int k = 0; k < 4; k++) {
							if(x + dx[k] >= 0 && y + dy[k] >= 0 && x + dx[k] < map.length && y + dy[k] < map[0].length) {
								if(check[x + dx[k]][y + dy[k]] == -1) {
									q.add(Pair.of(x + dx[k], y + dy[k]));
									check[x + dx[k]][y + dy[k]] = check[x][y] + 1;
									if(map[i][j] == 2) {
										dist[i][j] += check[i][j];
									}
								}
							}
						}
					}
				}
				refreshArr(check, -1);
			}
		}
	}
	
	public static void refreshArr(int[][] arr, int k) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = k;
			}
		}
	}
}

class Pair<X,Y> {
    final X x;
    final Y y;

    public Pair(X x, Y y) {
      this.x = x;
      this.y = y;
    }

    static <X,Y> Pair<X,Y> of(X x, Y y){
        return new Pair<X,Y>(x, y);
    }
  }
