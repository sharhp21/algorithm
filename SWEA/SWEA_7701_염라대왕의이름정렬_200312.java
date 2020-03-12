package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class SWEA_7701_염라대왕의이름정렬_200312 {
	static HashSet<String> hs;
	static PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
		public int compare(String s1, String s2) {
			if (s1.length() == s2.length()) {
				return s1.compareTo(s2);
			} else
				return s1.length() - s2.length();
		}
	}); // prioirtyQueue Comparator를 이용해 정렬 기준 변경;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= TC; ++testcase) {
			int n = Integer.parseInt(br.readLine());

			hs = new HashSet<>();

			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				if (!hs.contains(str)) {
					hs.add(str);
					pq.offer(str);
				}
			}

			sb.append("#").append(testcase).append('\n');
			while (!pq.isEmpty())
				sb.append(pq.poll()).append('\n');
		}
		System.out.print(sb);
	}
}
