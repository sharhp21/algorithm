import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_SWEA_1225_암호생성기_천용진 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		for(int testcase = 1; testcase <= 10; testcase++) {
			Queue<Integer> q = new LinkedList<Integer>();
			input.nextInt();
			for(int i = 0; i < 8; i++) {
				q.add(input.nextInt());
			}
			
			int count = 0;
			while(q.peek() > 0) {
				count++;
				if(count % 5 == 0) {
					if(q.peek() - 5 <= 0) {
						q.poll();
						q.add(0);
						break;
					} else {
						q.add(q.poll() - 5);
					}
					
				} else {
					if(q.peek() - count % 5 <= 0) {
						q.poll();
						q.add(0);
						break;
					} else {
						q.add(q.poll() - count % 5);
					}
				}
			}
			
			System.out.print("#" + testcase + " ");
			while(!q.isEmpty()) {
				System.out.print(q.poll() + " ");
			}
			System.out.println();
		}
	}
}
