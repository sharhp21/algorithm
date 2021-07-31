import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	long loc; int idx;
	public Node(long loc, int idx) {
		this.loc = loc;
		this.idx = idx;
	}
	
	public int compareTo(Node o) {
		if(this.loc > o.loc) {
			return 1;
		}
		else return -1;
	}
}

class Info implements Comparable<Info> {
	int end;
	long dist;
	
	public Info(int end, long dist) {
		this.end = end;
		this.dist = dist;
	}
	
	public int compareTo(Info o) {
		if(this.dist > o.dist) return 1;
		else return -1;
	}
}

public class BOJ_2887_행성터널 {
	static int n;
	static Node[] planetX;
	static Node[] planetY;
	static Node[] planetZ;
	static boolean[] check;
	static Queue<Integer> visit;
	static PriorityQueue<Info> mst;
	static List<Info> infoList;
	static List<Info>[] distance;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		planetX = new Node[n];
		planetY = new Node[n];
		planetZ = new Node[n];
		check = new boolean[n];		
		visit = new LinkedList<Integer>();
		mst = new PriorityQueue<Info>();
		
		Node[] arr = new Node[n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			planetX[i] = new Node(Long.parseLong(st.nextToken()), i);
			planetY[i] = new Node(Long.parseLong(st.nextToken()), i);
			planetZ[i] = new Node(Long.parseLong(st.nextToken()), i);
		}
		
		Arrays.sort(planetX);
		Arrays.sort(planetY);
		Arrays.sort(planetZ);
		
		infoList = new LinkedList<>();
		
		distance = new LinkedList[n];
		for(int i = 0; i < n; i++) {
			distance[i] = new LinkedList<>();
		}
		
		for(int i = 0; i < n - 1; i++) {
			distance[planetX[i].idx].add(new Info(planetX[i + 1].idx, planetX[i + 1].loc - planetX[i].loc));
			distance[planetY[i].idx].add(new Info(planetY[i + 1].idx, planetY[i + 1].loc - planetY[i].loc));
			distance[planetZ[i].idx].add(new Info(planetZ[i + 1].idx, planetZ[i + 1].loc - planetZ[i].loc));
			
			distance[planetX[i + 1].idx].add(new Info(planetX[i].idx, planetX[i + 1].loc - planetX[i].loc));
			distance[planetY[i + 1].idx].add(new Info(planetY[i].idx, planetY[i + 1].loc - planetY[i].loc));
			distance[planetZ[i + 1].idx].add(new Info(planetZ[i].idx, planetZ[i + 1].loc - planetZ[i].loc));
		}
		
		System.out.println(prim());
		
	}
	
	public static long prim() {
		long ans = 0;
		check[0] = true;
		visit.add(0);
		
		while(!visit.isEmpty()) {
			int now = visit.poll();
			check[now] = true;
			
			for(int i = 0; i < distance[now].size(); i++) {
				Info info = distance[now].get(i);
				if(!check[info.end]) {
					mst.add(info);
				}
			}
			
			while(!mst.isEmpty()) {
				Info nextInfo = mst.poll();
				
				if(!check[nextInfo.end]) {
					visit.add(nextInfo.end);
					ans += nextInfo.dist;
					break;
				}
			}
		}
		
		return ans;
	}
}
