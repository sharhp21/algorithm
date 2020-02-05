import java.util.Scanner;

public class BOJ_2292_벌집_200205 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		if(n == 1) {
			System.out.println(1);
			return;
		} else {
			int sum = 0;
			for(int i = 0; ; i++) {
				sum += i;
				if(n - (1 + sum * 6) <= (i + 1) * 6) {
					System.out.println(i + 2);
					return;
				}
			}
		}
	}
}
