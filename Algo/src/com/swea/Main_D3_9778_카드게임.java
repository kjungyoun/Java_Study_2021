package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_D3_9778_카드게임 {
	// 블랙잭의 숫자 저장
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// 테스트케이스 입력 저장
		int T = Integer.parseInt(in.readLine());
		ex: for (int test_case = 1; test_case <= T; test_case++) {
			// 전체카드 갯수 셋팅
			int card[] = new int[12];
			for (int i = 2; i < 12; i++) {
				if(i == 10) {
					card[i] = 16;
					continue;
				}
				card[i] = 4;
			}
			// 뽑은카드갯수 & 카드 종류 입력저장
			// 뽑은 카드 합 저장 변수 sum
			int sum = 0;
			int N = Integer.parseInt(in.readLine());
			for (int i =0; i < N; i++) {
				int num = Integer.parseInt(in.readLine());
				card[num]--;
				sum += num;
			}
			
			int diff = 21 - sum;
			if(diff < 2) {
				System.out.println("#"+test_case+" STOP");
				continue ex;
			}else if(diff > 11) {
				System.out.println("#"+test_case+" GAZUA");
				continue ex;
			}
			
			
			// 21 이하로 만드는 카드 갯수 & 21보다 큰 수를 만드는 카드 갯수 count
			int low = 0;
			int high = 0;
			for (int i = 2; i <=diff; i++) {
				low += card[i];
			}
			
			for (int i = diff+1; i <12; i++) {
				high += card[i];
			}
			
			if(high >= low) {
				System.out.println("#"+test_case+" STOP");
			}else System.out.println("#"+test_case+" GAZUA");
			
		}

	}

}
