import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1436_¿µÈ­°¨µ¶¼ò_200203 {
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		int index = 0;
		int count = 0;
		while(true) {
			if(index == n) break;
			
			count++;
			if(Integer.toString(count).indexOf("666") == -1) {
				 continue;
			} else {
				arr[index++] = count;
			}
		}
		
		System.out.println(arr[n - 1]);
	}
}
