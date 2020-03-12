package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class SWEA_7701_염라대왕의이름정렬_200312_Treeset {
	static TreeSet<String> set;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= TC; ++testcase) {
			int n = Integer.parseInt(br.readLine());
			set = new TreeSet<>(new Comparator<String>() { // 내부에서 comparator 객체 사용법
				public int compare(String s1, String s2) {
					int length = s1.length() - s2.length();
					if (length == 0) {
						return s1.compareTo(s2);
					} else
						return length;
				};
			});
			
			for (int i = 0; i < n; i++) set.add(br.readLine());

			sb.append("#").append(testcase).append('\n');
//			for(String str : set) sb.append(str).append('\n');
			Iterator it = set.iterator();
			while(it.hasNext()) sb.append(it.next()).append('\n'); // iterator 사용해서 출력
		}
		System.out.print(sb);
	}
}
