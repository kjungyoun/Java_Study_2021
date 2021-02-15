package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_6808_김정윤_Boolean {

	static boolean isSelected[];
	static int[] card; // 남은 숫자의 카드 순열 저장
	static int[] input; // 입력 숫자를 저장할 배열
	static int winCount,loseCount;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		
		for (int test_case = 1; test_case <= T; test_case++) {
			winCount = 0;
			loseCount = 0;
			isSelected = new boolean[19];
			card = new int[9];
			input = new int[9];
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < 9; i++) { // 입력 저장
				input[i] = Integer.parseInt(st.nextToken());
				isSelected[input[i]] = true;
			}
			permutation(0);
			System.out.println("#"+test_case+" "+winCount+" "+loseCount);	
		}
	}
	public static void permutation(int cnt) {
		if(cnt == 9) {
			int gSum = 0, iSum = 0;
			for (int i = 0; i < 9; i++) {
				if(input[i]>card[i]) { // 규영이가 이긴 경우
					gSum += input[i]+card[i];
				}else if(input[i]<card[i]) { // 인영이가 이긴 경우
					iSum += input[i]+card[i];
				}
			}
			// 규영이의 점수가 더 높을 경우
			if(gSum>iSum) winCount++;
			// 인영이의 점수가 더 높을 경우
			else if(gSum<iSum) loseCount++;
			return;
		}
		for (int i = 1; i <= 18; i++) {
			// 사용한 카드 자동으로 거름
			if(isSelected[i]) continue;
			card[cnt] = i;
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}

}
