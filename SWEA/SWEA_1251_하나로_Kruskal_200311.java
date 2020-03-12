package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1251_하나로_Kruskal_200311 {
	static class LinkNode implements Comparable<LinkNode>{
		int v1, v2;
		double cost;
		LinkNode(int v1, int v2, double cost) {
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}
		public int compareTo(LinkNode o) {
			return (int)(this.cost - o.cost);
		}
	}
	static double[][] island;
	static int[] parent;
	static double E;
	static long ans;
	static List<LinkNode> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int testcase = 1; testcase <= TC; ++testcase) {
			int n = Integer.parseInt(br.readLine()); // 섬의 개수
			island = new double[n][2];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < n; i++) island[i][0] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < n; i++) island[i][1] = Integer.parseInt(st.nextToken());
			
			E = Double.parseDouble(br.readLine());
			
			parent = new int[n];
			for(int i = 0; i < n; i++) parent[i] = i;
			
			list = new ArrayList<>();
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					list.add(new LinkNode(i, j, dist(i, j)));
				}
			}
			
			Collections.sort(list);
			
			double tmp = 0.0;
			for(int i = 0; i < list.size(); i++) {
				LinkNode l = list.get(i);
				if(!isSameParent(l.v1, l.v2)) {
					tmp += l.cost;
					union(l.v1, l.v2);
				}
			}
			ans = (long)Math.round(tmp * E);
			
			sb.append("#").append(testcase).append(" ").append(ans).append('\n');
		}
		System.out.print(sb);
	}
	
	private static int find(int x) {
		if(parent[x] == x) return x;
		else return parent[x] = find(parent[x]);
	}
	
	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x > y) parent[y] = x;
		else if(x < y) parent[x] = y;
	}
	
	private static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y) return false;
		return true;
	}
	
	private static double dist(int a, int b) {
		return Math.pow((island[a][0] - island[b][0]), 2) 
				+ Math.pow((island[a][1] - island[b][1]), 2);
	}
}
