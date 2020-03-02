import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Connect implements Comparable<Connect>{
	int v1;
	int v2;
	int w;
	public Connect(int _v1, int _v2, int _w) {
		this.v1 = _v1;
		this.v2 = _v2;
		this.w = _w;
	}
	public int compareTo(Connect o) {
		return this.w - o.w;
	}
}

public class BOJ_1922_네트워크연결_200302 {
	static List<Connect> list;
	static int[] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.add(new Connect(x, y, w));
		}
		
		parent = new int[n + 1];
		for(int i = 1; i < n + 1; i++) parent[i] = i;
		
		Collections.sort(list);
		
		int sum = 0;
		for(int i = 0; i < list.size(); i++ ) {
			Connect c = list.get(i);
			if(!isSameParent(c.v1, c.v2)) {
				sum += c.w;
				union(c.v1, c.v2);
			}
		}
		
		System.out.println(sum);
	}
	
	public static int find(int x) {
		if(x == parent[x]) return x;
		else return parent[x] = find(parent[x]);
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y) {
			parent[y] = x;
		}
	}
	
	public static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) return true;
		else return false;
	}
}
