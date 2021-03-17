package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S5_10158_개미 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		// 개미의 좌표 입력
		st = new StringTokenizer(in.readLine());
		int fr = Integer.parseInt(st.nextToken());
		int fc = Integer.parseInt(st.nextToken());
		
		int hour = Integer.parseInt(in.readLine());
		
		int idR =1;
		int idC = 1;
		int r = fr;
		int c = fc;
		for (int i = 1; i <= hour; i++) {
			int nr = r + idR;
			int nc = c + idC;
			if((nr<0 || nr > w) && (nc<0 || nc> h)) {
				idR = -idR;
				idC = -idC;
				nr = r + idR;
				nc = c + idC;
			}else if (nr<0 || nr > w) {
				idR = - idR;
				nr = r + idR;
			}else if (nc < 0 || nc > h) {
				idC = -idC;
				nc = c + idC;
			}if(nr == fr && nc == fc && idR == 1 && idC == 1) {
				hour%=i;
				i = 0;
			}
			r = nr;
			c = nc;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(r).append(" ").append(c);
		System.out.println(sb);
	}

}
