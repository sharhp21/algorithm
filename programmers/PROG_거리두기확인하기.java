package 프로그래머스;

public class PROG_거리두기확인하기 {
	public static void main(String[] args) {
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		int[] solution = solution(places);
		
		for(int i = 0; i < solution.length; i++) {
			System.out.print(solution[i] + " ");
		}
	}
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
    public static int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        String[][][] arr = new String[5][5][5];
        
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                arr[i][j] = places[i][j].split("");
            }
        }

        for(int i = 0; i < 5; i++) {
            answer[i] = find(arr[i]);
        }
        
        return answer;
    }
    
    public static int find(String[][] arr) {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(arr[i][j].equals("P")) {
                    for(int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
                            if(arr[nx][ny].equals("P")) return 0;
                            else if(arr[nx][ny].equals("O")) {
                                for(int m = 0; m < 4; m++) {
                                    int nnx = nx + dx[m];
                                    int nny = ny + dy[m];
                                    if(nnx >= 0 && nny >= 0 && nnx < 5 && nny < 5) {
                                        if(i == nnx && j == nny) {
                                            continue;
                                        } else {
                                            if(arr[nnx][nny].equals("P")) return 0;   
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return 1;
    }
}
