package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Shark {
	int size;
	int speed;
	int brain;
	
	public Shark(int size, int speed, int brain) {
		this.size = size;
		this.speed = speed;
		this.brain = brain;
	}
}
public class BOJ_1671_상어의저녁식사_200218 {
	static List<Integer>[] list;
	static int[] visited;
	static int[] b;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		List<Shark> shark = new ArrayList<>();
		list = new ArrayList[n];
		for(int i = 0; i < n; i++) list[i] = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int size = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int brain = Integer.parseInt(st.nextToken());
			shark.add(new Shark(size, speed, brain));
		}
		
		for(int i = 0; i < shark.size() - 1; i++) {
			for(int j = i + 1; j < shark.size(); j++) {
				if(shark.get(i).size >= shark.get(j).size && shark.get(i).speed >= shark.get(j).speed 
						&& shark.get(i).brain >= shark.get(j).brain) {
					list[i].add(j);
				} 
				
				if(shark.get(i).size <= shark.get(j).size && shark.get(i).speed <= shark.get(j).speed 
						&& shark.get(i).brain <= shark.get(j).brain) {
					if(shark.get(i).size == shark.get(j).size && shark.get(i).speed == shark.get(j).speed 
							&& shark.get(i).brain == shark.get(j).brain) {
						continue;
					}
					list[j].add(i);
				}
			}
		}
		
		visited = new int[n];
		b = new int[n];
		Arrays.fill(b, -1);
		
		int ans = n;
		for(int i = 0; i < n; i++) {
			visited = new int[n];
			ans -= dfs(i);
			visited = new int[n];
			ans -= dfs(i);
		}
		
		System.out.println(ans);
	}
	
	public static int dfs(int now) {
		if(visited[now] == 1) return 0;
		visited[now] = 1;
		for(int i = 0; i < list[now].size(); i++) {
			int next = list[now].get(i);
			if(b[next] == -1 || dfs(b[next]) == 1) {
				b[next] = now;
				return 1;
			}
		}
		return 0;
	}
}
