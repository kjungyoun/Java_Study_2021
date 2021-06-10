package com.beak;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_S1_17609_회문 {
	
	static char input[];
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		top:for (int tc = 0; tc < T; tc++) {
			String word = in.readLine();
			int length = word.length(); // 문자의 길이
			int front = -1;
			int back = length;
			int cnt = 0;
			input = new char[length];
			
			for (int i = 0; i < length; i++) {
				input[i] = word.charAt(i);
			}
			
			for (int i = 0; i < length; i++) {
				
				front += 1;
				back -= 1;
				
				if(front < back) {
					if(input[front] == input[back]) continue; // 같은 문자일 경우
					else {
						if(cnt == 0 && removeFront(front, back)) {
							front += 1;
							cnt++;
							continue;
						}
						if(cnt == 0 && removeBack(front, back)) {
							back -= 1;
							cnt++;
							continue;
						}
						System.out.println(2);
						continue top;
					}
				}else break;
			}
			
			if(cnt == 0)
				System.out.println(0);
			else
				System.out.println(1);
			
		}
	}
	
	private static boolean removeBack(int front, int back) {
		if(input[front] == input[back-1]) {
			
			return true;
		}
		return false;
	}
	
	private static boolean removeFront(int front, int back) {
		if(input[front+1] == input[back]) {
			if(removeBack(front, back)) {
				if(removeFront(front+1, back-1) && !removeBack(front+1, back-1))
					return true;
				else return false;
			}
			return true;
		}
		return false;
	}

}
