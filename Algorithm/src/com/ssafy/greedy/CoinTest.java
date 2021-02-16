package com.ssafy.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CoinTest {	
	static 	Integer[] coin = {10, 100, 50, 500};
	static int[]result = new int[coin.length]; // 사용한 동전 갯수 저장
	
	public static void coinChange(int money) {
		for (int i = 0, end = coin.length; i < end; i++) {
			result[i] = money / coin[i];
			money %= coin[i];
		}
	}
	
	public static void print() {
		System.out.println("동전 교환 결과");
		System.out.println("===================");
		for (int i = 0,end=coin.length; i < end; i++) {
			if(result[i] == 0) continue;
			System.out.printf("%d원 : %d개 사용\n",coin[i],result[i]);
		}
	}
	
	public static void main(String[] args) {
		// sort 내에 Comparator를 사용하기 위해 Integer 객체로 선언함
		
		
		// 1. 탐욕 부리기 위해 가장 좋은 것 부터 선택 => 정렬 (내림차순)
		Arrays.sort(coin, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1; // 뒤에 것에서 앞의 것 빼면 내림차순
			}
			
		});
		
		System.out.println("거스름 돈을 입력하세요");
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		
		coinChange(money);
		print();
		
	}

}
