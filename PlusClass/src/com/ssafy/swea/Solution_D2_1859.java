package com.ssafy.swea;

import java.util.Scanner;

public class Solution_D2_1859 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int ans = 0;
			int N = sc.nextInt();
			int [] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			int max = 0;
			for (int i = N-1; i >=0; i--) {
				if(arr[i]>max) {
					max=arr[i];
	
				}else {
					ans += max-arr[i];
				}
			}
			System.out.println("#"+test_case+" "+ans);
		}

	}

}
