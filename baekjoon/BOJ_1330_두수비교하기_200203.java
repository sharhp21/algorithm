import java.util.Scanner;

public class BOJ_1330_�μ����ϱ�_200203 {
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
