import java.util.Scanner;

public class SWEA_Solution_1289_�����Ǹ޸𸮺����ϱ�_D3_õ���� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int testCase = 1; testCase <= TC; testCase++) {
			String s = sc.next();
			int num = 0;
			int ans = 0;
			for(int i = 0; i < s.length(); i++) {
				if(Integer.parseInt(s.substring(i, i + 1)) != num) {
					if(num == 0) num = 1;
					else num = 0;
					ans += 1;
				}
			}
			System.out.println("#" + testCase + " " + ans);
		}
	} // end of for testCase
} // end of main