import java.util.Scanner;

public class ����_Main_1175_�ֻ���������2_õ���� {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		int m = input.nextInt();
		int sum = 0;
		int[] cases = new int[n];
		dice(n, m, 0, cases, sum);
		
	}
	
	public static void dice(int n, int m, int count, int[] cases, int sum) {
		if(count >= n) {
			if(sum == m) {
				for(int i = 0; i < n; i++) {
					System.out.print(cases[i] + " ");
				}
				System.out.println();
			}
			return;
		}
		
		for(int i = 1; i <= 6; i++) {
			cases[count] = i;
			count++;
			dice(n, m, count, cases, sum + i);
			count--;
		}
	}
}