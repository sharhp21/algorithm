import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Jungol_Main_563_배열1_자가진단9_천용진 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] arr = new int[10];
		
		for(int i = 0; i < 10; i++) {
			arr[i] = input.nextInt();
		}
		
		Arrays.sort(arr);
		
		for(int i = 9; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		Collections.sort(list, Comparator.reverseOrder());
		
		for(int element : list) {
			System.out.print(element + " ");
		}
	}
}
