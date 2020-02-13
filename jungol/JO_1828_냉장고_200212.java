package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Temperature implements Comparable<Temperature>{
	int minTemper;
	int maxTemper;
	
	public Temperature() {}
	public Temperature(int minTemper, int maxTemper) {
		this.minTemper = minTemper;
		this.maxTemper = maxTemper;
	}
	public int compareTo(Temperature t) {
		if(this.maxTemper > t.maxTemper) {
			return 1;
		} else if(this.maxTemper == t.maxTemper) {
			if(this.minTemper > t.minTemper) {
				return 1;
			}
		}
		return -1;
	}
}
public class JO_1828_냉장고_200212 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int ans = 0;
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Temperature> pq = new PriorityQueue<Temperature>();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int min = Integer.parseInt(st.nextToken());
			int max = Integer.parseInt(st.nextToken());
			pq.offer(new Temperature(min, max));
		}
		
		while(!pq.isEmpty()) {
			ans++;
			int end = pq.poll().maxTemper;
			while(!pq.isEmpty() && end >= pq.peek().minTemper) {
				pq.poll();
			}
		}
		
		System.out.println(ans);
	}
}
