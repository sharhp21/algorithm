package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Sort implements Comparable<Sort>{
	int number;
	int count;
	public Sort(int number, int count) {
		this.number = number;
		this.count = count;
	}
	public int compareTo(Sort o) {
		if(this.count > o.count) {
			return 1;
		} else if(this.count == o.count) {
			if(this.number > o.number) {
				return 1;
			}
		}
		return -1;
	}
}
public class BOJ_17140_이차원배열과연산_200219 {
	static PriorityQueue<Sort> pq;
	static int[][] map;
	static int[] cnt;
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken()) - 1;
		int c = Integer.parseInt(st.nextToken()) - 1;
		int k = Integer.parseInt(st.nextToken());
		
		map = new int[100][100];
		int R = 3;
		int C = 3;
		for(int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		pq = new PriorityQueue<>();
		
		while(true) {	
			if(map[r][c] == k) {
				break;
			}
			if(ans >= 100) {
				ans = -1;
				break;
			}
			ans++;

			if(R >= C) {
				int newC = 0;
				for(int i = 0; i < R; i++) {
					cnt = new int[101];
					for(int j = 0; j < C; j++) {
						if(map[i][j] == 0) continue;
						cnt[map[i][j]]++;
					}
					
					for(int j = 1; j < 101; j++) {
						if(cnt[j] != 0) {
							pq.offer(new Sort(j, cnt[j]));
						}
					}
					
					int index = 0;
					if(newC < pq.size() * 2) newC = pq.size() * 2;
					while(!pq.isEmpty()) {
						if(index > 100) {
							pq.clear();
							break;
						}
						map[i][index++] = pq.peek().number;
						map[i][index++] = pq.peek().count;
						pq.poll();
					}
					
					for(int j = index; j < C; j++) {
						map[i][j] = 0;
					}
				}
				C = newC;
			} else {
				int newR = 0;
				for(int j = 0; j < C; j++) {
					cnt = new int[101];
					for(int i = 0; i < R; i++) {
						if(map[i][j] == 0) continue;
						cnt[map[i][j]]++;
					}
					
					for(int i = 1; i < 101; i++) {
						if(cnt[i] != 0) {
							pq.offer(new Sort(i, cnt[i]));
						}
					}
					
					int index = 0;
					if(newR < pq.size() * 2) newR = pq.size() * 2;
					while(!pq.isEmpty()) {
						if(index > 100) {
							pq.clear();
							break;
						}
						map[index++][j] = pq.peek().number;
						map[index++][j] = pq.peek().count;
						pq.poll();
					}
					
					for(int i = index; i < R; i++) {
						map[i][j] = 0;
					}
				}
				R = newR;
			}
		}
		
		System.out.println(ans);
	}
}
