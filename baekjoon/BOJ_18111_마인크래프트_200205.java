import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18111_마인크래프트_200205 {
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int block = Integer.parseInt(st.nextToken());
		long sum = 0;
		
		long[][] map = new long[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				sum += map[i][j];
			}
		}
		
		if(n != 0 && m != 0) {
			long avgLow = sum / (n * m);
			long avgHigh = 0;
			long time = 987654321;
			long height = 0;
			
			if((sum + block) / (n * m) <= 256) {
				avgHigh = (sum + block) / (n * m);
			} else {
				avgHigh = 256;
			}
			
			for(long avg = avgLow; avg <= avgHigh; avg++) {
				long timeTmp = 0;
				for(int i = 0; i < n; i++) {
					for(int j = 0; j < m; j++) {
						if(map[i][j] > avg) {
							timeTmp += (map[i][j] - avg) * 2;
						} else if(map[i][j] < avg) {
							timeTmp += (avg - map[i][j]);
						}
					}
				}
				
				if(time >= timeTmp) {
					time = timeTmp;
					height = avg;
				}
			}
			
			System.out.println(time + " " + height);

		} else {
			System.out.println(0 + " " + 0);
		}
	}
}
