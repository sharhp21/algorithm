import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_Main_2455_지능형기차_천용진 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] out = new int[4];
		int[] in = new int[4];
		int[] people = new int[4];
		
		for(int i = 1; i < 4; i++) {
			out[i] = input.nextInt();
			in[i] = input.nextInt();
			people[i] += people[i - 1] + in[i] - out[i];
		}
		people[0] = in[0] - out[0];
		
		Arrays.sort(people);
		
		System.out.println(people[3]);
	}
}
