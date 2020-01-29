import java.util.Scanner;

public class Jungol_Main_554_반복제어문3_자가진단7_천용진 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int num = 1;
		char ch = 'A'; 
		
		String[][] map = new String[n][n + 1];
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if(i + j < n) {
					map[i][j] = Integer.toString(num);
					num++;
				}
				else {
					map[i][j] = Character.toString(ch);
					ch++;
				}
			}
		}
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
