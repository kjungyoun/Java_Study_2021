package com.beak;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_G4_16916_문자열_바이어무어 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String word = in.readLine();
		String part = in.readLine();
		
		int skip[] = new int[27];
		
		Arrays.fill(skip, -1);
		int psize = part.length();
		int wsize = word.length();
		
		
		int idx = 0;
		for (int i = psize-1; i >=0; i--) {
			skip[part.charAt(idx++)-'a'] = i;
		}
		
		int start = psize-1;
		top: while(start<wsize) {
			int index = psize-1;
			for (int i = start; i > start - psize; i--) {
				if(word.charAt(i) != part.charAt(index--)) {
					int jump = skip[word.charAt(i)-'a'];
					if(jump != -1) {
						start = i + jump;
						continue top;
					}else {
						start = i + psize;
						continue top;
					}
				}
			}
			System.out.println(1);
			return;
		}
		System.out.println(0);
	}

}
