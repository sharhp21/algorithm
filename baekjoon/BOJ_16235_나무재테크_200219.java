package algo;

import java.io.*;
import java.util.*;

class Tree implements Comparable<Tree> {
	int x;
	int y;
	int age;
	public Tree(int x, int y, int age) {
		this.x = x;
		this.y = y;
		this.age = age;
	}
	
	public int compareTo(Tree o) {
		return this.age - o.age;
	}
}
public class BOJ_16235_나무재테크_200219 {
	final static int[] DX = {0, 0, 1, 1, 1, -1, -1, -1};
	final static int[] DY = {1, -1, 1, 0, -1, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][n];
		for(int[] arr : map) Arrays.fill(arr, 5);
		int[][] a = new int[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		PriorityQueue<Tree> list = new PriorityQueue<>();
		Queue<Tree> list2 = new LinkedList<>();
		Queue<Tree> deadTree = new LinkedList<>();
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());
			list.offer(new Tree(x, y, age));
		}
		
		while(k > 0) {
			k--;
			deadTree = new LinkedList<>();
			// 봄
			while(!list.isEmpty()) {
				Tree t = list.poll();
				if(map[t.x][t.y] >= t.age) { // 양분 먹기
					map[t.x][t.y] -= t.age;
					t.age++;
					list2.offer(t);
				} else { // 양분 못먹는 나무들 죽음
					deadTree.offer(new Tree(t.x, t.y, t.age)); // 죽은 트리 추가
				}
			}
			
			// 여름 : 죽은나무 => 양분으로 변화
			while(!deadTree.isEmpty()) {
				Tree t = deadTree.poll();
				map[t.x][t.y] += t.age / 2;
			}
			
			// 가을 : 나무 번식
			int length = list2.size();
			while(!list2.isEmpty()) {
				Tree t = list2.poll();
				if(t.age % 5 == 0) {
					for(int j = 0; j < 8; j++) {
						if(t.x + DX[j] >= 0 && t.y + DY[j] >= 0 && t.x + DX[j] < n && t.y + DY[j] < n) {
							list.offer(new Tree(t.x + DX[j], t.y + DY[j], 1));
						}
					}
				}
				list.offer(t);
			}
			
			// 겨울 : 양분 추가
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					map[i][j] += a[i][j];
				}
			}
		}
		
		System.out.println(list.size());
	}
}