package com.ssafy.exhaustive;

import java.util.Scanner;

public class A1_ZigZegSearch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int map[][] = new int[r][c];
		sc.nextLine();
		for (int i = 0; i < r; i++) {
			String line = sc.nextLine();
			for (int j = 0,k=0; j < c; j++,k +=2) {
//				map[i][j] = Character.getNumericValue(line.charAt(k));
				map[i][j] = line.charAt(k)-'0';
			}
		}
//		int r = 3;
//		int c = 4;
//		int map[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		
		// 지그재그 탐색
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(map[i][j +((c-1)-2*j)*(i%2)] + " ");
			}
			System.out.println();
		}

	}

}
