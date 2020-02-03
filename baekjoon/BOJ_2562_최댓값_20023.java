import java.util.Scanner;

public class BOJ_2562_ÃÖ´ñ°ª_20023 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] arr = new int[9];
		int max = 0;
		int ans = 0;
		for(int i = 1; i <= 9; i++) {
			arr[i - 1] = input.nextInt();
			if(arr[i - 1] > max) {
				max = arr[i - 1];
				ans = i;
			}
		}
		System.out.println(max);
		System.out.println(ans);
	}
}
