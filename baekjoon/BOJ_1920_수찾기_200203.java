import java.util.HashSet;
import java.util.Scanner;

public class BOJ_1920_¼öÃ£±â_200203 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		HashSet<Integer> set = new HashSet<>();
		for(int i = 0; i < n; i++) {
			set.add(input.nextInt());
		}
		
		int m = input.nextInt();
		int[] check = new int[m];
		for(int i = 0; i < m; i++) {
			check[i] = input.nextInt();
		}
		
		for(int i = 0; i < m; i++) {
			if(set.contains(check[i])) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}
}

