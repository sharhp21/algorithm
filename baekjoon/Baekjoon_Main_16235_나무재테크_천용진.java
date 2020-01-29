import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class TreeInfo implements Comparable<TreeInfo> {
	int x;
	int y;
	int age;
	
	public TreeInfo(int x, int y, int age) {
		this.x = x;
		this.y = y;
		this.age = age;
	}
	
	@Override
	public int compareTo(TreeInfo t) {
		if(this.age > t.age) {
			return 1;
		} else if(this.age < t.age) {
			return -1;
		} else {
			return 0;
		}
	}
}

public class Baekjoon_Main_16235_나무재테크_천용진 {
	public static int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
	public static int dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		int m = input.nextInt();
		int k = input.nextInt();
		int ans = 0;
		
		int[][] map = new int[n][n];
		int[][] addMap = new int[n][n];
		PriorityQueue<TreeInfo> tree = new PriorityQueue<>();
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = 5;
			}
		}
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				addMap[i][j] = input.nextInt();
			}
		}
		
		for(int i = 0; i < m; i++) {
			int x = input.nextInt();
			int y = input.nextInt();
			int age = input.nextInt();
			tree.add(new TreeInfo(x - 1, y - 1, age));
		}
		
		while(k > 0) {
			k--;
			// spring, summer	
			PriorityQueue<TreeInfo> temp = new PriorityQueue<>();
			PriorityQueue<TreeInfo> dead = new PriorityQueue<>();
			PriorityQueue<TreeInfo> food = new PriorityQueue<>();
			
			while(!tree.isEmpty()) {
				if(tree.peek().age <= map[tree.peek().x][tree.peek().y]) {
					map[tree.peek().x][tree.peek().y] -= tree.peek().age;
					temp.add(new TreeInfo(tree.peek().x, tree.peek().y, tree.peek().age + 1));
					tree.poll();
				}
				else {
					dead.add(new TreeInfo(tree.peek().x, tree.peek().y, tree.peek().age / 2));
					tree.poll();
				}
			}
			
			tree.addAll(temp);
			
			while(!dead.isEmpty()) {
				map[dead.peek().x][dead.peek().y] += dead.peek().age;
				dead.poll();
			}
			
			// fall
			while(!tree.isEmpty()) {
				if(tree.peek().age % 5 == 0) {
					for(int a = 0; a < 8; a++) {
						if(tree.peek().x + dx[a] >= 0 && tree.peek().y + dy[a] >= 0 && tree.peek().y + dy[a] < n && tree.peek().x + dx[a] < n) {
							food.add(new TreeInfo(tree.peek().x + dx[a], tree.peek().y + dy[a], 1));
						}
					}
					food.add(new TreeInfo(tree.peek().x, tree.peek().y, tree.peek().age));
					tree.poll();
				}
				else {
					food.add(new TreeInfo(tree.peek().x, tree.peek().y, tree.peek().age));
					tree.poll();
				}	
			}
			
			tree.addAll(tree);
			
			// winter
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] += addMap[i][j];
				}
			}
		}
		
		ans = tree.size();
		System.out.println(ans);
	}
}
