import java.util.Scanner;

public class Jungol_Main_562_배열1_자가진단8_천용진 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] arr = new int[10];
		int oddSum = 0;
		int evenSum = 0;
		
		for(int i = 0; i < 10; i++) {
			arr[i] = input.nextInt();
		} // for
		
		for(int i = 0; i < arr.length; i++) {
			if(i % 2 == 1) evenSum += arr[i];
			else oddSum += arr[i];
		} // for
		
		System.out.println("sum : " + evenSum);
		System.out.printf("avg : %.1f", oddSum / 5.0);
		
		input.close();
	} // main
} // class