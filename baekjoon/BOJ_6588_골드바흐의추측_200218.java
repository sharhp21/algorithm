package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_6588_골드바흐의추측_200218 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] arr = new int[1000001];
		arr[0] = arr[1] = 1;
		for(int i = 2; i <= 1000; i++) {
			for(int j = i * 2; j < 1000001; j += i) {
				arr[j] = 1;
			}
		}
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			
			int k = 3;
			while(true) {
				if(k > n / 2) {
					sb.append("Goldbach's conjecture is wrong.").append('\n');
					break;
				}
				if(arr[k] != 0 || arr[n - k] != 0) {
					k += 2;
					continue;
				} else {
					sb.append(n).append(" = ").append(k).append(" + ").append(n - k).append('\n');
					break;
				}
			}
		}
		
		System.out.print(sb);
	}
}
