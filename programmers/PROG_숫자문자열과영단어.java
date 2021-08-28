package 프로그래머스;

public class PROG_숫자문자열과영단어 {
	public static void main(String[] args) {
		String s = "2three45sixseven";
		System.out.println(solution(s));
	}
	
	public static int solution(String s) {
        int answer = 0;
        String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i = 0; i < 10; i++) {
            s = s.replaceAll(num[i], String.valueOf(i));
        }
        
        answer = Integer.parseInt(s);
        
        return answer;
    }
}
