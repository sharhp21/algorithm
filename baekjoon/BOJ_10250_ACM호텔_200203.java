import java.util.Scanner;

public class BOJ_10250_ACMÈ£ÅÚ_200203 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int TC = input.nextInt();
		for(int testcase = 1; testcase <= TC; testcase++) {
			int h = input.nextInt();
			int w = input.nextInt();
			int n = input.nextInt();
			
			int floor = n % h;
			if(floor == 0) floor = h;
			int ho = (n + h - 1) / h;
			
			String ans = Integer.toString(floor);
			if(ho / 10 == 0)
				ans += "0";
			ans += Integer.toString(ho);
			
			System.out.println(ans);
		}
	}
}
