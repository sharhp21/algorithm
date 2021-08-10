package 프로그래머스;

import java.util.HashSet;
import java.util.Set;

public class PROG_로또의최고순위와최저순위 {
	public static void main(String[] args) {
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};
		
		int[] answer = solution(lottos, win_nums);
		System.out.println(answer[0] + " " + answer[1]);
	}
	
	public static int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];

		Set<Integer> pick = new HashSet<Integer>();
		int correct = 0;
		int zeroCnt = 0;

		for (int i = 0; i < win_nums.length; i++) {
			pick.add(win_nums[i]);
		}

		for (int i = 0; i < lottos.length; i++) {
			if (lottos[i] == 0) zeroCnt++;
			else if (pick.contains(lottos[i])) correct++;
		}

		answer[0] = (7 - (correct + zeroCnt) == 7 ? 6 : 7 - (correct + zeroCnt));
		answer[1] = (7 - correct == 7 ? 6 : 7 - correct);

		return answer;
	}
}
