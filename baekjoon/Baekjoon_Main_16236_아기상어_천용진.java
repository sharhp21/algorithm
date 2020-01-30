import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BabyShark{
	int x;
	int y;
	int size;
	int eatFistCount;
}

class Point{
	int x;
	int y;
	int dist;
}

public class Baekjoon_Main_16236_아기상어_천용진 {
	final static int[] dx = {-1, 0, 0, 1};
	final static int[] dy = {0, -1, 1, 0};
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		BabyShark shark = new BabyShark();
		int n = input.nextInt();
		int ans = 0;
		int[][] map = new int[n][n];
		int[][] check = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = input.nextInt();
				if(map[i][j] == 9) {
					map[i][j] = 0;					
					shark.x = i;
					shark.y = j;
					shark.size = 2;
					shark.eatFistCount = 0;
				}
			}
		}
		while(true) {
			int temp = bfs(map, check, shark);
			if(temp == 0) {
				break;
			}
			ans += temp;
		}
		
		System.out.println(ans);
	}
	
	public static int bfs(int[][] map, int[][] check, BabyShark shark) {
		int flag = 0;
		Queue<Point> q = new LinkedList<Point>();
		Point Point = new Point();
		Point.x = shark.x;
		Point.y = shark.y;
		Point.dist = 0;
		check[shark.x][shark.y] = 1;
		q.add(Point);
		
		int goX = 0;
		int goY = 0;
		int realX = map.length;
		int realY = map.length;
		int realDist = 0;
		
		while(!q.isEmpty()) {					
			int r = q.peek().x;
			int c = q.peek().y;
			int distance = q.peek().dist;
			
//			System.out.println(q.size());
//			System.out.println(r + " " + c + " " + distance);
			
			q.poll();
					
			for(int i = 0; i < 4; i++) {
				if(r + dx[i] >= 0 && r + dx[i] < map.length && c + dy[i] >= 0 && c + dy[i] < map[0].length) {
					if(shark.size >= map[r + dx[i]][c + dy[i]] && check[r + dx[i]][c + dy[i]] == 0) {
//						System.out.println((r + dx[i]) + " " + (c + dy[i]) + " " + shark.eatFistCount + " " + shark.size);
						if(realDist > distance || realDist == 0) {
							Point pnt = new Point();
							pnt.x = r + dx[i];
							pnt.y = c + dy[i];
							pnt.dist = distance + 1;
							q.add(pnt);
							check[r + dx[i]][c + dy[i]] = 1;
							if(shark.size > map[r + dx[i]][c + dy[i]] && map[r + dx[i]][c + dy[i]] > 0) {
								goX = r + dx[i];
								goY = c + dy[i];
								realDist = distance + 1;
								flag = 1;
								//q.poll();
								if(goX < realX) {
									realX = goX;
									realY = goY;
									continue;
								}
								if(goX == realX && goY < realY) {
									realX = goX;
									realY = goY;
								}
							}
						}
						
					}
				}
			}
		}
		
		if(flag == 1) {
			shark.x = realX;
			shark.y = realY;
			shark.eatFistCount += 1;
//			System.out.println(shark.eatFistCount);
			if(shark.eatFistCount == shark.size) {
				shark.eatFistCount = 0;
				shark.size += 1;
			}
			map[realX][realY] = 0;
			for(int i = 0; i < check.length; i++) {
				for(int j = 0; j < check[i].length; j++) {
					check[i][j] = 0;
				}
			}
			flag = realDist;
		}
		return flag;
	}
}