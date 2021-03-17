package com.ssafy.boj;

import java.util.Arrays;
import java.util.Scanner;

public class Main_S5_2635_수이어가기 {
	public static int max,num;
	public static int arr[] = new int [30000];
	public static int ans[];
	
	public static void main(String[] args) {
		max = Integer.MIN_VALUE;
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		arr[0] = num;
		combination(1,0);
		System.out.println(max);
		for (int i = 0; i < max; i++) {
			System.out.print(ans[i]+" ");
		}
	}
	public static void go(int n1, int n2,int cnt) {
		arr[cnt] = arr[n1]-arr[n2];
		
		if(arr[cnt]<0) {
			max = Math.max(max, cnt);
			if(max == cnt) {
				ans = Arrays.copyOfRange(arr, 0, cnt);
			}
			return;
		}
		go(n1+1, n2+1,cnt+1);
	}
	
	public static void combination(int start, int cnt) {
		if(cnt == 1) {
			go(0,1,2);
			return;
		}
		for (int i = start; i <= num; i++) {
			arr[1] = i;
			combination(i+1,cnt+1);
		}
		return;
	}
}
