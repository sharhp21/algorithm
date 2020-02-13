package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Tank {
	int x;
	int y;
	int dir;
	
	public Tank() {}
	public Tank(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
}
public class SWEA_1873_상호의배틀필드_200212 {
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for(int testcase = 1; testcase <= TC; ++testcase) {
			Tank t = new Tank();
			st = new StringTokenizer(br.readLine(), " ");
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			char[][] map = new char[h + 2][w + 2];
			String str = "";
			for(int i = 1; i < h + 1; i++) {
				str = br.readLine();
				for(int j = 1; j < w + 1; j++) {
					map[i][j] = str.charAt(j - 1);
					if(map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^') {
						int dir = 0;
						if(map[i][j] == 'v') {
							dir = 2;
						} else if(map[i][j] == '<') {
							dir = 1;
						} else if(map[i][j] == '>') {
							dir = 0;
						} else if(map[i][j] == '^') {
							dir = 3;
						}
						t.x = i;
						t.y = j;
						t.dir = dir;
						map[i][j] = '.';
					}
				}
			}
			
			int n = Integer.parseInt(br.readLine());
			str = br.readLine();
			for(int i = 0; i < n; i++) {
				char ch = str.charAt(i);
				if(ch != 'S') {
					if(ch == 'U') {
						t.dir = 3;
					} else if(ch == 'D') {
						t.dir = 2;
					} else if(ch == 'L') {
						t.dir = 1;
					} else if(ch == 'R') {
						t.dir = 0;
					}
					
					char ch2 = map[t.x + dx[t.dir]][t.y + dy[t.dir]];
					if(ch2 == '.') {
						t.x += dx[t.dir];
						t.y += dy[t.dir];
					}
				} else if(ch == 'S') {
					for(int j = 1; ; j++) {
						if(t.x + dx[t.dir] * j <= 0 || t.y + dy[t.dir] * j <= 0 
								|| t.x + dx[t.dir] * j > h + 1 || t.y + dy[t.dir] * j > w + 1) {
							break;
						}
						if(map[t.x + dx[t.dir] * j][t.y + dy[t.dir] * j] == '#') {
							break;
						}
						if(map[t.x + dx[t.dir] * j][t.y + dy[t.dir] * j] == '*') {
							map[t.x + dx[t.dir] * j][t.y + dy[t.dir] * j] = '.';
							break;
						}
					}
				}
			}
			
			char ch3 = ' ';
			if(t.dir == 2) ch3 = 'v';
			else if(t.dir == 1) ch3 = '<';
			else if(t.dir == 0) ch3 = '>';
			else if(t.dir == 3) ch3 = '^';
			map[t.x][t.y] = ch3;
			
			sb.append("#" + testcase + " ");
			for(int i = 1; i < h + 1; i++) {
				for(int j = 1; j < w + 1; j++) {
					sb.append(map[i][j]);
				}
				sb.append('\n');
			}
		}
		
		System.out.println(sb);
	}
}
