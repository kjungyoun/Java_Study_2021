package com.beak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S4_1015_수열정렬 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		int input[] = new int[N];
		int sort[] = new int[N];
		boolean isChecked[] = new boolean[N]; 
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		
		for (int i = 0; i <N; i++) {
			int num = Integer.parseInt(st.nextToken());
			input[i] = num;
			sort[i] = num;
		}
		
		Arrays.sort(sort);
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(input[i] == sort[j] && !isChecked[j]) {
					isChecked[j] = true;
					sb.append(j).append(" ");
					break;
				}
			}
		}
		System.out.println(sb);
	}

}
