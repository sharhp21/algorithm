package algo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeMap;

public class PROG_라인4번 {
	static TreeMap<String, Integer> map;
	static HashSet<String> set;

	static String[][] solution(String[][] snapshots, String[][] transactions) {
		map = new TreeMap<>();
		set = new HashSet<>();
		for (int i = 0; i < snapshots.length; i++) {
			map.put(snapshots[i][0], Integer.parseInt(snapshots[i][1]));
		}

		for (int i = 0; i < transactions.length; i++) {
			if (set.contains(transactions[i][0]))
				continue;
			if (transactions[i][1].equals("SAVE")) {
				if (!map.containsKey(transactions[i][2])) {
					map.put(transactions[i][2], Integer.parseInt(transactions[i][3]));
				} else {
					map.put(transactions[i][2], map.get(transactions[i][2]) + Integer.parseInt(transactions[i][3]));
				}
			} else {
				map.put(transactions[i][2], map.get(transactions[i][2]) - Integer.parseInt(transactions[i][3]));
			}
			set.add(transactions[i][0]);
		}

		String[][] result = new String[map.size()][2];
		int index = 0;
		for (String key : map.keySet()) {
			result[index][0] = key;
			result[index][1] = map.get(key).toString();
			index++;
		}

		return result;
	}

	public static void main(String[] args) {
		String[][] snapshots = { {"ACCOUNT10", "100"}, { "ACCOUNT2", "150" }, { "ACCOUNT1", "100" } };
		String[][] transactions = { { "1", "SAVE", "ACCOUNT2", "100" }, 
				{ "2", "WITHDRAW", "ACCOUNT1", "50" },
				{ "1", "SAVE", "ACCOUNT2", "100" }, 
				{ "4", "SAVE", "ACCOUNT3", "500" },
				{ "3", "WITHDRAW", "ACCOUNT2", "30" } };
		
		String[][] ans = solution(snapshots, transactions);
		
		for(int i = 0; i < ans.length; i++) {
			System.out.println(Arrays.toString(ans[i]));
		}
	}
}
