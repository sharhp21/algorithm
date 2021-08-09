package 프로그래머스;

public class PROG_위클리챌린지_2주차 {
	public static void main(String[] args) {
		int[][] scores = {{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}};
		
		System.out.println(solution(scores));
	}
    public static String solution(int[][] scores) {
        String answer = "";
        
        for(int j = 0; j < scores.length; j++) {
            int sum = 0;
            int cnt = 0;
            int max = -1;
            int min = 101;
            for(int i = 0; i < scores[j].length; i++) {
                if(i != j) {
                    sum += scores[i][j];
                    if(max < scores[i][j]) max = scores[i][j];
                    if(min > scores[i][j]) min = scores[i][j];
                    cnt++;
                }
            }
            if(max >= scores[j][j] && min <= scores[j][j]) {
                sum += scores[j][j];
                cnt++;
            }
            
            double avg = (double)sum / (double)cnt;
            
            if(avg >= 90) answer += "A";
            else if(avg >= 80 && avg < 90) answer += "B";
            else if(avg >= 70 && avg < 80) answer += "C";
            else if(avg >= 50 && avg < 70) answer += "D";
            else answer += "F";
        }
                
        return answer;
    }
}
