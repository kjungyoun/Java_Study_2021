package com.ssafy.boj;

import java.util.Scanner;

public class Main_S5_2477_참외밭 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int input[][] = new int[6][2];
		int maxW = 0;
		int maxH = 0;
		
		for (int i = 0; i < 6; i++) {
			int dir = sc.nextInt();
			int len = sc.nextInt();
			if(dir == 1 | dir == 2) maxW = Math.max(maxW, len);
			if(dir == 3 | dir == 4) maxH = Math.max(maxH, len);
			input[i][0] = dir;
			input[i][1] = len;
		}
		
		int sum = 1;
		for (int i = 0; i < 6; i++) {
			if(input[(i+5)%6][0] == input[(i+1)%6][0]) {
				sum *= input[i][1];
			}
		}
		
		System.out.println((maxW*maxH - sum)*K);

	}

}
