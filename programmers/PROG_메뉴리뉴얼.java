import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// �ڽ��丮�� �ּ� 2���� �̻� ��ǰ�޴�
// 2�� �̻��� �մ��� �ֹ��� �̷��� �־����
// �ڽ��丮 ������ ���� ���帹�� �ֹ��̷��� �ִ� ������ ������ ���϶�
// orders.length <= 20, orders[i].length <= 10 ���ĺ� �빮�� & �ߺ� X
// course.length <= 10, 2�̻� 10 ������ �ڿ����� �������� ���� & �ߺ� X
// �ڽ� ���� ���ڿ� ���� �������� ����
// ���ڿ������� ��������
public class programmers_�޴������� {
    static Map<String, Integer> map;
    static Map<Integer, Integer> courseCnt;
    static char[] menu;
    static int maxCnt;
        
    public static String[] solution(String[] orders, int[] course) {
        List<String> list = new ArrayList<>();
        
        map = new HashMap<>();
        courseCnt = new HashMap<>();
        
        // �ڽ��丮 �����
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
