import java.util.Scanner;

public class Jungol_Main_566_�迭2_�ڰ�����3_õ���� {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n1 = 100;
		int n2 = input.nextInt();
		
		System.out.print(n1 + " ");
		System.out.print(n2 + " ");
		
		while(true) {
			int tmp = n2;
			n2 = n1 - n2;
			n1 = tmp;
			System.out.print(n2 + " ");
			if(n2 < 0) break;
		}
		
	}
}