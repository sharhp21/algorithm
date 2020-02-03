import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10989_수정렬하기3_200203 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[10001];
		for(int i = 0; i < n; i++) {
			arr[Integer.parseInt(br.readLine())]++;
		}
		
		for(int i = 1; i < 10001; i++) {
			for(int j = 0; j < arr[i]; j++) {
				bf.write(i + "\n");
			}
		}
		
		bf.flush();
		bf.close();
	}
}
