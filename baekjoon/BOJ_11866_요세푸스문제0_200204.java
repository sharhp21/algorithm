import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11866_요세푸스문제0_200204 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken()) - 1;
		List<Integer> list = new LinkedList<Integer>();
		
		for(int i = 1; i <= n; i++) {
			list.add(i);
		}
		
		System.out.print("<");
		int index = 0;
		while(true) {
			if(list.size() == 1) break;
			index += k;
			index = index % list.size();
			System.out.print(list.remove(index) + ", ");
		}
		System.out.println(list.get(0) + ">");
	}
}