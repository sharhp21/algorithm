package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10773_제로_200206 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> st = new Stack<>();
		int k = Integer.parseInt(br.readLine());
		long sum = 0;
		for(int i = 0; i < k; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				sum -= (long)st.pop();
			} else {
				sum += (long)st.push(num);
			}
		}
		
		System.out.println(sum);
	}
}
