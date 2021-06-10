package com.custom;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_test2 {

	public static void main(String[] args)throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		String line = in.readLine();
		int length = line.length();
		
		int max = 0;
		
		int cnt[] = new int[26];
		for (int i = 0; i <= length-N; i++) {
			for (int j = i; j < i+N; j++) {
				cnt[line.charAt(i)-'A']++;
			}
		}
		
		char ans = '0';
		for (int i = 0; i < 26; i++) {
			if(max< cnt[i]) {
				max = cnt[i];
				ans = (char) (i + 'A');
			}
		}
		
		
		System.out.println(ans);
	}

}
