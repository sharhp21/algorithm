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
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int row = input.nextInt();
		int col = input.nextInt();
		int[][] map = new int[row][col];
		
		// map �Է�
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = input.nextInt();
			}
		}
		
		
	}
}
