package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_3954_Brainfuck인터프리터_200207 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= TC; ++testcase) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Stack<Integer> stack = new Stack<>();
			int arrSize = Integer.parseInt(st.nextToken());
			int codeSize = Integer.parseInt(st.nextToken());
			int inputSize = Integer.parseInt(st.nextToken());
			int[] jump = new int[codeSize];

			int[] arr = new int[arrSize];
			String code = br.readLine();
			String input = br.readLine();

			int check = 0;
			char s = ' ';
			for (int i = 0; i < codeSize; i++) {
				s = code.charAt(i);
				if (s == '[') {
					stack.push(i);
				} else if (s == ']') {
					int tmp = stack.peek();
					jump[tmp] = i;
					jump[i] = tmp;
					stack.pop();
				}
			}

			int pointer = 0;
			int pointerInput = 0;
			int loop = 0;
			char[] inputArr = new char[inputSize];
			for (int i = 0; i < inputSize; i++) {
				inputArr[i] = input.charAt(i);
			}
			char[] c = new char[codeSize];
			for (int i = 0; i < codeSize; i++) {
				c[i] = code.charAt(i);
			}

			int time = 0;
			int code_index = 0;
			int flag = 0;
			while (time < 50000000) {
				if (c[code_index] == '-') {
					arr[pointer]--;
					if (arr[pointer] < 0)
						arr[pointer] = 255;
				} else if (c[code_index] == '+') {
					arr[pointer]++;
					if (arr[pointer] > 255)
						arr[pointer] = 0;
				} else if (c[code_index] == '<') {
					pointer--;
					if (pointer < 0)
						pointer = arrSize - 1;
				} else if (c[code_index] == '>') {
					pointer++;
					if (pointer > arrSize - 1)
						pointer = 0;
				} else if (c[code_index] == '[') {
					if (arr[pointer] == 0) {
						code_index = jump[code_index];
						code_index--;
					}
				} else if (c[code_index] == ']') {
					if (arr[pointer] != 0) {
						if(loop < code_index)
							loop = code_index;
						code_index = jump[code_index];
						code_index--;
					}
				} else if (c[code_index] == '.') {

				} else if (c[code_index] == ',') {
					if (pointerInput == inputSize) {
						arr[pointer] = 255;
					} else {
						arr[pointer] = inputArr[pointerInput];
						pointerInput++;
					}
				}

				if (code_index == codeSize - 1) {
					flag = 1;
					break;
				}
				code_index++;
				time++;
			}

			if (flag == 1) {
				System.out.println("Terminates");
			} else {
				System.out.println("Loops " + jump[loop] + " " + loop);
			}
		}
	}
}
