import java.util.Scanner;

public class Jungol_Main_539_반복제어문1_자가진단4_천용진 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int count = 0;
		int sum = 0;
		double avg = 0;
		
		while(true) {
			int num = input.nextInt();
		
			count++;
			sum += num;
			
			if(num >= 100) break;
		}
		
		avg = (double)sum / (double)count;
		
		System.out.println(sum);
		System.out.printf("%.1f", avg);
	}
}
