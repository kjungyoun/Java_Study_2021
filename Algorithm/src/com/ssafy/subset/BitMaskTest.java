package com.ssafy.subset;

public class BitMaskTest {

	public static void main(String[] args) {
		for (int i = 0; i < 8; i++) {
			printBit(i);
		}
	}
	static void printBit(int i) {
		for (int j = 7; j >=0; j--) { // 맨 첫 자리부터 비교
			// i 숫자의 j+1번째 비트가 0인지 1인지 알 수 있음
			System.out.print((i & 1<<j) !=0 ? 1 : 0+" ");
		}
		System.out.println();
	}
	
}
