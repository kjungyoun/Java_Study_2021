package com.beak;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_G5_1461_도서관 {
	
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int max = 0;
		
		LinkedList<Integer> minus = new LinkedList<Integer>();
		
		LinkedList<Integer>plus = new LinkedList<Integer>();
		
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num < 0) minus.add(Math.abs(num));
			else plus.add(num);
			
			max = Math.max(max, Math.abs(num));
		}
		
		Collections.sort(minus, Collections.reverseOrder());
		Collections.sort(plus, Collections.reverseOrder());
		
		int idx = 0;
		int sum = 0;
		
		if(!minus.isEmpty() && max == minus.peek()) {
			for (int i = 0; i < M; i++) {
				minus.poll();
			}
		}
		
		while(!minus.isEmpty()) {
			
			if(idx < M) {
				if(idx == 0)
					sum += minus.peek();
				
				minus.poll();
				idx++;
				
				if(idx == M)
					idx = 0;
				
				continue;
			}
		}
		
		if(!plus.isEmpty() && max == plus.peek()) {
			for (int i = 0; i < M; i++) {
				plus.poll();
			}
		}
		
		idx = 0;
		while(!plus.isEmpty()) {
			if(idx < M) {
				if(idx == 0)
					sum += plus.peek();
				
				plus.poll();
				idx++;
				
				if(idx == M)
					idx = 0;
				
				continue;
			}
		}
		
		int ans = sum*2 + max;
		System.out.println(ans);
		
		
		
	}

}
