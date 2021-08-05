package 프로그래머스;

public class PROG_합승택시요금 {
	public static void main(String[] args) {
    	int n = 6;
    	int s = 4;
    	int a = 6;
    	int b = 2;
    	int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
    	
		System.out.println(solution(n, s, a, b, fares));
	}
    
	public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        
        // 플로이드 와샬 알고리즘 사용시 값이 int 범위를 넘어갈 수 있기 때문에 Long 자료형 사용
        Long[][] map = new Long[n + 1][n + 1];
        for(int i = 1; i <= n; i++) {
        	for(int j = 1; j <= n; j++) {
        		if(i == j) map[i][j] = Long.valueOf(0);
        		if(i != j) map[i][j] = Long.valueOf(2000000000);
        	}
        }
        
        // input
        for(int i = 0; i < fares.length; i++) {
        	map[fares[i][0]][fares[i][1]] = Long.valueOf(fares[i][2]);
        	map[fares[i][1]][fares[i][0]] = Long.valueOf(fares[i][2]);
        }
        
        // 플로이드 와샬
        for(int k = 1; k <= n; k++) {
	        for(int i = 1; i <= n; i++) {
	        	for(int j = 1; j <= n; j++) {
        			if(map[i][j] > map[i][k] + map[k][j]) {
        				map[i][j] = map[i][k] + map[k][j];
        			}
	        	}
	        }
        }

        Long minFee = Long.valueOf(2000000000);
        Long aFee;
        Long bFee;
        for(int i = 1; i <= n; i++) {
        	// s -> i는 택시를 같이 타고 가는 경로
        	// i -> a & i -> b 는 택시를 따로 타고 가는 경로
        	aFee = map[s][i] + map[i][a];
        	bFee = map[i][b];
        	if(minFee > aFee + bFee) {
        		minFee = aFee + bFee;
        	}
        }
        
        answer = minFee.intValue();
        
        return answer;
    }
}
