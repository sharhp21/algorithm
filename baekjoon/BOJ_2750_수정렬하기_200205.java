import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2750_수정렬하기_200205 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = input.nextInt();
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}
	}
}
