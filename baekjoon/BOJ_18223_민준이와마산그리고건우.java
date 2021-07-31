import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_18223_민준이와마산그리고건우 {
	static class Pos implements Comparable<Pos> {
		int x, y;
		int dist;
		int gunWoo;
		public Pos(int y, int dist) {
			this.y = y;
			this.dist = dist;
		}
		public Pos(int y, int dist, int gunWoo) {
			this.y = y;
			this.dist = dist;
			this.gunWoo = gunWoo;
		}
		@Override
		public int compareTo(Pos p) {
			if(this.dist > p.dist) {
				return 1;
			} else if(this.dist < p.dist) {
				return -1;
			} else {
				if(this.gunWoo == 1) return -1;
				else if(p.gunWoo == 1) return 1;
				return -1;
			}
		}
	}
	
	static int V, E, P;
	static List<Pos>[] list;
	static int[] distance;
	static PriorityQueue<Pos> pq;
	static String answer = "GOOD BYE";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		list = new ArrayList[V + 1];
		distance = new int[V + 1];
		pq = new PriorityQueue<>();
		
		for(int i = 1; i <= V; i++) {
			list[i] = new ArrayList<Pos>();
			distance[i] = 1000000000;
		}
		
		for(int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			
			list[start].add(new Pos(end, distance));
			list[end].add(new Pos(start, distance));
		}
		
		distance[1] = 0;
		
		if(P == 1 || P == V) {
			answer = "SAVE HIM";
		} else {
			dijkstra();
		}
		
		System.out.println(answer);
 	}
	
	public static void dijkstra() {
		int gunWoo = 0;
		pq.offer(new Pos(1, 0, 0));
		while(!pq.isEmpty()) {
			Pos pp = pq.poll();
			if(V == pp.y) {
				if(pp.gunWoo == 1) answer = "SAVE HIM";
				break;
			}
			for(int i = 0; i < list[pp.y].size(); i++) {
				Pos np = list[pp.y].get(i);
				if(distance[np.y] >= distance[pp.y] + np.dist) {
					if(P == np.y || 1 == pp.gunWoo) gunWoo = 1;
					else gunWoo = 0;
					pq.offer(new Pos(np.y, np.dist, gunWoo));
					distance[np.y] = distance[pp.y] + np.dist;
				}
			}
			
		}
	}
}
