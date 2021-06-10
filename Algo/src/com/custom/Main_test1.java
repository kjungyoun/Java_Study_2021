package com.custom;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_test1 {

	public static void main(String[] args)throws Exception {
		int cnt[] = new int[26];
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = in.readLine();
		int length = line.length();
		
		for (int i = 0; i < length; i++) {
			cnt[line.charAt(i)-'A']++;
		}
		
		int max = 0;
		for (int i = 0; i < 26; i++) {
			max = Math.max(max, cnt[i]);
		}
		
		System.out.println(max);
	}

}
