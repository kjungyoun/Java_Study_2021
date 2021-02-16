package com.ssafy.BOJ;

import java.util.Scanner;

public class Main_B1_2839_김정윤3 {
	/*
	 * 백준 2839 브론즈1 설탕배달
	 */
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		count = 0;
		while(true){
			if(N%5 == 0) {
				count += N/5;
				N %= 5;
			}else {
				N -= 3;
				count++;				
			}
			
			if(N == 0) break;
			else if (N < 0) {
				count = -1;
				break;
			}
		}
		System.out.println(count);
	}
}
