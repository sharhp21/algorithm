
public class Jungol_Main_570_�迭2_�ڰ�����7_õ���� {
	public static void main(String[] args) {
		int[][] map = new int[5][5];
		
		for(int i = 0; i < 5; i++) {
			map[i][0] = 1;
			map[0][i] = 1;
		}
		
		for(int i = 1; i < 5; i++) {
			for(int j = 1; j < 5; j++) {
				map[i][j] = map[i - 1][j] + map[i][j - 1];
			}
		}
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
