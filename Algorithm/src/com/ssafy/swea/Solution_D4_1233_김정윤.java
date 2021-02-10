package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1233_김정윤 {
	static int AnswerN;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int test_case = 1; test_case <= 10; test_case++) {
			AnswerN =1;
			int N = Integer.parseInt(in.readLine());
			for (int i = 0; i < N; i++) {
				String input[] = in.readLine().split(" ");
				if(AnswerN ==0) continue;
				if(N %2 == 0) { // N이 짝수이면 마지막 부모노드의 자식의 수는 1이므로 무조건 불가
					AnswerN = 0;
					continue;
				}
				else {
					// 부모 노드일 경우 반드시 연산자여야 하고 자식의 수가 2명이어야 한다.
					if(Integer.parseInt(input[0]) <= N/2 && (input[1].equals("+") || input[1].equals("-") || input[1].equals("/") || input[1].equals("*") 
							&& input.length == 4)) {
						AnswerN = 1;
						continue;
					// 자식 노드일 경우 반드시 자식은 없어야하고 숫자로 값이 이루어져야 한다.
					}else if(Integer.parseInt(input[0]) > N/2 && !(input[1].equals("+") || input[1].equals("-") || input[1].equals("/") || input[1].equals("*") 
							&& input.length == 2)){
						AnswerN = 1;
						continue;
					}else {
						AnswerN = 0;
					}
				}
			}
			System.out.println("#"+test_case+" "+AnswerN);
		}
	}

}
