import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BOJ_1874_스택수열_200205 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = n;
		Stack<Integer> st = new Stack<>();
		List<String> list = new LinkedList<>();
		
		int index = 1;
		st.push(1);
		list.add("+");
		while(true) { 		
			if(n <= 0) {
				break;
			}
			n--;
			int num = Integer.parseInt(br.readLine());
			
			if(index < num) {
				while(index < num) { 
					st.push(++index);
					list.add("+");
				}
				st.pop();
				list.add("-");
			} else if(index == num) {
				st.pop();
				list.add("-");
			} else {
				if(st.isEmpty()) {
					System.out.println("NO");
					return;
				}
				while(!st.isEmpty() && st.peek() >= num) {
					st.pop();
					list.add("-");
				}
			}
		}
		
		for(String str : list) {
			System.out.println(str);
		}
	}
}
