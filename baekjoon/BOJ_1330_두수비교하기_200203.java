import java.util.Scanner;

public class BOJ_1330_두수비교하기_200203 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		
		if(a > b) { 
			System.out.println(">");
		} else if(a < b) {
			System.out.println("<");
		} else {
			System.out.println("==");
		}
	}
}
