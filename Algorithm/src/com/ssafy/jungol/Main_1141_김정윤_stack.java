package com.ssafy.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 시간 초과 문제를 해결하기 위해 스택으로 구현
 */
public class Main_1141_김정윤_stack {
	static long sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		Stack<Long> stack = new Stack<Long>();
		
		
		for (int i = 0; i <n; i++) {
			long tall = Integer.parseInt(in.readLine());
			if(i==0) {
			stack.push(tall);
			}
			else {
				if(tall<stack.peek()) { // 스택이 더 클 때
					sum += stack.size();
					stack.push(tall);
				}else { // 입력이 더 클 때 
					int size = stack.size();
					for (int j = 0; j <= size; j++) {
						if(!stack.isEmpty() && tall>= stack.peek()) {
							stack.pop();
						}else if(stack.isEmpty()) {
							stack.push(tall);
							break;
						}else if(!stack.isEmpty() && tall < stack.peek()) {
							sum += stack.size();
							stack.push(tall);
							break;
						}
					}
				}
			}
		}
		
		System.out.println(sum);
	}
}
