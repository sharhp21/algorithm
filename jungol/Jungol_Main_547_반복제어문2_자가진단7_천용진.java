import java.util.Arrays;

public class Jungol_Main_547_�ݺ����2_�ڰ�����7_õ���� {
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