package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11375_열혈강호_200214 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<Integer>[] map = new ArrayList[n];
		for(int i = 0; i < n; i++) map[i] = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int cnt = Integer.parseInt(st.nextToken());
			for(int j = 0; j < cnt; j++) {
				map[i].add(Integer.parseInt(st.nextToken()) - 1);
			}
		}
		
		int[] b = new int[m];
		Arrays.fill(b, -1);
		int[] visited;
		
		int sum = 0;
		for(int i = 0; i < n; i++) {
			visited = new int[n];
			sum += dfs(map, visited, b, i);
		}
		
		System.out.println(sum);
	}
	
	public static int dfs(List<Integer>[] map, int[] visited, int[] b, int now) {
		if(visited[now] == 1) return 0;
		visited[now] = 1;
		for(int i = 0; i < map[now].size(); i++) {
			int next = map[now].get(i);
			if(b[next] == -1 || dfs(map, visited, b, b[next]) == 1) {
				b[next] = now;
				return 1;
			}
		}
		return 0;
	}
}
