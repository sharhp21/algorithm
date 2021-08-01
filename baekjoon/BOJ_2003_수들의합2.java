package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003_수들의합2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] A = new int[n + 1];
		int answer = 0;
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int p1 = 0;
		int p2 = 0;
		int sum = A[p1];
		
		while(true) {
			if(p2 == n || p1 == n) break;
			
			if(sum < m) {
				sum += A[++p2];
			} else if(sum == m) {
				sum -= A[p1++];
				sum += A[++p2];
				answer++;
			} else {
				sum -= A[p1++];
			}
		}
		
		System.out.println(answer);
	}
}
