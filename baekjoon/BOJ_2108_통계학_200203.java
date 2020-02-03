import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2108_≈Î∞Ë«–_200203 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[][] temp = new int[2][4001];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i] >= 0)
				temp[0][arr[i]]++;
			else temp[1][-arr[i]]++;
		}
		
		Arrays.sort(arr);
		
		int sum = 0;
		for(int i = 0; i < n; i++) {
			sum += arr[i];
		}
		
		int max = 0;
		for(int i = 0; i < 4001; i++) {
			for(int j = 0; j < 2; j++) {
				if(max < temp[j][i]) max = temp[j][i];
			}
		}

		double mean = (double)sum / n;
		int median = arr[n / 2];
		int mode = 0;
		int range = arr[n - 1] - arr[0];
		
		int count = 0;
		for(int i = 1; i >= 0; i--) {
			if(i == 1) {
				for(int j = 4000; j > 0; j--) {
					if(max == temp[i][j]) {
						count++;
						mode = -j;
						if(count == 2) {
							break;
						}
					}
				}
				if(count == 2) break;
			}
			
			else {
				for(int j = 0; j < 4001; j++) {
					if(max == temp[i][j]) {
						count++;
						mode = j;
						if(count == 2) {
							break;
						}
					}
				}
				if(count == 2) break;
			}
		}
		
		System.out.println(Math.round(mean));
		System.out.println(median);
		System.out.println(mode);
		System.out.println(range);
	}
}
