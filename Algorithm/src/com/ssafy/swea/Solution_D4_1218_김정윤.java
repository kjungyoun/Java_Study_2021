package com.ssafy.swea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Solution_D4_1218_김정윤 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/swea/d4/input1218.txt"));
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			Stack<String> input = new Stack<String>();
			int n = sc.nextInt();
			boolean isOk = true;
			int answer = 0;
			sc.nextLine();
			String line = sc.nextLine();
			
			for (int i = 0; i < n; i++) {
				String k = line.valueOf(line.charAt(i));
				if(k.equals("{") || k.equals("(") || k.equals("<") || k.equals("[")) { // 좌측괄호        
					input.push(k);
				}else { // 우측괄호
						 if(k.equals("}") && !input.peek().equals("{")) {
							 isOk = false;
								break;
						 }
						 if(k.equals("]") && !input.peek().equals("[")) {
							 isOk = false;
								break;
						 }
						 if(k.equals(")") && !input.peek().equals("(")) {
							 isOk = false;
								break;
						 }
						 if(k.equals(">") && !input.peek().equals("<")) {
							 isOk = false;
								break;
						 }
					else if(input.isEmpty()) {
						isOk = false;
						break;
					}
					 input.pop();
				}
			}
			
			if(isOk && input.isEmpty()) {
				answer=1;
			}
			
			System.out.printf("#%d %d\n",test_case,answer);
		}

	}

}
