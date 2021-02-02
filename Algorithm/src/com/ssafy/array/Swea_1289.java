package com.ssafy.array;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1289 {

	public static void main(String[] args) throws Exception {
		// 파일로 입력 읽기
		System.setIn(new FileInputStream("res/swea/d3/1289_원재의메모리복구하기.txt"));
		// 콘솔창으로 입력 읽기 -> 알고리즘 제출 시 위에 파일로 읽는 코드는 주석처리하면 된다.
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		int AnswerN = 0;
		for (int test_case = 1; test_case <= T; test_case++) {
			AnswerN = 0;
			 String norm = in.readLine();
			StringBuilder sb = new StringBuilder("");
			 for (int i = 0; i < norm.length(); i++) {
				sb.append("0");
			}
			 for (int i = 0; i < norm.length(); i++) {
				if((norm.charAt(i) != sb.charAt(i)) && norm.charAt(i) == '0') {
					sb.delete(i, sb.length());
					for (int j = i; j < norm.length(); j++) {
						sb.append("0");						
					}
//					System.out.println(sb);
					AnswerN++;
				}else if((norm.charAt(i) != sb.charAt(i)) && norm.charAt(i) == '1') {
					sb.delete(i, sb.length());
					for (int j = i; j < norm.length(); j++) {
						sb.append("1");						
					}
//					System.out.println(sb);
					AnswerN++;
				}
			}
			 System.out.printf("#%d %d",test_case,AnswerN);
			 System.out.println();
		}

	}

}
