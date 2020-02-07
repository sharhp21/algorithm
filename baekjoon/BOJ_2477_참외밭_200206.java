package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Line {
	int dir;
	int dist;
	
	public Line(int dir, int dist) {
		this.dir = dir;
		this.dist = dist;
	}
}

public class BOJ_2477_참외밭_200206 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		Line[] arr = new Line[6];
		
		int weight = 0;
		int height = 0;

		for(int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int dir = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			arr[i] = new Line(dir, dist);
			if(arr[i].dir <= 2 && arr[i].dist > weight) {
				weight = arr[i].dist;
			} else if(arr[i].dir >= 3 && arr[i].dist > height) {
				height = arr[i].dist;
			}
		}
		
		int subWeight = 0;
		int subHeight = 0;

		for(int i = 0; i < 6; i++) {
			if(arr[i].dist == weight) {
				subWeight = arr[(i + 3) % 6].dist;
				if(subHeight != 0) break;
			}
				
			if(arr[i].dist == height) {
				subHeight = arr[(i + 3) % 6].dist;
				if(subWeight != 0) break;
			}
		}
		
		System.out.println((weight * height - subWeight * subHeight) * k);
	}
}
