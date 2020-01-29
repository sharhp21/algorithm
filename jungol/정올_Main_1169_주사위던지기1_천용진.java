import java.util.Scanner;

public class 정올_Main_1169_주사위던지기1_천용진 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		int m = input.nextInt();
		int[] cases = new int[n];
		
		dice(n, m, 0, cases, 0);
	}
	
	public static void dice(int n, int m, int count, int[] cases, int check) {
		if(count >= n) {
			for(int i = 0; i < n; i++) {
				System.out.print(cases[i] + " ");
			}
			System.out.println();
			return;
		}
		
		if(m == 1) {
			for(int i = 1; i <= 6; i++) {
				cases[count] = i;
				count++;
				dice(n, m, count, cases, check);
				count--;
			}
		}
		
		else if(m == 2) {
			for(int i = 1; i <= 6; i++) {
				if(check <= i) {
					check = i;
					cases[count] = i;
					count++;
					dice(n, m, count, cases, check);
					count--;
				}
			}
		}
		
		else {
			for(int i = 1; i <= 6; i++) {
				int checkSame = 0;
				for(int j = 0; j < cases.length; j++) {
					if(cases[j] == i) {
						checkSame = 1;
						break;
					}
				}
				if(checkSame == 0) {
					cases[count] = i;
					count++;
					dice(n, m, count, cases, check);
					count--;
					cases[count] = 0;
				}
			}
		}
	}
}
