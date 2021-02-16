package com.ssafy.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_1062_김정윤 {

	static int answer,cnt,K,N;
	static String[] input;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken()); // 단어의 개수
		K = Integer.parseInt(st.nextToken()); // 가르칠 글자의 개수
		int flag = 0;
		cnt = 0; // 뽑은 글자 갯수 저장
		answer = 0;
		
		if(K>=5) {
			input = new String[N];
			// "anta" 와 "tica" 빼고 저장
			for (int i = 0; i < N; i++) {
				String k = in.readLine();
				input[i] = k.substring(4, k.length()-4);
			}
			String word = "antci"; // 기본으로 가져야할 단어 저장
			flag = init(word,flag);
			generate(0, flag);
			System.out.println(answer);
			
		}else { // 가르친 글자가 5글자보다 적으면 무조건 0 출력 (기본적으로 5글자는 배워야함)
			System.out.println(answer);
		}
		

	}
	
	// 기본으로 가져야할 단어 저장
	public static int init(String word, int flag) {
		for (int i = 0; i < word.length(); i++) {
			flag |= 1 << word.charAt(i)-'a';
		}
		// 5글자를 가짐
		cnt = 5;
		return flag;
	}
	
	public static void generate(int start, int flag) {
		if(cnt == K) {
			int count = 0;
			top:
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < input[i].length(); j++) {
					// 해당 문자가 사용되지 않았으면
					if((flag & 1<<input[i].charAt(j)-'a') == 0) continue top;
				}
				count++;
			}
			answer = Math.max(answer, count);
			return;
		}
		for (int i = start; i < 26; i++) {
			// 이미 사용된 문자면 pass
			if((flag & 1 << i) != 0) continue;
			cnt++; // 뽑은 갯수 증가시킴
			generate(i+1, flag | 1<<i);
			cnt--; // 뽑은 갯수 원래대로 돌림
		}
	}

}
