public class programmers_신규아이디추천 {
    public String solution(String new_id) {
        String answer = "";
        int deleteCount = 0;
        
        char[] idArr = new char[new_id.length()];
        for(int i = 0; i < idArr.length; i++) {
            idArr[i] = new_id.charAt(i);
        }
        
        System.out.println('0' == 48);
        
        // 대문자를 대응되는 소문자로 치환합니다.
        for(int i = 0; i < idArr.length; i++) {
            char c = idArr[i];
            if(c >= 65 && c <= 90) {
                c += 32;
                idArr[i] = c;
            }      
        }
        
        // 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        for(int i = 0; i < idArr.length; i++) {
            char c = idArr[i];
            if((c >= 97 && c <= 122) || (c >= 48 && c <= 57) || c == '-' || c == '_' || c == '.') {
                
            } else {
                idArr[i] = ' ';
                deleteCount++;
            } 
        }
        
        // 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
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
        
        // 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
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
        
        // 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(deleteCount == idArr.length) {
            idArr[0] = 'a';
            deleteCount--;
        }
        
        answer = String.valueOf(idArr).replaceAll(" ", "");
        
        // 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        if(answer.length() >= 16) {
            answer = answer.substring(0, 15);
        }
        
        // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        for(int i = answer.length() - 1; i >= 0; i--) {
            if(answer.charAt(i) != '.') {
                answer = answer.substring(0, i + 1);
                break;
            }
        }
        
        // 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if(answer.length() <= 2) {
            char end = answer.charAt(answer.length() - 1);
            while(answer.length() < 3) {
                answer += end + "";
            }
        }

        return answer;
    }
}