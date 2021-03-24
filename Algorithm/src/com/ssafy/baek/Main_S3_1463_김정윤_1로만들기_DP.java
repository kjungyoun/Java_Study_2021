package com.ssafy.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_S3_1463_김정윤_1로만들기_DP {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int memo[] = new int[N+1];
		
		for (int i = 2; i <= N; i++) {
			memo [i]= memo[i-1] + 1; // +1 
			if(i%2==0) {
				memo[i] = Math.min(memo[i], memo[i/2]+1);
			}
			if(i%3 == 0) {
				memo[i] = Math.min(memo[i], memo[i/3]+1);
			}
			memo[i] = memo[i];
		}
		System.out.println(memo[N]);
		
	}

}
