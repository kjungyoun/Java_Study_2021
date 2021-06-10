package com.beak;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_G4_9935_폭발문자열 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Character>stack = new Stack<Character>();
		
		String input  = in.readLine(); // 입력 문자열 저장
		String bomb = in.readLine();   // 폭탄 문자열 저장
		StringBuilder sb = new StringBuilder();
		int size = input.length(); // 입력 문자열의 길이
		int bsize = bomb.length(); // 폭탄 문자열의 길이
		
		top: for (int i = 0; i < size; i++) {
			char cur = input.charAt(i);
			stack.push(cur); //stack에 글자 추가
			if(cur == bomb.charAt(bsize-1)) { // 폭탄의 맨 마지막과 같으면
				for (int idx = bsize-1; idx > -1; idx--) { // 폭탄의 길이만큼 비교
					int position = stack.size()-bsize + idx; // stack 에 있는 문자의 위치
					if(position >= 0 && stack.get(position) == bomb.charAt(idx))
						continue;
					else continue top;
				}
				// 폭탄이 존재함
				for (int j = 0; j < bsize; j++) {
					// 폭탄 제거
					stack.pop();
				}
			}
		}
		// 결과를 담음
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		// StringBuilder를 뒤집음
		sb.reverse();
		
		System.out.println(sb.length() == 0 ? "FRULA" : sb);
		
		

	}

}
