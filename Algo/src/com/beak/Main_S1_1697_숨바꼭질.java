package com.beak;

import java.util.Scanner;

public class Main_S1_1697_숨바꼭질 {
	static int time,K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		time = Integer.MAX_VALUE;
		int N = sc.nextInt();
		K = sc.nextInt();
		go(N,0);
		System.out.println(time);
	}
	
	public static void go(int n, int t) {
		if(t>time) return;
		if(n == K) {
			time = Math.min(time, t);
			return;
		}
		if(n>K) {
			if(n-K >= 2) return;
			else if(n-K == 1) go(n-1,t+1);
			else {
				time = Math.min(time, t);
				return;
			}
		}
		go(n*2,t+1);
		go(n-1,t+1);
		go(n+1,t+1);
	}

}
