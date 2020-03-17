package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4012_요리사_200317 {
	static int[][] map;
	static int[] foodA;
	static int[] foodB;
	static boolean[] isSelected;
	static int n;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int testcase = 1; testcase <= TC; ++testcase) {
			n = Integer.parseInt(br.readLine());
			map = new int[n + 1][n + 1];
			foodA = new int[n / 2];
			foodB = new int[n / 2];
			isSelected = new boolean[n + 1];
			min = Integer.MAX_VALUE;
			
			for(int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 1; j <= n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // input
			
			comb(1, 0);
			
			sb.append("#").append(testcase).append(" ").append(min).append('\n');
		}
		System.out.print(sb);
	}
	
	private static void comb(int x, int count) {
		if(count == n / 2) {
			int index = 0;
			for(int i = 1; i <= n; i++) {
				if(!isSelected[i]) foodB[index++] = i;
			}
			synergy();
			return;
		}
		for(int i = x; i <= n; i++) {
			foodA[count] = i;
			isSelected[i] = true;
			comb(i + 1, count + 1);
			isSelected[i] = false;
		}
	}
	
	private static void synergy() {
		int synergyA = 0;
		int synergyB = 0;
		for(int i = 0; i < foodA.length; i++) {
			for(int j = 0; j < foodA.length; j++) {
				synergyA += map[foodA[i]][foodA[j]];
			}
		}
		
		for(int i = 0; i < foodB.length; i++) {
			for(int j = 0; j < foodB.length; j++) {
				synergyB += map[foodB[i]][foodB[j]];
			}
		}
		int s = Math.abs(synergyA - synergyB);
		
		if(min > s) min = s;
	}
}
