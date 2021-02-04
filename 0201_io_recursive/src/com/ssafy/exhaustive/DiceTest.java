package com.ssafy.exhaustive;

import java.util.Arrays;
import java.util.Scanner;

public class DiceTest {
	static int[] numbers;
	static boolean[] isSelected;
	static int N,totalCnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 주사위 던진 횟수
		numbers = new int[N];
		isSelected = new boolean[7];
		
		int M = sc.nextInt(); // 던지기 모드
		totalCnt = 0;
		
		switch (M) {
		case 1:
			dice1(0);
			break;
		case 2:
			dice2(0);
			break;
		case 3:
			dice3(0);
			break;
		case 4:
			dice4(0,1);
			break;
		case 5:
			dice5(0,1);
			break;
		}
		System.out.println("총 경우의 수: "+totalCnt);
	}

	// 중복 순열 :
	public static void dice1(int cnt) {
		if(cnt ==N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 1; i <= 6; i++) {
			numbers[cnt] = i;
			dice1(cnt+1);
		}
		
	}
	
	// 중복 허용하지 않는 순열
	public static void dice2(int cnt) {
		if(cnt==N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 1; i <=6; i++) {
			if(isSelected[i] == true) continue;
			isSelected[i] = true;
			numbers[cnt] = i;
			dice2(cnt+1);
			isSelected[i] = false;
		}
	}
	
	// 중복 허용하지 않는 순열2
	public static void dice3(int cnt) {
		if(cnt==N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		top:
		for (int i = 1; i <=6; i++) {
			for (int j = 0; j < cnt; j++) {
				if(numbers[j]==i) continue top;
			}
			numbers[cnt] = i;
			dice3(cnt+1);
		}
	}
	
	// 중복 조합 nTTr : 6TT3 : n+r-1Cr : 8C3 : 56
	public static void dice4(int cnt, int start) {
		if(cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = start; i <=  6; i++) {
			numbers[cnt] = i;
			// 중복조합은 현재 뽑은 수의 다음부터가 아닌 현재 뽑은 수부터 for문을 시작하게 하면 됨
			// 현재 뽑은 수의 이전 수들은 이미 모든 조합으로 사용하였음
			dice4(cnt+1,i);
		}
	}
	
	// 조합 6C3
	public static void dice5(int cnt, int start) {
		if(cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = start; i <=  6; i++) {
			numbers[cnt] = i;
			// 일반 조합은 for문을 현재 뽑은 수의 다음부터 시작하면 됨 
			dice5(cnt+1,i+1);
		}
	}
	
}
