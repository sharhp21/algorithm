import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Line implements Comparable<Line> {
	int index;
	int depth;
	public Line(int index, int depth) {
		this.index = index;
		this.depth = depth;
	}
	public int compareTo(Line o) {
		return this.depth - o.depth;
	}
}
public class BOJ_2252_�ټ����_200227 {
	static Line[] line;
	static int[] check;
	static List<Integer>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n + 1];
		line = new Line[n + 1]; // index�� depth ������ �迭
		for(int i = 1; i < n + 1; i++) {
			line[i] = new Line(i, 0);
		}
		check = new int[n + 1];
		for(int i = 1; i < n + 1; i++) list[i] = new ArrayList<>();
		
		// ���Ḯ��Ʈ ����
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[s].add(c);
			check[c] = 1; // depth���� ���ϱ� ���ؼ��� ���� ������ ��常 �ʿ���
		}
		
		for(int i = 1; i < list.length; i++) {
			if(check[i] == 0) {
				// ���� ���� ��忡���� dfs
				dfs(i);
			}
		}

		Arrays.sort(line, 1, n + 1); // depth ���� �������� ����
		
		for(int i = 1; i < n + 1; i++) {
			System.out.print(line[i].index + " ");
		}
		System.out.println();
	}
	
	public static void dfs(int now) {
		for(int i = 0; i < list[now].size(); i++) {
			int next = list[now].get(i);
			if(line[next].depth < line[now].depth + 1) { // �� ���� depth �����ϸ� ���� 
				line[next].depth = line[now].depth + 1;
				dfs(next);
			}
		}
	}
}
