package algo;

public class PROG_lv4_도둑질_200406 {
	static class Solution {
	    public int solution(int[] money) {
	        int answer = 0;
	        int[][] dp = new int[money.length][2];
	        
	        dp[0][1] = dp[1][1] = money[0];
	        dp[1][0] = money[1];
	        for(int i = 2; i < money.length; i++) {
	            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][1] + money[i]);
	            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][0] + money[i]);
	        }
	        
	        if(dp[money.length - 2][1] < dp[money.length - 3][1] + money[money.length - 1]) {
	            dp[money.length - 1][1] = Math.max(dp[money.length - 2][1], dp[money.length - 3][1]);
	        }

	        answer = Math.max(dp[money.length - 1][1], dp[money.length - 1][0]);
	        
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int[] money = {1, 3, 2, 4};
		Solution s = new Solution();
		int res = s.solution(money);
		System.out.println(res);
	}
}
