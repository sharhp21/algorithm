import java.util.Scanner;

public class SWEA_Solution_1210_Ladder1_D4_Ãµ¿ëÁø {
	final static int[] dx = {0, 1, 0, -1};
	final static int[] dy = {-1, 0, 1, 0};
	final static String[] dir = {"U", "R", "D", "L"};
	static int tmp = -1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int testCase = 1; testCase <= 10; testCase++) {
			tmp = -1;
			sc.nextInt();
			int[][] map = new int[100][100];
			int ans = -1;

			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0; i < 100; i++) {
				if(map[0][i] == 1) {
					move(map, "D", 0, i);
					if(tmp == 1) {
						ans = i;
						break;
					}
				}
			}
			System.out.println("#" + testCase + " " + ans);
		}
	}
	
	public static void move(int[][] map, String dir, int r, int c) {
		if(r == map.length - 1) {
			if(map[r][c] == 2) {
				tmp = 1;
				return;
			}
			else return;
		}
		
		if(dir == "D") {
			if(c - 1 >= 0 && map[r][c - 1] == 1) {
				move(map, "L", r, c - 1);
			}
			else if(c + 1 < map[0].length && map[r][c + 1] == 1) {
				move(map, "R", r, c + 1);
			}
			else {
				move(map, "D", r + 1, c);
			}
		}
		else if(dir == "R") {
			if(r + 1 < map.length && map[r + 1][c] == 1) {
				move(map, "D", r + 1, c);
			}
			else {
				move(map, "R", r, c + 1);
			}
		}
		else if(dir == "L") {
			if(r + 1 < map.length && map[r + 1][c] == 1) {
				move(map, "D", r + 1, c);
			}
			else {
				move(map, "L", r, c - 1);
			}
		}
	}
}
