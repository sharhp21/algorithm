import java.util.Scanner;

public class SWEA_Solution_5215_햄버거다이어트_D3_천용진 {
	static int max = 0;
	static int score_sum = 0;
	static int kal_sum = 0;
	public static int dfs(int[] score, int[] kal, int[] check, int limit_kal, int point) {
		for(int i = point; i < score.length; i++) {
			if(check[i] == 0 && kal_sum + kal[i] <= limit_kal) {
				kal_sum += kal[i];
				score_sum += score[i];
				check[i] = 1;
				if(score_sum > max) max = score_sum;
				dfs(score, kal, check, limit_kal, i);
				kal_sum -= kal[i];
				score_sum -= score[i];
				check[i] = 0;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int testCase = 1; testCase <= TC; testCase++) {
			int n = sc.nextInt();
			int limit_kal = sc.nextInt();
			max = 0;
			score_sum = 0;
			kal_sum = 0;
			
			int[] score = new int[n];
			int[] kal = new int[n];
			int[] check = new int[n];
			
			for(int i = 0; i < n; i++) {
				score[i] = sc.nextInt();
				kal[i] = sc.nextInt();
			}
			
			int m = dfs(score, kal, check, limit_kal, 0);
			
			System.out.println("#" + testCase + " " + m);
		}
	} // end of for testCase
} // end of main