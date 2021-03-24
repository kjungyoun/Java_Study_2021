package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_1149_RGB거리_sol {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(in.readLine());
		
		int color[] = new int[3]; // 각 집의 최소 비용을 저장하는 배열
		
		int R = 0, G=0, B=0,beforeR=0, beforeG=0, beforeB=0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			R = Integer.parseInt(st.nextToken());
			G = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			beforeR = color[0];
			beforeG = color[1];
			beforeB = color[2];
			
			color[0] = R + Math.min(beforeG, beforeB);
			color[1] = G + Math.min(beforeR, beforeB);
			color[2] = B + Math.min(beforeR, beforeG);
		}
		
		
		// 마지막 집에서 3가지 색깔 중 최소 비용의 색깔의 집을 선택
		int answer = Math.min(color[0], Math.min(color[1], color[2]));
		System.out.println(answer);
	}

}
