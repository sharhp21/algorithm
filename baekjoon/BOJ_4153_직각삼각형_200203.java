import java.util.Arrays;
import java.util.Scanner;

public class BOJ_4153_�����ﰢ��_200203 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		while(true) {
			int[] arr = new int[3];
			arr[0] = input.nextInt();
			arr[1] = input.nextInt();
			arr[2] = input.nextInt();
			if(arr[0] == 0) break;
			
			Arrays.sort(arr);
			if(arr[0] * arr[0] + arr[1] * arr[1] == arr[2] * arr[2]) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
		}
	}
}
