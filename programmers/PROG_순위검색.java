package 프로그래머스;

public class PROG_순위검색 {
	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		
		int[] answer = solution(info, query);
		
		for(int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}
	
	static int[][][][][] map;
	static int[] answer;
    
    public static int[] solution(String[] info, String[] query) {
        answer = new int[query.length];
        
        // [언어][직군][경력][소울푸드][점수]
        map = new int[3][2][2][2][100001];
        
        // 지원자 정보 입력
        for(int i = 0; i < info.length; i++) {
            String[] tempArr = info[i].split(" ");
            inputMap(tempArr);
        }
        
        // 지원자 검색
        for(int i = 0; i < query.length; i++) {
            String[] tempArr = query[i].split(" ");
            int[] searchArr = new int[5];
            
            if("cpp".equals(tempArr[0])) searchArr[0] = 0;
            else if("java".equals(tempArr[0])) searchArr[0] = 1;
            else if("python".equals(tempArr[0])) searchArr[0] = 2;
            else searchArr[0] = -1;
            
            if("backend".equals(tempArr[2])) searchArr[1] = 0;
            else if("frontend".equals(tempArr[2])) searchArr[1] = 1;
            else searchArr[1] = -1;
            
            if("junior".equals(tempArr[4])) searchArr[2] = 0;
            else if("senior".equals(tempArr[4])) searchArr[2] = 1;
            else searchArr[2] = -1;
            
            if("chicken".equals(tempArr[6])) searchArr[3] = 0;
            else if("pizza".equals(tempArr[6])) searchArr[3] = 1;
            else searchArr[3] = -1;

            searchArr[4] = Integer.parseInt(tempArr[7]);
            
            answer[i] = search(searchArr, new int[4], 0);
        }
        
        return answer;
    }
    
    // query에 따라 동적으로 변하는 재귀 검색 함수
    public static int search(int[] searchArr, int[] arr, int idx) {
        if(idx == 4) {
            return map[arr[0]][arr[1]][arr[2]][arr[3]][searchArr[4]];
        }
        
        int sum = 0;
        if(searchArr[idx] == -1) {
            arr[idx] = 0;
            sum += search(searchArr, arr, idx + 1);
            arr[idx] = 1;
            sum += search(searchArr, arr, idx + 1);
            if(idx == 0) {
                arr[idx] = 2;
                sum += search(searchArr, arr, idx + 1);
            }
        } else {
            arr[idx] = searchArr[idx];
            sum += search(searchArr, arr, idx + 1);
        }
        
        return sum;
    }
    
    public static void inputMap(String[] tempArr) {
        int a, b, c, d;
        if("cpp".equals(tempArr[0])) a = 0;
        else if("java".equals(tempArr[0])) a = 1;
        else a = 2;
        if("backend".equals(tempArr[1])) b = 0;
        else b = 1;
        if("junior".equals(tempArr[2])) c = 0;
        else c = 1;
        if("chicken".equals(tempArr[3])) d = 0;
        else d = 1;
        
        // 100점이상인 지원자는 0점 부터 100점까지에서 검색될 수 있다.
        int score = Integer.parseInt(tempArr[4]);
        for(int i = 0; i <= score; i++) {
            map[a][b][c][d][i]++;
        }
    }
}
