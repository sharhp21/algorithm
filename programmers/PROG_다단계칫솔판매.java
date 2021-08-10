package 프로그래머스;

import java.util.HashMap;
import java.util.Map;

public class PROG_다단계칫솔판매 {
	static Map<String, String> relation;
    static Map<String, Integer> idx;
    
    public static void main(String[] args) {
		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller = {"young", "john", "tod", "emily", "mary"};
		int[] amount = {12, 4, 2, 5, 10};
		
		int[] answer = solution(enroll, referral, seller, amount);
		
		for(int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
		System.out.println();
	}
    
    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        relation = new HashMap<String, String>();
        idx = new HashMap<String, Integer>();
        
        for(int i = 0; i < enroll.length; i++) {
            relation.put(enroll[i], referral[i]);
            idx.put(enroll[i], i);
        }

        for(int i = 0; i < seller.length; i++) {
            int myMoney = 0;
            String name = seller[i];
            int money = amount[i] * 100;
            while(relation.containsKey(name)) {
                myMoney = (int)Math.ceil(money * 0.9);
                money -= myMoney;
                answer[idx.get(name)] += myMoney;               
                if(money == 0) break;
                name = relation.get(name);
            }
        }
        
        return answer;
    }
}
