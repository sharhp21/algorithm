package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Person {
	int weight;
	int height;
	int rank;
	
	public Person(int weight, int height, int rank) {
		this.weight = weight;
		this.height = height;
	}
}

public class BOJ_7568_덩치_200206 {
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Person[] arr = new Person[n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
		}
		
		for(int i = 0; i < n; i++) {
			int count = 1;
			for(int j = 0; j < n; j++) {
				if(i != j) {
					if(arr[i].weight < arr[j].weight && arr[i].height < arr[j].height) {
						count++;
					}
				}
			}
			arr[i].rank = count;
		}
		
		for(int i = 0; i < n; i++) {
			System.out.print(arr[i].rank + " ");
		}
	}
}
