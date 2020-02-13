package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class Matrix implements Comparable<Matrix>{
	int r;
	int c;
	int size;
	
	public Matrix(int r, int c, int size) {
		this.r = r;
		this.c = c;
		this.size = size;
	}
	
	public int compareTo(Matrix m) {
		if(this.size > m.size) {
			return 1;
		} else if(this.size == m.size) {
			if(this.r > m.r) {
				return 1;
			}
		}
		return -1;
	}
	
}
public class SWEA_1258_행렬찾기_200212 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for(int testcase = 1; testcase <= TC; ++testcase) {
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			List<Matrix> list = new LinkedList<Matrix>();
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					int row = 0;
					int col = 0;
					int size = 0;
					if(map[i][j] != 0) {
						if(i == 0 && j == 0) {
							while(i + row < n && map[i + row][j] != 0) row++;
							while(j + col < n && map[i][j + col] != 0) col++;
							size = row * col;
							list.add(new Matrix(row, col, size));
						} else if(i != 0 && j == 0) {
							if(map[i - 1][j] == 0) {
								while(i + row < n && map[i + row][j] != 0) row++;
								while(j + col < n && map[i][j + col] != 0) col++;
								size = row * col;
								list.add(new Matrix(row, col, size));
							}
						} else if(i == 0 && j != 0) {
							if(map[i][j - 1] == 0) {
								while(i + row < n && map[i + row][j] != 0) row++;
								while(j + col < n && map[i][j + col] != 0) col++;
								size = row * col;
								list.add(new Matrix(row, col, size));
							}
						} else {
							if(map[i][j - 1] == 0 && map[i - 1][j] == 0) {
								while(i + row < n && map[i + row][j] != 0) row++;
								while(j + col < n && map[i][j + col] != 0) col++;
								size = row * col;
								list.add(new Matrix(row, col, size));
							}
						}
					}
				}
			}
			Collections.sort(list);
			
			sb.append("#" + testcase + " " + list.size() + " ");
			for(int i = 0; i < list.size(); i++) {
				Matrix m = list.get(i);
				sb.append(m.r + " " + m.c + " ");
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
}
