import java.util.Scanner;

public class BOJ_2798_블랙잭_200205 {
	static int max = 0;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = input.nextInt();
		}
		
		for(int i = 0; i < n - 2; i++) {
			for(int j = i + 1; j < n - 1; j++) {
				for(int k = j + 1; k < n; k++) {
					if(arr[i] + arr[j] + arr[k] > max && arr[i] + arr[j] + arr[k] <= m) {
						max = arr[i] + arr[j] + arr[k];
					}
				}
			}
		}
		
		System.out.println(max);
	}
}
