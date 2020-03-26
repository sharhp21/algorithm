package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1242_소풍_200326 {
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long n = Integer.parseInt(st.nextToken()); //전체인원
		long k = Integer.parseInt(st.nextToken()); //퇴장번호
		long m = Integer.parseInt(st.nextToken()); //동호위치
		
		while(true) {
			long flag = 0;
			if(m % k == 0) {
				ans += m / k;
				break;
			}
			else {
				flag = n % k;
				ans += n / k;
				n -= n / k;
				m = m - m / k + flag;
			}
		}
		
		System.out.println(ans);
	}
}
