package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 환경 부담 세율(E)과 각 해저터널 길이(L)의 제곱의 곱(E * L2)
public class SWEA_1251_하나로_Prim_200311 {
	static class MinDist implements Comparable<MinDist>{
		int index;
		double distance;
		MinDist(int index, double distance) {
			this.index = index;
			this.distance = distance;
		}
		public int compareTo(MinDist o) {
			return (int)(this.distance - o.distance);
		}
	}
	static double[] distance;
	static double[][] island;
	static boolean[] check;
	static double E;
	static PriorityQueue<MinDist> pq;
	static long ans;
	static int checkCnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int testcase = 1; testcase <= TC; ++testcase) {
			int n = Integer.parseInt(br.readLine()); // 섬의 개수
			island = new double[n][2];
			check = new boolean[n];
			distance = new double[n];
			pq = new PriorityQueue<>();
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < n; i++) island[i][0] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < n; i++) island[i][1] = Integer.parseInt(st.nextToken());
			
			E = Double.parseDouble(br.readLine());
			
			Arrays.fill(distance, Double.MAX_VALUE);
			distance[0] = 0.0;
			check[0] = true;
			checkCnt = 1;
			
			for(int i = 1; i < island.length; i++) {
				distance[i] = dist(0, i);
				pq.offer(new MinDist(i, distance[i]));
			}
			
			prim();
			
			double tmp = 0;
			for(int i = 0; i < n; i++) tmp += distance[i];
			ans = (long)Math.round(tmp * E);
			
			sb.append("#").append(testcase).append(" ").append(ans).append('\n');
		}
		System.out.print(sb);
	}
	
	private static void prim() {
		while(!pq.isEmpty()) {
			if(checkCnt >= check.length) return;
			MinDist md = pq.poll();
			if(check[md.index]) continue;
			check[md.index] = true;
			checkCnt++;
			for(int i = 0; i < island.length; i++) {
				if(!check[i]) {
					double d = dist(md.index, i);
					if(distance[i] > d) {
						distance[i] = d;
						pq.offer(new MinDist(i, distance[i]));
					}
				}
			}
		}
	}
	
	private static double dist(int a, int b) {
		return (island[a][0] - island[b][0]) * (island[a][0] - island[b][0])
				+ (island[a][1] - island[b][1]) * (island[a][1] - island[b][1]);
	}
}
