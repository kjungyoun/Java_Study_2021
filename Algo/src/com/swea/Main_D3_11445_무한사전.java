package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_D3_11445_무한사전 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String P = in.readLine();
			String Q = in.readLine();
			
			
		ArrayList<Character> word1 = new ArrayList<Character>();
		ArrayList<Character> word2 = new ArrayList<Character>();
		
		for (int i = 0,size = P.length(); i < size; i++) {
			char k = P.charAt(i);
			if(k != ' ') {
				word1.add(k);
			}
		}
		for (int i = 0,size = Q.length(); i < size; i++) {
			char k = Q.charAt(i);
			if(k != ' ') {
				word2.add(k);
			}
		}
		
		int psize = word1.size();
		int qsize = word2.size();
		int diff = qsize - psize;
		
		if(diff == 0) {
			int sum = 0;
			for (int i = 0; i < psize; i++) {
				sum += word2.get(i) - word1.get(i);
			}
			 if(sum == 0 || sum == 1 || sum == -24) {
				 System.out.println("#"+test_case+" N");
			 }else System.out.println("#"+test_case+" Y");
		}else if(diff == 1) {
			int sum = 0;
			for (int i = 0; i < psize; i++) {
				sum += word2.get(i) - word1.get(i);
			}
			if(sum == 0) {
				if(word2.get(qsize-1) == 'a') {
					System.out.println("#"+test_case+" N");
				}else System.out.println("#"+test_case+" Y");
			}
		}else if(diff >= 2) {
			System.out.println("#"+test_case+" Y");
		}
		else {
			int sum = 0;
			for (int i = 0; i < qsize; i++) {
				sum += word2.get(i) - word1.get(i);
			}
			if(sum ==1) {
				int count=0;
				for (int i = qsize; i < psize; i++) {
					if(word1.get(i) == 'z') count++;
				}
				if(count == psize-qsize) {
					System.out.println("#"+test_case+" N");
				}else System.out.println("#"+test_case+" Y");
			}
		}
		
		}

	}

}
