package algo;

import java.util.Scanner;

public class BOJ_1929_소수구하기_200206 { // 에라토스테네스의 체
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int m = input.nextInt();
		int n = input.nextInt();
		
		int[] arr = new int[n + 1];
		
		for(int i = 2; i <= n; i++) {
			arr[i] = i;
		}
		
		for(int i = 2; i <= n; i++) {
			if(arr[i] == 0) continue;
			else {
				for(int j = i + i; j <= n; j+=i) {
					arr[j] = 0;
				}
			}
		}
		
		for(int i = m; i <= n; i++) {
			if(arr[i] != 0) {
				sb.append(arr[i] + "\n");
			}
		}
		
		System.out.println(sb);
	}
}
