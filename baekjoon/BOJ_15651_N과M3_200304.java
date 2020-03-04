import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15651_N°úM3_200304 {
	static int[] arr;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];
		comb(0, n, m);
		
		System.out.print(sb);
	}
	private static void comb(int count, int n, int m) {
		if(count == m) {
			for(int i : arr) {
				sb.append(i).append(" ");
			}
			sb.append('\n');
			return;
		}
		
		for(int i = 1; i <= n; i++) {
			arr[count] = i;
			comb(count + 1, n, m);
		}
	}
}
