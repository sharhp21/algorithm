package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_5430_AC_200206 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int TC = Integer.parseInt(br.readLine());
		for(int testcase = 0; testcase < TC; ++testcase) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String arr = br.readLine().replace("[", "");
			arr = arr.replace("]", "");
			StringTokenizer st = new StringTokenizer(arr, ",");
			
			Deque<Integer> dq = new LinkedList<>();
			int dir = 0;
			while(st.hasMoreTokens()) {
				dq.offer(Integer.parseInt(st.nextToken()));
			}
			
			for(int i = 0; i < p.length(); i++) {
				String str = p.substring(i, i + 1);
				if(str.equals("R")) {
					dir = dir ^ 1;
				} else {
					if(dq.isEmpty()) {
						dir = -1;
						break;
					}
					else if(dir == 0) {
						dq.pollFirst();
					} else {
						dq.pollLast();
					}
				}
			}
			
			if(dir == -1) {
				sb.append("error\n");
			} else {
				sb.append("[");
				if(dq.size() != 0) {
					if(dir == 0) {
						while(dq.size() > 1) {
							sb.append(dq.pollFirst() + ",");
						}
						sb.append(dq.poll());
					} else {
						while(dq.size() > 1) {
							sb.append(dq.pollLast() + ",");
						}
						sb.append(dq.poll());
					}
				}
				sb.append("]\n");
			}
		}
		
		System.out.println(sb);
	}
}
