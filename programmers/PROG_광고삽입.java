package 프로그래머스;

public class PROG_광고삽입 {
	public static void main(String[] args) {
		String play_time = "02:03:55";
		String adv_time = "00:14:15";
		String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
		
		System.out.println(solution(play_time, adv_time, logs));
	}
	
    public static String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int playTime = timeToSec(play_time, 0, 8);
        // 초 단위로 시간을 담을 선형 배열
        long[] time = new long[playTime + 2];

        // 시간을 초로 변형 후 시작점에 +1, 끝점에 -1
        for(int i = 0; i < logs.length; i++) {
            int startTime = timeToSec(logs[i], 0, 8);
            int endTime = timeToSec(logs[i], 9, 17);          
            time[startTime + 1]++;
            time[endTime + 1]--;   
        }
        
        // 초 단위로 시청하고 있는 인원 계산
        for(int i = 0; i < time.length - 1; i++) {
            time[i + 1] += time[i];
        }

        // 구간 합 투 포인터로 계산
        long sum = 0;
        int startAdv = 0;
        int endAdv = timeToSec(adv_time, 0, 8);
        for(int i = 0; i <= endAdv; i++) {
            sum += time[i];
        }

        long max = sum;
        int resultTime = 0;
        while(endAdv < playTime) {
            sum -= time[++startAdv];
            sum += time[++endAdv];
            if(max < sum) {
                resultTime = startAdv;
                max = sum;
            }     
        }
        
        String hour = resultTime / 3600 + "";
        String min = (resultTime % 3600) / 60 + "";
        String sec = (resultTime % 3600) % 60 + "";
        if(hour.length() == 1) hour = "0" + hour;
        if(min.length() == 1) min = "0" + min;
        if(sec.length() == 1) sec = "0" + sec;
        answer = hour + ":" + min + ":" + sec;
        
        return answer;
    }
    
    public static int timeToSec(String str, int start, int end) {
        String[] arr = str.substring(start, end).split(":");
        return Integer.parseInt(arr[0]) * 3600 + Integer.parseInt(arr[1]) * 60 + Integer.parseInt(arr[2]);
    }
}
