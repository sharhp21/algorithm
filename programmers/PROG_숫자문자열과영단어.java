package ���α׷��ӽ�;

public class PROG_���ڹ��ڿ������ܾ� {
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
