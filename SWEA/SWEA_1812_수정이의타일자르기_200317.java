package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_1812_수정이의타일자르기_200317 {
	static class Square implements Comparable<Square>{
		int width, height;
		Square(int w, int h) {
			if(w < h) {
				this.width = w;
				this.height = h;
			} else {
				this.width = h;
				this.height = w;
			}
		}
		public int compareTo(Square o) {
			return o.width - this.width;
		}
	}
	static PriorityQueue<Integer> pq;
	static PriorityQueue<Square> t;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for(int testcase = 1; testcase <= TC; ++testcase) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken()); // m * m 짜리 정사각형 타일밖에 팔지 않음
			
			int ans = 0;
			pq = new PriorityQueue<>(Collections.reverseOrder());
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < n; i++) {
				pq.offer(Integer.parseInt(st.nextToken()));
			}
			
			t = new PriorityQueue<>();
			
			while(!pq.isEmpty()) {
				int now = 1 << pq.poll();
				if(t.isEmpty() || t.peek().width < now) {
					ans++;
					t.offer(new Square(m, m));
				}
				
				Square tmp = t.poll();
				if(tmp.width > now) t.offer(new Square(tmp.width - now, now));
				t.offer(new Square(tmp.height - now, tmp.width));
			}
			
			sb.append('#').append(testcase).append(' ').append(ans).append('\n');
		}
		System.out.print(sb);
	}
}