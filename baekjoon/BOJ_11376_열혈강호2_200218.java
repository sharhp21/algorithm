package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11376_열혈강호2_200218 {
	static List<Integer>[] list;
	static int[] visited;
	static int[] b;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) list[i] = new ArrayList<>();
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int cnt = Integer.parseInt(st.nextToken());
			for(int j = 0; j < cnt; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		visited = new int[n + 1];
		b = new int[m + 1];
		Arrays.fill(b, -1);
		
		int ans = 0;
		for(int i = 1; i <= n; i++) {
			visited = new int[n + 1];
			ans += dfs(i);
			visited = new int[n + 1];
			ans += dfs(i);
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
