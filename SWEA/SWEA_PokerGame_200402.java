package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_PokerGame_200402 {
	static char[] shape = new char[5];
	static char[] rank = new char[5];
	static String answer;
	static int[] check;
	static int[] cnt;
	static int flag;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= TC; ++testcase) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 5; i++) {
				String str = st.nextToken();
				shape[i] = str.charAt(0);
				rank[i] = str.charAt(1);
				if (rank[i] == 'T')
					rank[i] = ':';
				if (rank[i] == 'J')
					rank[i] = ';';
				if (rank[i] == 'Q')
					rank[i] = '<';
				if (rank[i] == 'K')
					rank[i] = '=';
				if (rank[i] == 'A')
					rank[i] = '>';
			}
			check = new int[5];
			cnt = new int[2];
			cnt[0] = 1;
			cnt[1] = 1;
			flag = 0;

			Arrays.sort(rank);

			for (int i = 0; i < 4; i++) {
				if (check[i] == 0)
					go(i);
			}

			answer = "High card";

			if (cnt[0] == 2 || cnt[1] == 2) {
				answer = "One pair";
				if (cnt[0] == cnt[1]) {
					answer = "Two pair";
				}
			}

			if (cnt[0] == 3 || cnt[1] == 3) {
				answer = "Three of a kind";
				if (cnt[0] == 2 || cnt[1] == 2) {
					answer = "Full House";
				}
			}

			if (!answer.equals("Full House")) {
				if ((rank[0] + 1 == rank[1] && rank[1] + 1 == rank[2] && rank[2] + 1 == rank[3]
						&& rank[3] + 1 == rank[4])
						|| (rank[0] + 1 == rank[1] && rank[1] + 1 == rank[2] && rank[2] + 1 == rank[3]
								&& rank[4] == '>')) {
					answer = "Straight";
				}
			}

			if (cnt[0] == 4 || cnt[1] == 4) {
				answer = "Four of a Kind";
			}

			if (!answer.equals("Four of a Kind") && !answer.equals("Full House")) {
				if (shape[0] == shape[1] && shape[1] == shape[2] && shape[2] == shape[3] && shape[3] == shape[4]) {
					answer = "Flush";
					if ((rank[0] + 1 == rank[1] && rank[1] + 1 == rank[2] && rank[2] + 1 == rank[3]
							&& rank[3] + 1 == rank[4])
							|| (rank[0] + 1 == rank[1] && rank[1] + 1 == rank[2] && rank[2] + 1 == rank[3]
									&& rank[4] == '>')) {
						answer = "Straight Flush";
					}
				}
			}
			sb.append('#').append(testcase).append(" ").append(answer).append('\n');
		}
		System.out.print(sb);
	}

	public static void go(int x) {
		for (int i = x + 1; i < 5; i++) {
			if (check[i] == 0) {
				if (rank[x] == rank[i]) {
					check[i] = 1;
					cnt[flag]++;
					go(i);
					flag = 1;
				}
			}
		}
	}
}
