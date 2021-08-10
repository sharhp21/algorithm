package 프로그래머스;

public class PROG_행렬테두리회전하기 {
	public static void main(String[] args) {
		int rows = 6;
		int columns = 6;
		int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		
		int[] answer = solution(rows, columns, queries);
		
		for(int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
		
		System.out.println();
	}
	
	public static int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];

		int[][] map = new int[rows][columns];
		int inputNum = 1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				map[i][j] = inputNum++;
			}
		}

		for (int idx = 0; idx < queries.length; idx++) {
			int min = 10001;

			int x1 = queries[idx][0] - 1;
			int y1 = queries[idx][1] - 1;
			int x2 = queries[idx][2] - 1;
			int y2 = queries[idx][3] - 1;

			// 회전
			int temp = map[x1][y1];
			if (min > temp) min = temp;
			for (int i = x1; i < x2; i++) {
				map[i][y1] = map[i + 1][y1];
				if (min > map[i][y1]) min = map[i][y1];
			}
			for (int j = y1; j < y2; j++) {
				map[x2][j] = map[x2][j + 1];
				if (min > map[x2][j]) min = map[x2][j];
			}
			for (int i = x2; i > x1; i--) {
				map[i][y2] = map[i - 1][y2];
				if (min > map[i][y2]) min = map[i][y2];
			}
			for (int j = y2; j > y1; j--) {
				map[x1][j] = map[x1][j - 1];
				if (min > map[x1][j]) min = map[x1][j];
			}
			map[x1][y1 + 1] = temp;

			answer[idx] = min;
		}

		return answer;
	}
}
