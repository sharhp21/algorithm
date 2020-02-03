import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1181_단어정렬_200203 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.nextLine());
		String[][] arr = new String[51][n];
		for(int i = 0; i < 51; i++)
			Arrays.fill(arr[i], "");
		for(int i = 0; i < n; i++) {
			String str = input.nextLine();
			arr[str.length()][i] = str;
		}
		for(int i = 1; i < 51; i++) {
			Arrays.sort(arr[i]);
		}
		
		String tmp = "";
		for(int i = 1; i < 51; i++) {
			for(int j = 0; j < n; j++) {
				if(arr[i][j].equals("")) {
					continue;
				} else {
					if(!arr[i][j].equals(tmp))
						System.out.println(arr[i][j]);
					tmp = arr[i][j];
				}
			}
		}
	}
}
