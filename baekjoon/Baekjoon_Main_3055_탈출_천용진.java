import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * R�� C�� <= 50
 * ���� �Է�����
 * S�� ����ġ
 * D�� ����� ��
 * X�� ��
 * *�� ���� ���ִ� ����
 * .�� ����ִ� ĭ
 * 
 * 
 * S�� ��ĭ�� �̵�
 * *�� ������ �ִ� ĭ���� �̵�
 * S�� D�� ���� ���� �ּ� �ð�
 * ���� ���ٸ� KAKTUS ���
 */
public class Baekjoon_Main_3055_Ż��_õ���� {
	final static int[] dx = { 0, 0, 1, -1};
	final static int[] dy = { 1, -1, 0, 0};
	static int fastTime = 0;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int row = input.nextInt();
		int col = input.nextInt();		
		int gx = 0;
		int gy = 0;
		String[][] map = new String[row][col];
		int[][] check = new int[row][col];
		
		for(int i = 0; i < row; i++) {
			Arrays.fill(check[i], -1);
		}
		
		// map �Է�
		for (int i = 0; i < map.length; i++) {
			String s = input.next();
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = s.substring(j, j + 1);
				if(map[i][j].equals("S")) {
					gx = i;
					gy = j;
					map[i][j] = ".";
					check[gx][gy] = 0;
				}
			}
		}
		
		bfs(map, check, gx, gy);
		
		if(fastTime == 0) {
			System.out.println("KAKTUS");
		}
		else {
			System.out.println(fastTime);
		}
	}
	
	public static void fillWater(String[][] map) {
		ArrayList<Pair<Integer, Integer>> water = new ArrayList<>();
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j].equals("*")) {
					water.add(Pair.of(i, j));
				}
			}
		}
		
		
		for (int i = 0; i < water.size(); i++) {
			for (int j = 0; j < 4; j++) {
				if(water.get(i).x + dx[j] >= 0 && water.get(i).y + dy[j] >= 0
						&& water.get(i).x + dx[j] < map.length && water.get(i).y + dy[j] < map[0].length) {
					if(map[water.get(i).x + dx[j]][water.get(i).y + dy[j]].equals(".")) {
						map[water.get(i).x + dx[j]][water.get(i).y + dy[j]] = "*";
					}
				}
			}
		}
		
		water.clear();
	}
 	
	public static void bfs(String[][] map, int[][] check, int gx, int gy) {
		Queue<Pair<Integer, Integer>> q = new LinkedList<>();
		q.add(Pair.of(gx, gy));
		int fillCount = 0;
	
		while(!q.isEmpty()) {
			//fillWater(map);

			gx = q.peek().x;
			gy = q.peek().y;
			q.poll();

			for(int i = 0; i < 4; i++) {
				if(gx + dx[i] >= 0 && gy + dy[i] >= 0 
						&& gx + dx[i] < map.length && gy + dy[i] < map[0].length) {
					
					if(fillCount < check[gx][gy] + 1) {
						fillCount = check[gx][gy] + 1;
						fillWater(map);
					}
					
					if(map[gx + dx[i]][gy + dy[i]].equals("D")) {
						fastTime = check[gx][gy] + 1;
						return;
					}
					
					if(map[gx + dx[i]][gy +dy[i]].equals(".") && check[gx + dx[i]][gy +dy[i]] == -1) {
						check[gx + dx[i]][gy +dy[i]] = check[gx][gy] + 1;
						q.add(Pair.of(gx + dx[i], gy +dy[i]));
					}
				}
			}	
		}
		fastTime = 0;
	}
}

class Pair<X, Y> {
	final X x;
	final Y y;
	public Pair(X x, Y y) {
		this.x = x;
		this.y = y;
	}
	static <X, Y> Pair<X, Y> of(X x, Y y) {
		return new Pair<X, Y>(x, y);
	}
}
