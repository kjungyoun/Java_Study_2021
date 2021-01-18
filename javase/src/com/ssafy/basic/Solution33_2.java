package com.ssafy.basic;

import java.util.Scanner;

public class Solution33_2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("삼각형 출력할 줄 수를 입력해 주세요");
		int num = scan.nextInt();
		for(int i=0; i<num; i++) {
			for(int j=0; j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
