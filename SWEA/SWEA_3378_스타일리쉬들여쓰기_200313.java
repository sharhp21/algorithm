package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3378_스타일리쉬들여쓰기_200313 {
	static int p, q;
	static int R, C, S;
	static int a, b, c;
	static int[][][] RCS;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int testcase = 1; testcase <= TC; ++testcase) {
			RCS = new int[21][21][21]; // 1이면 안되는 조합
			st = new StringTokenizer(br.readLine(), " ");
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());

			a = 0; b = 0; c = 0;
			for(int line = 0; line < p; line++) { // 스타일리쉬 확인
				String str = br.readLine();
				int cnt = 0;
				int temp = 0;
				for(int i = 0; i < str.length(); i++) {
					char ch = str.charAt(i);
					if(i == 0 && ch == '.') {
						while(ch == '.') {
							cnt++;
							i++;
							ch = str.charAt(i);
						}
					}
					temp = i;
					break;
				}
				
				if(line != 0) {
					for(int i = 1; i < 21; i++) {
						for(int j = 1; j < 21; j++) {
							for(int k = 1; k < 21; k++) {
								if(RCS[i][j][k] == 1) continue; // 원래 안되는거면 넘어가
								if(a * i + b * j + c * k != cnt) { // 계산값이랑 .의 개수랑 다르면 안되는 조합으로 체크
									RCS[i][j][k] = 1;
								}
							}
						}
					}
				}
				
				for(int i = temp; i < str.length(); i++) {
						char ch = str.charAt(i);
						if(ch == '(') a++;
						else if(ch == ')') a--;
						else if(ch == '{') b++;
						else if(ch == '}') b--;
						else if(ch == '[') c++;
						else if(ch == ']') c--;
				}
				
			}
			
			sb.append("#").append(testcase).append(" ").append(0).append(" ");
			a = 0; b = 0; c = 0;
			for(int line = 0; line < q; line++) {
				String str = br.readLine();
				if(line == q - 1) break;
				int ans = -1;
				int flag = 0;
				for(int i = 0; i < str.length(); i++) {
					char ch = str.charAt(i);
					if(ch == '(') a++;
					else if(ch == ')') a--;
					else if(ch == '{') b++;
					else if(ch == '}') b--;
					else if(ch == '[') c++;
					else if(ch == ']') c--;
				}
				
				for(int i = 1; i < 21; i++) {
					for(int j = 1; j < 21; j++) {
						for(int k = 1; k < 21; k++) {
							if(RCS[i][j][k] == 0) { // 되는 조합 중
								if(ans == -1) { // 처음 되는 조합 발견
									ans = i * a + j * b + k * c; // ans 갱신
								} else { // 되는 조합 재 발견
									if(ans == i * a + j * b + k * c) continue; // 기존 ans랑 같다면 넘어감
									else { // 다른 값이 나오면 안되는 거
										flag = 1;
										break;
									}
								}
							}
						}
						if(flag == 1) break;
					}
					if(flag == 1) break;
				}
				if(flag == 1) ans = -1;
				sb.append(ans).append(" ");
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
}
