public class programmers_�űԾ��̵���õ {
    public String solution(String new_id) {
        String answer = "";
        int deleteCount = 0;
        
        char[] idArr = new char[new_id.length()];
        for(int i = 0; i < idArr.length; i++) {
            idArr[i] = new_id.charAt(i);
        }
        
        System.out.println('0' == 48);
        
        // �빮�ڸ� �����Ǵ� �ҹ��ڷ� ġȯ�մϴ�.
        for(int i = 0; i < idArr.length; i++) {
            char c = idArr[i];
            if(c >= 65 && c <= 90) {
                c += 32;
                idArr[i] = c;
            }      
        }
        
        // ���ĺ� �ҹ���, ����, ����(-), ����(_), ��ħǥ(.)�� ������ ��� ���ڸ� �����մϴ�.
        for(int i = 0; i < idArr.length; i++) {
            char c = idArr[i];
            if((c >= 97 && c <= 122) || (c >= 48 && c <= 57) || c == '-' || c == '_' || c == '.') {
                
            } else {
                idArr[i] = ' ';
                deleteCount++;
            } 
        }
        
        // ��ħǥ(.)�� 2�� �̻� ���ӵ� �κ��� �ϳ��� ��ħǥ(.)�� ġȯ�մϴ�.
        for(int i = 0; i < idArr.length - 1; i++) {
            char c = idArr[i];
            if(c == '.') {
                for(int j = i + 1; j < idArr.length; j++) {
                    if(idArr[j] == ' ') continue;
                    if(idArr[j] == '.') {
                        idArr[j] = ' ';
                        deleteCount++;
                    } else break;
                }
            }
        }
        
        // ��ħǥ(.)�� ó���̳� ���� ��ġ�Ѵٸ� �����մϴ�.
        for(int i = 0; i < idArr.length; i++) {
            if(idArr[i] == ' ') {
                continue;
            } else if(idArr[i] == '.') {
                idArr[i] = ' ';
                deleteCount++;
            } else break;
        }
        for(int i = idArr.length - 1; i >= 0; i--) {
            if(idArr[i] == ' ') {
                continue;
            } else if(idArr[i] == '.') {
                idArr[i] = ' ';
                deleteCount++;
            } else break;
        }
        
        // �� ���ڿ��̶��, new_id�� "a"�� �����մϴ�.
        if(deleteCount == idArr.length) {
            idArr[0] = 'a';
            deleteCount--;
        }
        
        answer = String.valueOf(idArr).replaceAll(" ", "");
        
        // ���̰� 16�� �̻��̸�, new_id�� ù 15���� ���ڸ� ������ ������ ���ڵ��� ��� �����մϴ�.
        if(answer.length() >= 16) {
            answer = answer.substring(0, 15);
        }
        
        // ���� ���� �� ��ħǥ(.)�� new_id�� ���� ��ġ�Ѵٸ� ���� ��ġ�� ��ħǥ(.) ���ڸ� �����մϴ�.
        for(int i = answer.length() - 1; i >= 0; i--) {
            if(answer.charAt(i) != '.') {
                answer = answer.substring(0, i + 1);
                break;
            }
        }
        
        // ���̰� 2�� ���϶��, new_id�� ������ ���ڸ� new_id�� ���̰� 3�� �� ������ �ݺ��ؼ� ���� ���Դϴ�.
        if(answer.length() <= 2) {
            char end = answer.charAt(answer.length() - 1);
            while(answer.length() < 3) {
                answer += end + "";
            }
        }

        return answer;
    }
}