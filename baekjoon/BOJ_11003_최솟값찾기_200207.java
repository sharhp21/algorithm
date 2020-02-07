package algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11003_최솟값찾기_200207 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] num = new int[n];
		int[] index = new int[n];
		int[] res = new int[n];
		
		int front = -1;
		int rear = -1;
		
		for(int i = 0; i < n; ++i) {			
			num[i] = Integer.parseInt(st.nextToken());
			while(front <= rear && rear != -1 && num[i] < num[index[rear]]) rear--;
			index[++rear] = i;
			if(front == -1 || i - index[front] >= l) front++;
			res[i] = num[index[front]];
		}
		
		for(int i = 0; i < n; ++i) bw.write(res[i] + " ");
		
		bw.flush();
		bw.close();
	}
}