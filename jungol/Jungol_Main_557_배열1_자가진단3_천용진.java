import java.util.Scanner;

public class Jungol_Main_557_배열1_자가진단3_천용진 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] arr = new String[10];
		
		for(int i = 0; i < 10; i++) {
			arr[i] = input.next();
		}
		
		System.out.println(arr[0] + " " + arr[3] + " " + arr[6]);
	}
}
