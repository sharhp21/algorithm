import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 가장 가까운 치킨집 까지의 거리 = 치킨거리
 * M개를 제외한 나머지 치킨집 폐업했을때
 * 가장 작은 치킨거리를 출력
 * 0은 빈 칸, 1은 집, 2는 치킨집
 * 
 * 일단, 집에서 치킨집까지의 거리를 bfs를 통해 구함
 * 누적시켜서 가장 큰 거리의 치킨집을 M개 까지 줄임
 */
public class Baekjoon_Main_15686_치킨배달_천용진 {
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
