package com.ssafy.jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
 
/*
  * 정올 1828 냉장고
  * 첫 온도를 내림차순 정렬하여 품
  */
public class Main_1828_김정윤_sol2 {
	
	static class Chemistry implements Comparable<Chemistry>{
		int ltemp, htemp;

		public Chemistry(int ltemp, int htemp) {
			super();
			this.ltemp = ltemp;
			this.htemp = htemp;
		}

		@Override
		public int compareTo(Chemistry o) {
			return o.ltemp - this.ltemp;
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Chemistry[] input = new Chemistry[N];
		StringTokenizer st = null;
		
		for (int i = 0; i < N; i++) { // 입력 저장
			st = new StringTokenizer(in.readLine());
			input[i] = new Chemistry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		List<Chemistry> list = generate(input);
		System.out.println(list.size());

	}
	
	public static List<Chemistry> generate(Chemistry input[]) {
		ArrayList<Chemistry> list = new ArrayList<Chemistry>();
		Arrays.sort(input);
		
		list.add(input[0]);
		for (int i = 0,end=input.length; i < end; i++) {
			if(list.get(list.size()-1).ltemp >= input[i].ltemp && list.get(list.size()-1).ltemp <= input[i].htemp) continue;
			list.add(input[i]);
		}
		return list;
		
	}

}
