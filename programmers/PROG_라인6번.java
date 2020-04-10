package algo;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PROG_라인6번 {
	static List<String> direc;

	public static void main(String[] args) {
		String[] directory = { "/" };
		String[] command = { "mkdir /a", "mkdir /a/b", "mkdir /a/b/c", "cp /a/b /", "rm /a/b/c" };
		// String[] directory = { "/",
		// "/hello",
		// "/hello/tmp",
		// "/root",
		// "/root/abcd",
		// "/root/abcd/etc",
		// "/root/abcd/hello" };
		// String[] command = { "mkdir /root/tmp",
		// "cp /hello /root/tmp",
		// "rm /hello" };

		String[] res = solution(directory, command);
		System.out.println(Arrays.toString(res));
	}

	static String[] solution(String[] directory, String[] command) {
		direc = new LinkedList<String>();
		for (int i = 0; i < directory.length; i++) {
			direc.add(directory[i]);
		}

		for (int i = 0; i < command.length; i++) {
			String[] comm = command[i].split(" ");

			if (comm[0].equals("mkdir")) {
				mkdir(comm[1]);
			} else if (comm[0].equals("rm")) {
				rm(comm[1]);
			} else {
				cp(comm[1], comm[2]);
			}
		}

		Collections.sort(direc);

		String[] res = direc.toArray(new String[direc.size()]);

		return res;
	}

	public static void mkdir(String dir) {
		direc.add(dir);
	}

	public static void rm(String dir) {
		for (int i = 0; i < direc.size(); i++) {
			String str = direc.get(i);
			if (str.startsWith(dir)) {
				direc.remove(i--);
			}
		}
	}

	public static void cp(String from, String to) {
		int size = direc.size();
		for (int i = 0; i < size; i++) {
			String str = direc.get(i);
			if (str.startsWith(from)) {
				String subStr = str.substring(from.lastIndexOf('/'));
				for (int j = 0; j < size; j++) {
					String str2 = direc.get(j);
					if (to.equals(str2)) {
						if (str2.equals("/"))
							str2 = "";
						direc.add(str2 + subStr);
					}
				}
			}
		}
	}
}
