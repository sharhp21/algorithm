import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Path implements Comparable<Path>{
	int v1;
	int v2;
	int cost;
	public Path(int v1, int v2, int cost) {
		this.v1 = v1;
		this.v2 = v2;
		this.cost = cost;
	}
	public int compareTo(Path o) {
		return this.cost - o.cost;
	}
}

public class BOJ_1647_도시분할계획_200302 {
	static List<Path> list;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		parent = new int[n + 1];
		for(int i = 1; i < n + 1; i++) parent[i] = i;
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list.add(new Path(v1, v2, cost));
		}
		
		Collections.sort(list);
		
		int sum = 0;
		int divide = 0;
		for(int i = 0; i < list.size(); i++) {
			Path p = list.get(i);
			if(!isSameParent(p.v1, p.v2)) {
				sum += p.cost;
				union(p.v1, p.v2);
				divide = p.cost;
			}
		}
		System.out.println(sum - divide);
	}
	
	public static int find(int x) {
		if(x == parent[x]) return x;
		else return parent[x] = find(parent[x]);
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x > y) parent[x] = y;
		else if(y > x) parent[y] = x;
	}
	
	public static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) return true;
		return false;
	}
}
