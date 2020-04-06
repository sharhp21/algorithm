package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 라인3번 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      int n = Integer.parseInt(br.readLine());
	      String str = br.readLine();
	      List<Integer> list = new ArrayList<>(); // 0 index 저장
	      int[] dp = new int[str.length()];
	      
	      for(int i = 0; i < str.length(); i++) {
	    	  if(str.charAt(i) == '0') list.add(i);
	      }
	      
	      int cnt = 0;
	      int index = 0;
	      for(int i = 0; i < str.length(); i++) {
	    	  if(str.charAt(i) == '0') {
	    		  if(cnt < n) {
	    			  cnt++;
	    			  index++;
	    			  if(i == 0) dp[i] = 1;
	    			  else dp[i] = dp[i - 1] + 1;
	    		  } else {
	    			  dp[i] = i - list.get(index - n);
	    			  index++;
	    		  }
	    	  } else {
	    		  if(i == 0) dp[i] = 1;
	    		  else dp[i] = dp[i - 1] + 1;
	    	  }
	      }
	      
	      int max = 0;
	      for(int i = 0; i < str.length(); i++) {
	    	  if(max < dp[i]) max = dp[i];
	      }
	      System.out.println(max);
	}
}
