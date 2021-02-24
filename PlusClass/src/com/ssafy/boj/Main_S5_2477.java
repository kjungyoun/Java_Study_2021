package com.ssafy.boj;

import java.util.Scanner;

public class Main_S5_2477 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int[][]arr = new int[5][2];
		int[] count = new int[5];
		int big = 1;
		int small = 1;
		
		for (int i = 0; i < 6; i++) {
			int dir = sc.nextInt();
			int len = sc.nextInt();
			count[dir]++;
			
			if(arr[dir][0] != 0) arr[dir][1] = len;
			else arr[dir][0] = len;
		}
		
		for (int i = 1; i <5; i++) {
			if(count[i] == 1) big *= arr[i][0];
			if(count[i] == 2) {
				if(i < 3) {
					small *= arr[i][0];
				}else small*= arr[i][1];
			}
		}
		System.out.println(K*(big-small));
	}
	
}
