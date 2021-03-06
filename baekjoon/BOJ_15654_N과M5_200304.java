import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15654_N��M5_200304 {
	static int[] arr;
	static int[] res;
	static boolean[] check;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		res = new int[m];
		check = new boolean[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		comb(0, -1, m);
		
		System.out.print(sb);
	}
	
	public static void comb(int count, int x, int m) {
		if(count == m) {
			for(int i : res) sb.append(i).append(" ");
			sb.append('\n');
			return;
		}
		
		for(int i = 0; i < arr.length; i++) {
			if(!check[i]) {
				check[i] = true;
				res[count] = arr[i];
				comb(count + 1, i, m);
				check[i] = false;
			}
		}
	}
}
