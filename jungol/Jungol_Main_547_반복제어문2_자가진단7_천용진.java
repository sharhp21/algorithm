import java.util.Arrays;

public class Jungol_Main_547_반복제어문2_자가진단7_천용진 {
	public static void main(String[] args) {
		int[][] map = new int[5][5];
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				map[i][j] = i + j + 2;
			}
		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}