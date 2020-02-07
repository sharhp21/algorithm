package algo;

import java.util.Scanner;

public class BOJ_2869_달팽이는올라가고싶다_200206 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		int v = input.nextInt();
		
		int ans = (int)(Math.ceil((double)(v - b) / (double)(a - b)));
		
		System.out.println(ans);
	}
}
