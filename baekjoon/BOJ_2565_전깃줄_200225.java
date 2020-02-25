import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Pair implements Comparable<Pair> {
	int s;
	int f;
	
	public Pair(int s, int f) {
		this.s = s;
		this.f = f;
	}
	
	public int compareTo(Pair o) {
		return this.s - o.s;
	}
}
public class BOJ_2565_ภüฑ๊มู_200225 {
	static int max = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		Pair[] arr = new Pair[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());
			arr[i] = new Pair(s, f);
		}
		
		Arrays.sort(arr);
		
		int[] dp = new int[n];
		
		for(int i = 0; i < n; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(arr[j].f < arr[i].f && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
				}
			}
			if(max < dp[i]) max = dp[i];
		}
		
		System.out.print(n - max);
	}
}
