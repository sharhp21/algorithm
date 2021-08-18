package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PROG_셔틀버스 {
	public static void main(String[] args) {
		int n = 1, t = 1, m = 5;
		String[] timetable = {"08:00", "08:01", "08:02", "08:03"};
		
		System.out.println(solution(n, t, m, timetable));
	}
	
	public static String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        Arrays.sort(timetable);
        
        List<Integer>[] list = new ArrayList[n];
        for(int i = 0; i < list.length; i++) {
        	list[i] = new ArrayList<Integer>();
        }
        
        int intAns = 540 + (n - 1) * t;
        
        int maxIdx = 0;
        for(int i = 0; i < timetable.length; i++) {
        	int hour = Integer.parseInt(timetable[i].substring(0, 2));
        	int min = Integer.parseInt(timetable[i].substring(3));
        	int index = ((hour * 60 + min) - 540 + t - 1) / t;
        	if(index < 0) index = 0;
        	if(index >= n) break;
        	int flag = 0;
        	while(flag == 0) {
	        	if(list[index].size() < m) {
	        		list[index].add(hour * 60 + min);
	        		maxIdx = index;
	        		flag = 1;
	        	}
	        	index++;
	        	
	        	if(index >= n) {
	        		break;
	        	}
        	}
        }
        
        if(list[maxIdx].size() != 0 && maxIdx == n - 1 && list[maxIdx].size() == m) {
        	intAns = list[maxIdx].get(list[maxIdx].size() - 1) - 1;
        }
        
        int ansHour = intAns / 60;
        int ansMin = intAns % 60;
        if(ansHour >= 10) answer += ansHour + "";
        else answer += "0" + ansHour;
        answer += ":";
        if(ansMin >= 10) answer += ansMin + "";
        else answer += "0" + ansMin;
        
        return answer;
    }
}
