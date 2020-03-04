import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650_N°úM2_200303 {
	static int[] check;
	static int[] arr;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		check = new int[n + 1];
		arr = new int[m];
		
		comb(0, 1, n, m);
		
		System.out.print(sb);
	}
	
	public static void comb(int count, int x, int n, int m) {
		if(count == m) {
			for(int i = 1; i < n + 1; i++) {
				if(check[i] == 1) {
					sb.append(i).append(" ");
				}
			}
			sb.append('\n');
			return;
		}
		
		for(int i = x; i <= n; i++) {
			if(check[i] == 0) {
				check[i] = 1;
				arr[count] = i;
				comb(count + 1, i, n, m);
				check[i] = 0;
			}
		}
	}
}
