package com.beak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S5_10158_개미_sol {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		
		st = new StringTokenizer(in.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int t = Integer.parseInt(in.readLine());
		
		int dr = 1;
		int dc = 1;
		while(t>0) {
			if(r == 0 || r == h) {
				dr *= -1;
			}
			if(c == 0 || c == w) { // 방향을 바꾸기
				dc *= -1;
			}
			int lenR = w -r; // r 위치에서 위아래 경계까지의 거리
			if(dr == -1) {
				lenR = r;
			}
			int lenC = h -c; // c 위치에서 위아래 경계까지의 거리
			if(dc == -1) {
				lenC = c;
			}
			
			// lenR, lenC, t 세가지 숫자중 최소 값 만큼 진행
			int min = Math.min(Math.min(lenR, lenC), t);
			
			r = r+dr*min;
			c = c+dc*min;
			 t--;
		}
	}

}
