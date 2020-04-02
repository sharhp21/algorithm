package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17281_야구_200328 {
	static int[][] map;
	static int[] arr;
	static int[] field;
	static int max = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		map = new int[n][9];
		arr = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8 };
		field = new int[3]; // 0 홈, 1/2/3 루
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//long time = System.currentTimeMillis();
		do {
			int order = 0;
			int score = 0;
			for(int i = 0; i < n; i++) { // 이닝 수
				int out = 0;
				while(true) {
					if(out == 3) {
						Arrays.fill(field, 0);
						break;
					}
					// 선수 입장
					int tasu;
					if(order == 3) tasu = map[i][0];
					else if(order < 3) {
						tasu = map[i][arr[order]];
					} else {
						tasu = map[i][arr[order - 1]];
					}
						
					// 친다
					if(tasu == 0) out++;
					else {
						for(int j = 2; j >= 0; j--) {
							if(tasu + j >= 3) {
								score += field[j];
								field[j] = 0;
							} else {
								field[tasu + j] = field[j];
								field[j] = 0;
							}	
						}
						if(tasu < 4) field[tasu - 1] = 1;
						else score++;
					}

					order = (order + 1) % 9;
				}
				
			}
			
			if(max < score) max = score;
		} while (nextPermutation());
		
		//System.out.println(System.currentTimeMillis() - time);
		System.out.println(max);
	}
	
	public static boolean nextPermutation() {
		int i, j;
		for(i = arr.length - 1; i > 0; i--) {
			if(arr[i] > arr[i - 1]) break;
		}

		if(i == 0) return false;
		
		for(j = arr.length - 1; j >= 0; j--) {
			if(arr[i - 1] < arr[j]) break;
		}
		
		int temp = arr[i - 1];
		arr[i - 1] = arr[j];
		arr[j] = temp;
		
		j = arr.length - 1;
		
		while(i < j) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		
		return true;
	}
}
