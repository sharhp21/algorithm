import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15665_N°úM11_200304 {
	static int[] arr;
	static int[] res;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		res = new int[m];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		comb(0, m);
		
		System.out.print(sb);
	}
	public static void comb(int count, int m) {
		if(count == m) {
			for(int i : res) sb.append(i).append(" ");
			sb.append('\n');
			return;
		}
		
		for(int i = 0; i < arr.length; i++) {
			if(res[count] != arr[i]) {
				res[count] = arr[i];
				comb(count + 1, m);
			}

		}
		
		res[count] = 0;
	}
}
