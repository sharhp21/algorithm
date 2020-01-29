import java.util.Scanner;

public class Baekjoon_Main_3987_보이저1호_천용진 {
	static int[] time = {1, 1, 1, 1};
	final static String[] direction = {"U", "R", "D", "L"};
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		String[][] map = new String[n][m];
		
		
		for (int i = 0; i < n; i++) {
			String s = input.next();
			for(int j = 0; j < m; j++) {
				map[i][j] = s.substring(j, j + 1);
			}
		}
		
		int pr = input.nextInt();
		int pc = input.nextInt();
		pr--;
		pc--;
		
		move(map, "U", pr, pc, 0);
		move(map, "R", pr, pc, 1);
		move(map, "D", pr, pc, 2);
		move(map, "L", pr, pc, 3);
		
		int max = 0;
		int index = 0;
		for(int i = 0; i < 4; i++) {
			if(time[i] == -1) {
				System.out.println(direction[i]);
				System.out.println("Voyager");
				return;
			}
			if(max < time[i]) {
				max = time[i];
				index = i;
			}
		}
		System.out.println(direction[index]);
		System.out.println(max);
	}
	
	public static void move(String[][] map, String dir, int r, int c, int index) {
		if(time[index] > map.length * map[0].length) {
			time[index] = -1;
			return;
		}
		
		if(dir.equals("U")) r--;
		else if(dir.equals("R")) c++;
		else if(dir.equals("D")) r++;
		else c--;
		
		if(r < 0 || c < 0 || r >= map.length || c >= map[0].length) {
			if(dir.equals("U")) r++;
			else if(dir.equals("R")) c--;
			else if(dir.equals("D")) r--;
			else c++;
			return;
		}

		time[index]++;

		if(map[r][c].equals("C")) {
			if(dir.equals("U")) r++;
			else if(dir.equals("R")) c--;
			else if(dir.equals("D")) r--;
			else c++;
			time[index]--;
			return;
		}		
		else if(map[r][c].equals("/")) {
			if(dir.equals("U")) dir = "R";
			else if(dir.equals("R")) dir = "U";
			else if(dir.equals("L")) dir = "D";
			else dir = "L";
		}
		else if(map[r][c].equals(".")) {
			
		}
		else {
			if(dir.equals("R")) dir = "D";
			else if(dir.equals("D")) dir = "R";
			else if(dir.equals("L")) dir = "U";
			else dir = "L";
		}
		
		move(map, dir, r, c, index);
	}
}
