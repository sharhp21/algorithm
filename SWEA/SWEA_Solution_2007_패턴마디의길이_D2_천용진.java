	import java.util.Scanner;
	
	public class SWEA_Solution_2007_패턴마디의길이_D2_천용진 {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int TC = sc.nextInt();
			sc.nextLine();
			for (int testCase = 1; testCase <= TC; testCase++) {
				int res = 0;
				String str = sc.nextLine();
				
				for(int i = 1; i <= 10; i++) {
					if(check(str, i) == true) {
						res = i;
						break;
					}
				}
				
				System.out.println("#" + testCase + " " + res);
			}
		}
		
		public static boolean check(String str, int len) {
			for(int i = 0; i <= 10 - len; i+=len) {
				if(!str.substring(i, i + len).equals(str.substring(i + len, i + 2 * len))) {
					return false;
				}
			}
			return true;
		}
	}