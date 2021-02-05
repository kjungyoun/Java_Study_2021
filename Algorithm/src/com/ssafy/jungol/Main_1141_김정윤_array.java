package com.ssafy.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 배열로 구현 => 시간초과 에러 발생
 */
public class Main_1141_김정윤_array {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int cow[][] = new int [n][2];
		int sum=0;
		for (int i = 0; i < n; i++) {
			int tall = Integer.parseInt(in.readLine());
			cow[i][0] = tall;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n; j++) {
				if(i+j <n) {
					if(cow[i][0]>cow[i+j][0]) { // 만약 내가 더 키가 크면
						cow[i][1]++;
					}else break;
				}else break;
			}
		}
		for (int i = 0; i < cow.length; i++) {
			sum += cow[i][1];
		}
		System.out.println(sum);
	}
}
