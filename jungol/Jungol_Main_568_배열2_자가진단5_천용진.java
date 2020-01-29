import java.util.Scanner;

public class Jungol_Main_568_배열2_자가진단5_천용진 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[][] arr1 = new int[2][4];
		int[][] arr2 = new int[2][4];
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 4; j++) {
				arr1[i][j] = input.nextInt();
			}
		}
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 4; j++) {
				arr2[i][j] = input.nextInt();
			}
		}
		
		System.out.println("first array");
		System.out.println("second array");
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 4; j++) {
				System.out.print(arr1[i][j] * arr2[i][j] + " ");
			}
			System.out.println();
		}
	}
}
