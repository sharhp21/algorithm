import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 코스요리는 최소 2가지 이상 단품메뉴
// 2명 이상의 손님이 주문한 이력이 있어야함
// 코스요리 개수에 따라 가장많은 주문이력이 있는 음식의 조합을 구하라
// orders.length <= 20, orders[i].length <= 10 알파벳 대문자 & 중복 X
// course.length <= 10, 2이상 10 이하의 자연수가 오름차순 정렬 & 중복 X
// 코스 구성 문자열 형식 오름차순 정렬
// 문자열끼리도 오름차순
public class programmers_메뉴리뉴얼 {
    static Map<String, Integer> map;
    static Map<Integer, Integer> courseCnt;
    static char[] menu;
    static int maxCnt;
        
    public static String[] solution(String[] orders, int[] course) {
        List<String> list = new ArrayList<>();
        
        map = new HashMap<>();
        courseCnt = new HashMap<>();
        
        // 코스요리 만들기
        for(int i = 0; i < course.length; i++) {
            int foodCnt = course[i];
            maxCnt = 0;
            for(int j = 0; j < orders.length; j++) {
                char[] charArr = orders[j].toCharArray();
                Arrays.sort(charArr);
                menu = new char[foodCnt];
                selectFood(charArr, foodCnt, 0, 0);
            }
            courseCnt.put(foodCnt, maxCnt);
        }
        
        map.forEach((key, value) -> {
            if(courseCnt.get(key.length()) == value && value > 1) {
                list.add(key);
            }
        });
        
        String[] answer = list.toArray(new String[list.size()]);
        Arrays.sort(answer);
        
        return answer;
    }
    
    public static void selectFood(char[] charArr, int cnt, int idx, int select) {
        if(select == cnt) {
            String menuStr = String.valueOf(menu);
            map.put(menuStr, map.getOrDefault(menuStr, 0) + 1);
            if(maxCnt <  map.get(menuStr)) maxCnt = map.get(menuStr);
            
            return;
        }
        
        for(int i = idx; i < charArr.length; i++) {
            menu[select] = charArr[i];
            selectFood(charArr, cnt, i + 1, select + 1);
        }
    }
}
