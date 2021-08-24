package 프로그래머스;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PROG_위클리챌린지_4주차 {
	static Map<String, Integer> map = new HashMap<String, Integer>();
	static int[] score= new int[5];
	static List<String> list = new ArrayList<String>();
	static int max = 0;
    
	public static void main(String[] args) {
		String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
		String[] languages = {"PYTHON", "C++", "SQL"};
		int[] preference = {7, 5, 5};
		
		System.out.println(solution(table, languages, preference));
	}
	
	public static String solution(String[] table, String[] languages, int[] preference) {
        for(int i = 0; i < languages.length; i++) map.put(languages[i], preference[i]);       
        for(int i = 0; i < 5; i++) {
            String[] arr = table[i].split(" ");          
            for(int j = 1; j < 6; j++) {
                if(map.containsKey(arr[j])) {
                    score[i] += (6 - j) * map.get(arr[j]);
                }
            }  
        }

        for(int i = 0; i < 5; i++) if(max < score[i]) max = score[i];
        for(int i = 0; i < 5; i++) if(max == score[i]) list.add(table[i].substring(0, table[i].indexOf(" "))); 
        Collections.sort(list); 
        
        return list.get(0);
    }
}
