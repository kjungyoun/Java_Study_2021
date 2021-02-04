package com.ssafy.swea;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main_D4_5432_Array {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <=T; test_case++) {
			int stack[] = new int[50000];
			int cnt =0; 		// 쇠막대기 수
			int top = 0;		// '(' 의 개수
			
			// 1. 데이터 입력
			String input = sc.next();
			
			// 2. 전체 문자열 수를 반복 돌면서
			for (int i = 0, end = input.length(); i < end; i++) {
				// '(' 문자열이면 막대기 시작일 수 있으니 stack에 추가
					if(input.charAt(i) == '(') {
						stack[top++] = '(';
					}else {
						//  3. )
						//			'(' 수 하나 감소
						top--;
						
						//		3.1 idx-1 == '(' 	: 레이저인 경우
						if(input.charAt(i-1) == '(') {
						//			stack에 저장된 ( 개수 만큼 잘라질 수 있으므로 cnt에 추가
						cnt += top;	
						}
						// 		3.2 idx-1 != '('		: 쇠막대기 끝
						//			잘라진 쇠막대기 1개를 cnt에 추가
						else cnt ++;
					}
			}
			
			
			// 4. 결과 출력
			System.out.println("#"+test_case+" "+cnt);
		}
	}

}
