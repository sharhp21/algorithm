import java.util.Scanner;

public class SWEA_Solution_2072_홀수만더하기_D1_천용진 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int testCase = 1; testCase <= TC; testCase++) {
			int sum = 0;
			for(int i = 0; i < 10; i++) {
				int num = sc.nextInt();
				if (num % 2 == 1) sum += num;
			}
			System.out.println("#" + testCase + " " + sum);
		}
	} // end of for testCase
} // end of main