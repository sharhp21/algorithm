import java.util.Scanner;

public class Baekjoon_Main_2839_설탕배달_천용진 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int ans = 0;
		
		while(true) {
			if(n == 0) break;
			
			if(n % 3 == 0) {
				if(n / 3 >= 5) {
					ans += 3;
					n -= 15;
				}
				else {
					ans += n / 3;
					break;
				}
			}
			else if(n % 5 == 0) {
				ans += n / 5;
				break;
			}
			else {
				if(n >= 5) {
					n -= 5;
					ans++;
				}
				else {
					ans = -1;
					break;
				}
			}
		}
		
		System.out.println(ans);
	}
}
