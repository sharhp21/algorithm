package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Earthworm {
	int x;
	int y;

	public Earthworm(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class SWEA_1494_사랑의카운슬러_200213 {
	static long min = Long.MAX_VALUE;
	static long sumX = 0;
	static long sumY = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= TC; ++testcase) {
			min = Long.MAX_VALUE;
			int n = Integer.parseInt(br.readLine());
			Earthworm[] e = new Earthworm[n];
			int[] check = new int[n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				e[i] = new Earthworm(x, y);
			}	

			start(e, check, 0, 0);

			sb.append("#" + testcase + " " + min + '\n');
		}
		System.out.print(sb);
	}

	public static void start(Earthworm[] e, int[] check, int count, int pivot) {		
		if (pivot == e.length) {
			if(min > sumX * sumX + sumY * sumY) min = sumX * sumX + sumY * sumY;
			return;
		}

		if (count < e.length / 2) {
			check[pivot] = 1;
			sumX += e[pivot].x;
			sumY += e[pivot].y;
			start(e, check, count + 1, pivot + 1);
			sumX -= e[pivot].x;
			sumY -= e[pivot].y;
		}
		if (pivot - count < e.length / 2) {
			check[pivot] = 0;
			sumX -= e[pivot].x;
			sumY -= e[pivot].y;
			start(e, check, count, pivot + 1);
			sumX += e[pivot].x;
			sumY += e[pivot].y;
		}
	}
}
