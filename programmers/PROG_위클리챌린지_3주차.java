package 프로그래머스;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PROG_위클리챌린지_3주차 {
	public static void main(String[] args) {
		int[][] game_board = {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}};
		int[][] table = {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};
		
		System.out.println(solution(game_board, table));
	}
	
	static List<int[][]> boardShape = new ArrayList<>();
	static List<int[][]> tableShape = new ArrayList<>();
	static int[][] check;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
    
	static class Pos {
		int x, y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
    
    public static int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        check = new int[game_board.length][game_board[0].length];
		for(int i = 0; i < game_board.length; i++) {
			for(int j = 0; j < game_board[i].length; j++) {
				if(game_board[i][j] == 0 && check[i][j] == 0) {
					check[i][j] = 1;
					boardShape.add(makeShape(game_board, i, j, 1));
				}
			}
		}
		
		check = new int[table.length][table[0].length];
		for(int i = 0; i < table.length; i++) {
			for(int j = 0; j < table[i].length; j++) {
				if(table[i][j] == 1 && check[i][j] == 0) {
					check[i][j] = 1;
					tableShape.add(makeShape(table, i, j, -1));
				}
			}
		}
		
		for(int i = 0; i < boardShape.size(); i++) {
			for(int j = 0; j < tableShape.size(); j++){
				int flag = 0;
				int[][] rotateArr = tableShape.get(j);
				for(int k = 0; k < 4; k++) {
					if(equalArray(boardShape.get(i), rotateArr)) {
						flag = 1;
						for(int a = 0; a < rotateArr.length; a++) {
							for(int b = 0; b < rotateArr[a].length; b++) {
								answer += rotateArr[a][b];
							}
						}
						break;
					}
					rotateArr = rotate90(rotateArr);			
				}
				if(flag == 1) {
					tableShape.remove(j);
					break;
				}
			}
		}
		
		return answer;
    }
    
    public static int[][] makeShape(int[][] table, int x, int y, int flag) {
		int[][] tempArr = new int[table.length][table[0].length];
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(x, y));
		
		int xStart = x, xEnd = x;
		int yStart = y, yEnd = y;
		while(!q.isEmpty()) {
			Pos pos = q.poll();
			int px = pos.x;
			int py = pos.y;
			if(xStart > px) xStart = px;
			if(xEnd < px) xEnd = px;
			if(yStart > py) yStart = py;
			if(yEnd < py) yEnd = py;
			tempArr[px][py] = 1;
			for(int i = 0; i < 4; i++) {
				int nx = px + dx[i];
				int ny = py + dy[i];
				if(nx >= 0 && nx < table.length && ny >= 0 && ny < table[0].length) {
					if(flag == 1) {
						if(table[nx][ny] == 0 && check[nx][ny] == 0) {
							check[nx][ny] = 1;
							q.offer(new Pos(nx, ny));
						}
					}
					else {
						if(table[nx][ny] == 1 && check[nx][ny] == 0) {
							check[nx][ny] = 1;
							q.offer(new Pos(nx, ny));
						}
					}
				}
			}
		}
		
		int[][] result = new int[xEnd - xStart + 1][yEnd - yStart + 1];
		
		for(int i = 0; i < result.length; i++) {
			for(int j = 0; j < result[i].length; j++) {
				result[i][j] = tempArr[i + xStart][j + yStart];
			}
		}
		
		return result;
	}
	
    public static boolean equalArray(int[][] arr1, int[][] arr2) {
    	if(arr1.length == arr2.length && arr1[0].length == arr2[0].length ) {
    		for(int i = 0; i < arr1.length; i++) {
    			for(int j = 0; j < arr1[i].length; j++) {
    				if(arr1[i][j] + arr2[i][j] == 1) return false;
    			}
    		}
    		return true;
    	} else return false;
    }
    
	public static int[][] rotate90(int[][] table) {
		int[][] result = new int[table[0].length][table.length];
		for(int i = 0; i < result.length; i++) {
			for(int j = 0; j < result[i].length; j++) {
				result[i][j] = table[table.length - 1 - j][i];
			}
		}
		
		return result;
	}
}
