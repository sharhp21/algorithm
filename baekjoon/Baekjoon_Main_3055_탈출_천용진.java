import java.util.Scanner;

/*
 * R행 C열 <= 50
 * 지도 입력으로
 * S는 고슴도치
 * D는 비버의 굴
 * X는 돌
 * *는 물이 차있는 지역
 * .는 비어있는 칸
 * 
 * 
 * S는 한칸씩 이동
 * *는 인접해 있는 칸으로 이동
 * S가 D로 들어가기 위한 최소 시간
 * 갈수 없다면 KAKTUS 출력
 */
public class Baekjoon_Main_3055_탈출_천용진 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int row = input.nextInt();
		int col = input.nextInt();
		int[][] map = new int[row][col];
		
		// map 입력
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = input.nextInt();
			}
		}
		
		
	}
}
