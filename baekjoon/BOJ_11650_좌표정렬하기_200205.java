import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Point1 implements Comparable<Point1>{
	int x;
	int y;
	
	public Point1(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Point1 p) {
		if(this.x > p.x) {
			return 1;
		} else if(this.x == p.x) {
			if(this.y > p.y) {
				return 1;
			}
		}	
		return -1;
	}
}

public class BOJ_11650_좌표정렬하기_200205 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int n = Integer.parseInt(br.readLine());
		Point1[] arr = new Point1[n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i] = new Point1(x, y);
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i < n; i++) {
			sb.append(arr[i].x + " " + arr[i].y + '\n');
		}
		
		System.out.println(sb);
	}
}
