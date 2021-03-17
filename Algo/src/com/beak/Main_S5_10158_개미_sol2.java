package com.beak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_S5_10158_개미_sol2 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		
		st = new StringTokenizer(in.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int t = Integer.parseInt(in.readLine());
		
		
		int divR = (r+t)/w;
		int divC = (c+t)/h;
		
		if(divR %2 == 0) {
			r = (r+t)%w;
		}else r = w - (r+t)%w;
		
		if(divC %2 == 0) {
			c = (c+t)%h;
		}else c = h - (c+t)%h;
		
		StringBuilder sb = new StringBuilder();
		sb.append(r).append(" ").append(c);
		System.out.println(sb);
		
	}

}
