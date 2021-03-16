package com.beak;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_S5_2635_수이어가기 {
	static int N;
	static int maxNum, max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		max = 0;
		for (int i = N/2; i <= N; i++) {
			go(i);
		}
		int arr[] = new int[max];
		arr[0] = N;
		arr[1] = maxNum;
		int x,y;
		x = N;
		y = maxNum;
		for (int i = 2; i < max; i++) {
			arr[i]= x-y;
			x = y;
			y = arr[i];
		}
		System.out.println(max);
		for (int i : arr) {
			System.out.print(i+" ");
		}

	}

	public static void go(int n1) {
		int cnt = 2;
		int a1 = N;
		int a2 = n1;
		int a3;
		while (true) {
			a3 = a1 - a2;
			if (a3 < 0) {
				if (max < cnt) {
					max = cnt;
					maxNum = n1;
				}
				break;
			}
			a1 = a2;
			a2 = a3;
			cnt++;
		}
	}
}
