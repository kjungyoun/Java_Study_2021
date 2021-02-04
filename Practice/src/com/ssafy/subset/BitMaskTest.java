package com.ssafy.subset;

import java.util.Scanner;

public class BitMaskTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < 2<<N; i++) {
			printBit(i);
		}

	}

	public static void printBit(int i) {
		for (int j = 7; j>=0; j--) {
			System.out.print((i & 1<<j )!=0 ? 1:0 +" ");
		}
		System.out.println();
	}
}
