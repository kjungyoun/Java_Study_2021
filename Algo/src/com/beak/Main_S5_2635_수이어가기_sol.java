package com.beak;

import java.util.Scanner;

public class Main_S5_2635_수이어가기_sol {
	static int N;
	public static void main(String[] args) {
		// 입력 Scanner
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int max = Integer.MIN_VALUE; // 수열 길이의 최대값
		String maxResult = "";		 // 최대 수열을 저장할 문자열
		// N, 1<= ? <= N 반복
		for (int i = 1; i <= N; i++) {
			int x = N;		// 첫번째 숫자
			int y = i; 		// 두번째 숫자
			int temp; 		// 세번째 숫자
			
			// N ? ... 수열의 개수 카운팅, 수열의 문자열로 저장(아이디어)
			StringBuilder result = new StringBuilder(x+" "+y); // 나중에 출력할 수열을 문자열로 저장
			int cnt = 2; // 수열의 길이
			while(true) { 	// 수열 생성
				temp = x-y;
				if(temp<0) { // 음수가 되면 종료
					if(max<cnt) {
						max = cnt;
						maxResult = result.toString();
					}
					break;
				}
				result.append(" ").append(temp);
				cnt++;
				x = y;
				y = temp;
			}
		}
		System.out.println(max);
		System.out.println(maxResult);
	}
}
