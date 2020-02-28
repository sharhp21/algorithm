import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1952_������_200228 {
	static int[] fee;
	static int[] usePlan;
	static int[] cheepFee;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for(int testcase = 1; testcase <= TC; testcase++) {
			fee = new int[4]; // 1��, 1��, 3��, 1��
			usePlan = new int[12]; // 1�� ~ 12�� ��� Ƚ��
			cheepFee = new int[12];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < 4; i++) {
				fee[i] = Integer.parseInt(st.nextToken());
			}			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < 12; i++) {
				usePlan[i] = Integer.parseInt(st.nextToken());
			}
			
			min = 0;
			// 1�� �̿�� vs 1�ޱ��� �� �θ� 1�ޱ� ����
			for(int i = 0; i < 12; i++) {
				if(usePlan[i] * fee[0] > fee[1]) {
					cheepFee[i] = fee[1];
					min += cheepFee[i];
				}
				else {
					cheepFee[i] = usePlan[i] * fee[0];
					min += cheepFee[i];
				}
			}
			// 3�ޱ� ����
			int sum = 0;
			dfs(0, sum);
			
			// 1�� �̿��
			if(min > fee[3]) min = fee[3];
			
			
			
			
			sb.append("#").append(testcase).append(" ").append(min).append('\n');
		}
		System.out.println(sb);
	}
	
	public static void dfs(int now, int sum) {
		if(now >= 12) {
			if(min > sum)
				min = sum;
			return;
		}
		for(int i = now; i < 12; i++) {
			//System.out.println(i);
			sum += fee[2];
			dfs(i + 3, sum);
			sum -= fee[2];
			sum += cheepFee[i];
		}
		
		if(min > sum) min = sum;
	}
}
