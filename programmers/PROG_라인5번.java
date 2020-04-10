package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class PROG_라인5번 {
	static class Doc implements Comparable<Doc> {
		String str;
		int count;

		Doc(String str, int count) {
			this.str = str;
			this.count = count;
		}

		public int compareTo(Doc o) {
			if (this.count == o.count) {
				return this.str.compareTo(o.str);
			}

			return Integer.compare(o.count, this.count);
		}
	}

	static HashSet<String> set;
	static List<Doc> list;

	static String[] solution(String[][] dataSource, String[] tags) {
		set = new HashSet<>();
		list = new ArrayList<>();
		for (int i = 0; i < tags.length; i++) {
			set.add(tags[i]);
		}

		for (int i = 0; i < dataSource.length; i++) {
			int count = 0;
			for (int j = 1; j < dataSource[i].length; j++) {
				if (set.contains(dataSource[i][j])) {
					count++;
				}
			}
			if(count > 0)
				list.add(new Doc(dataSource[i][0], count));
		}

		Collections.sort(list);

		int size = list.size();
		if (size > 10)
			size = 10;
		String[] result = new String[size];

		for (int i = 0; i < size; i++) {
			result[i] = list.get(i).str;
		}

		return result;
	}

	public static void main(String[] args) {
		String[][] dataSource = { { "doc1", "t1", "t2", "t3" }, { "doc2", "t0", "t2", "t3" },
				{ "doc3", "t1", "t6", "t7" }, { "doc4", "t1", "t2", "t4" }, { "doc5", "t6", "t100", "t8" } };
		String[] tags = {"t1", "t2", "t3"};
		
		String[] res = solution(dataSource, tags);
		
		System.out.println(Arrays.toString(res));
	}
}
