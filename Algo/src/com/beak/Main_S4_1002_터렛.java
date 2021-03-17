package com.beak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S4_1002_터렛 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = 0;
			st= new StringTokenizer(in.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			double dir = Math.sqrt(Math.pow((x1-x2),2) + Math.pow((y1-y2),2));
			
			if(x1 != x2 || y1 != y2) {
				if(dir == r1+r2 || dir+r1 == r2 || dir+r2 == r1) {
					answer = 1;
				}else if(dir > r1+r2 || dir+r1 < r2 || dir +r2 < r1) {
					answer = 0;
				}else {
					answer = 2;
				}
			}else if(x1 == x2 && y1 == y2) {
				if(r1 == r2) {
					answer = -1;
				}else {
					answer = 0;
				}
			}
			System.out.println(answer);
		}

	}

}
