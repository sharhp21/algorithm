package algo;

public class PROG_라인2번 {
	static int solution(String answer_sheet, String[] sheets) {
		int max = 0;
		for (int i = 0; i < sheets.length - 1; i++) {
			for (int j = i + 1; j < sheets.length; j++) {
				int length = 0;
				int num = 0;
				int maxLen = 0;
				for(int k = 0; k < answer_sheet.length(); k++) {
					if(sheets[i].charAt(k) == sheets[j].charAt(k) &&
							sheets[i].charAt(k) != answer_sheet.charAt(k)) {
						num++; length++;
					} else {
						if(maxLen < length) maxLen = length;
						length = 0;
					}
				}
				
				if(maxLen < length) maxLen = length;
				
				if(num + maxLen * maxLen > max) {
					max = num + maxLen * maxLen;
				}
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
//		String answer_sheet = "4132315142";
//		String[] sheets = {"3241523133", "4121314445", "3243523133",
//				"4433325251", "2412313253"};
		
//		String answer_sheet = "53241";
//		String[] sheets = {"53241", "42133", "53241", "14354"};
		
		String answer_sheet = "24551";
		String[] sheets = {"24553", "24553", "24553", "24553"};
		
		System.out.println(solution(answer_sheet, sheets));
	}
}
