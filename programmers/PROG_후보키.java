package 프로그래머스;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PROG_후보키 {
	static Set<String> set;
	static List<int[]> ansArr;
	static int[] check;
	static int answer = 0;
	
	public static void main(String[] args) {
		String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
		
		System.out.println(solution(relation));
	}
	
    public static int solution(String[][] relation) {   
        ansArr = new ArrayList<int[]>();
        for(int i = 1; i <= relation[0].length; i++) {
            check = new int[i];         
            comb(i, 0, -1, relation);
        }
        
        return answer;
    }
    
    public static void comb(int cnt, int pick, int idx, String[][] relation) {
        if(cnt == pick) {
            if(checkMinimality()) {
                if(checkUniqueness(relation)) {              
                    answer++;
                    int[] tmpCheck = check.clone();
                    ansArr.add(tmpCheck);
                }
            }
            return;
        }
        
        for(int i = idx + 1; i < relation[0].length; i++) {
            check[pick] = i;
            comb(cnt, pick + 1, i, relation);
        }
        
        return;
    }

    public static boolean checkMinimality() {
        if(ansArr.size() == 0 || check.length == 1) return true;
        for(int i = 0; i < ansArr.size(); i++) {
            int[] arr = ansArr.get(i);
            int count = 0;
            for(int j = 0; j < arr.length; j++) {
                for(int k = 0; k < check.length; k++) {
                    if(arr[j] == check[k]) {
                        count++;
                    }
                }
            }
            if(arr.length == count) return false;
        }
        
        return true;
    }
    
    public static boolean checkUniqueness(String[][] relation) {
        set = new HashSet<String>();
         
        for(int i = 0; i < relation.length; i++) {
            String str = "";
            for(int j = 0; j < check.length; j++) {
                str += relation[i][check[j]] + ",";
            }
            if(set.contains(str)) {
                return false;
            }
            set.add(str);
        }
        
        return true;
    }
}
