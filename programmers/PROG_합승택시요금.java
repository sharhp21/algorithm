package ���α׷��ӽ�;

public class PROG_�ս��ýÿ�� {
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
        
        // �÷��̵� �ͼ� �˰��� ���� ���� int ������ �Ѿ �� �ֱ� ������ Long �ڷ��� ���
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
        
        // �÷��̵� �ͼ�
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
        	// s -> i�� �ýø� ���� Ÿ�� ���� ���
        	// i -> a & i -> b �� �ýø� ���� Ÿ�� ���� ���
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
