package com.beak;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_10819_차이를최대로 {
	
	static int input[];
	static int N, max;
	static boolean isSelected[];
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		input = new int[N];
		isSelected = new boolean[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		permutation(0,0,0);
		System.out.println(max);

	}
	
	public static void permutation(int cnt, int prev, int sum) {
		if(cnt == N) {
			max = Math.max(max, sum);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			if(cnt == 0) permutation(cnt+1, input[i], sum);
			else permutation(cnt+1, input[i], sum + Math.abs(prev-input[i]));
			isSelected[i] = false;
		}
	}

}
