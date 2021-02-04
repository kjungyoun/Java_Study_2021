package com.ssafy.permutaion;

import java.util.Arrays;
import java.util.Scanner;

public class DiceTest {
	static int numbers[];
	static boolean isSelected[];
	static int N,totalCount;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers = new int[N];
		isSelected = new boolean[7];
		dice1(0);
		System.out.println(totalCount);
		totalCount=0;
		dice2(0);
		System.out.println(totalCount);
		totalCount=0;
		dice3(0);
		System.out.println(totalCount);
		totalCount=0;
		dice4(0,1);
		System.out.println(totalCount);
		totalCount=0;
		dice5(0,1);
		System.out.println(totalCount);

	}
	
	// 중복 순열
	public static void dice1(int cnt) {
		if(cnt == N) {
			System.out.println(Arrays.toString(numbers));
			totalCount++;
			return;
		}
		for (int i = 1; i <= 6; i++) {
			numbers[cnt] = i;
			dice1(cnt+1);
		}
	}
	
	// 순열 (for문을 이용한 중복 체크)
	public static void dice2(int cnt) {
		if(cnt == N) {
			System.out.println(Arrays.toString(numbers));
			totalCount++;
			return;
		}
		top:
		for (int i = 1; i <=6; i++) {
			for (int j = 0; j < cnt; j++) {
				if(numbers[j] == i) continue top;
			}
			numbers[cnt] = i;
			dice2(cnt+1);
		}
	}
	
	// 순열 (boolean 배열을 이용한 중복 체크)
	public static void dice3(int cnt) {
		if(cnt == N) {
			System.out.println(Arrays.toString(numbers));
			totalCount++;
			return;
		}
		for (int i = 1; i <=6; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			numbers[cnt] = i;
			dice3(cnt+1);
			isSelected[i] = false;
		}
	}
	
	// 중복을 허용하는 조합
	public static void dice4(int cnt, int start) {
		if(cnt == N) {
			System.out.println(Arrays.toString(numbers));
			totalCount++;
			return;
		}
		for (int i = start; i <=6; i++) {
			numbers[cnt] = i;
			dice4(cnt+1,i);
		}
	}
	
	// 중복을 허용하지 않는 조합
	public static void dice5(int cnt, int start) {
		if(cnt==N) {
			System.out.println(Arrays.toString(numbers));
			totalCount++;
			return;
		}
		for (int i = start; i <=6; i++) {
			numbers[cnt] = i;
			dice5(cnt+1,i+1);
		}
	}
}
