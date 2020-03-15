package algo;

import java.util.Scanner;

public class BOJ_1019_책페이지_200315 {
	static int[] ans = new int[10];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		
		int start = 1;
		int finish = n;
		int digit = 1;
		
		while(start <= finish) {
			while(start % 10 != 0 && start <= finish) calc(start++, digit);
			
			while(finish % 10 != 9 && start <= finish) calc(finish--, digit);
			
			if(start > finish) break;
			
			start /= 10; finish /= 10;
			for(int i = 0; i < 10; i++) ans[i] += (finish - start + 1) * digit;
			
			digit *= 10;
		}
		
		for(int i = 0; i < 10; i++) sb.append(ans[i] + " ");
		System.out.print(sb);
		
		sc.close();
	}
	
	public static void calc(int n, int digit) {
		while(n > 0) {
			ans[n % 10] += digit;
			n /= 10;
		}
	}
}
