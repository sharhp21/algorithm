import java.util.Arrays;
import java.util.Scanner;

public class SWEA_Solution_2063_�߰���ã��_D1_õ���� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arrays = new int[n];
		
		for(int i = 0; i < n; i++) {
			arrays[i] = sc.nextInt();
		}
		
		Arrays.sort(arrays);
		
		System.out.println(arrays[n / 2]);
		
		sc.close();
	}
}
