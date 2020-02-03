import java.util.Scanner;

public class BOJ_8958_OXÄûÁî_200203 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int TC = Integer.parseInt(input.nextLine());
		for(int testcase = 1; testcase <= TC; testcase++) {
			String str = input.nextLine();
			int count = 0;
			int answer = 0;
			for(int i = 0; i < str.length(); i++) {
				if(str.substring(i , i + 1).equals("O")) {
					count++;
					answer += count;
				} else {
					count = 0;
				}
			}
			System.out.println(answer);
		}
	}
}
