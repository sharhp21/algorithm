import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4949_균형잡힌세상_200205 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str = br.readLine();
			int check = 0;
			if(str.equals(".")) break;
			else {
				Stack<String> st = new Stack<>();
				for(int i = 0; i < str.length(); i++) {
					String tmp = str.substring(i, i + 1);
					if(tmp.equals("(") || tmp.equals("[")) {
						st.push(tmp);
					} else if(tmp.equals(")")) {
						if(st.isEmpty() || !st.peek().equals("(")) {
							check = 1;
							break;
						} else {
							st.pop();
						}
					} else if(tmp.equals("]")) {
						if(st.isEmpty() || !st.peek().equals("[")) {
							check = 1;
							break;
						} else {
							st.pop();
						}
					}
				}
				
				if(check == 0 && st.isEmpty()) {
					System.out.println("yes");
				} else {
					System.out.println("no");
				}
			}
		}
	}
}
