import java.util.Scanner;

public class BOJ_2231_분해합_200205 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int ans = 0;
		int[] arr = new int[n + 1];
		for(int i = 1; i < n + 1; i++) {
			for(int j = 0; j < Integer.toString(i).length(); j++) {
				arr[i] += Integer.toString(i).charAt(j) - '0';
			}
			arr[i] += i;
		}
		
		for(int i = 1; i < n + 1; i++) {
			if(arr[i] == n) {
				ans = i;
				break;
			}
		}
		System.out.println(ans);
	}
}
