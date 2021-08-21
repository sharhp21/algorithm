package 프로그래머스;

public class PROG_단체사진찍기 {
	static int[] arr = {0, 2, 5, 9, 12, 13, 17, 19};
	static int[][] line = new int[40320][8];
    
	public static void main(String[] args) {
		int n = 2;
		String[] data = {"N~F=0", "R~T>2"};
		
		System.out.println(solution(n, data));
	}
	
    public static int solution(int n, String[] data) {
        int answer = 0;

        int l = 0;
        do {
            for(int i = 0; i < 8; i++) {
                line[l][i] = arr[i];
            }
            l++;
        } while(nextPermutation() == 1);
 
        for(int idx = 0; idx < 40320; idx++) {
            int cnt = 0;
            for(int i = 0; i < n; i++) {
                String str = data[i];
                int a = str.charAt(0) - 65;
                int b = str.charAt(2) - 65;
                String compare = str.substring(3, 4);
                int num = Integer.parseInt(str.substring(4));

                int ai = 0, bi = 0;
                for(int k = 0; k < 8; k++) {
                    if(line[idx][k] == a) ai = k;
                    if(line[idx][k] == b) bi = k;
                }
                int between = Math.abs(ai - bi);
                
                if(compare.equals("=")) {
                    if(between == num + 1) cnt++;
                    else break;
                } else if(compare.equals(">")) {
                    if(between > num + 1) cnt++;
                    else break;
                } else {
                    if(between < num + 1) cnt++;
                    else break;
                }
            }
            if(cnt == n) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public static int nextPermutation() {
        int i = 7;
        while(i > 0) {
            if(arr[i - 1] < arr[i]) {
                break;
            }
            i--;
        }
        
        if(i == 0) return -1;
        int j = 7;
        while(arr[i - 1] > arr[j] && i - 1 < j) {
            j--;
        }
        
        int tmp = arr[i - 1];
		arr[i - 1] = arr[j];
		arr[j] = tmp;
		
		int k = 7;
		while(i < k) {
			tmp = arr[i];
			arr[i] = arr[k];
			arr[k] = tmp;
			i++;
			k--;
		}
		
		return 1;
    }
}
