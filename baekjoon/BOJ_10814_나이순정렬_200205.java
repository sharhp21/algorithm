import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Member implements Comparable<Member>{
	String name;
	int age;
	int order;
	
	public Member(String name, int age, int order) {
		this.name = name;
		this.age = age;
		this.order = order;
	}
	@Override
	public int compareTo(Member o) {
		// TODO Auto-generated method stub
		if(this.age > o.age) {
			return 1;
		} else if(this.age == o.age) {
			if(this.order > o.order) {
				return 1;
			}
		}
		return -1;
	}
}
public class BOJ_10814_나이순정렬_200205 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		Member[] arr = new Member[n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			arr[i] = new Member(name, age, i);
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i < n; i++) {
			sb.append(arr[i].age + " " + arr[i].name + '\n');
		}
		
		System.out.println(sb);
	}
}
