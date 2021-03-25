package com.ssafy.jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1077_배낭채우기1_김정윤2 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken()); // 보석의 종류 개수
		int W = Integer.parseInt(st.nextToken()); // 가방 최대 무게
		int[][] jam = new int[N+1][2];
		int[] result = new int[W+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			jam[i][0] = Integer.parseInt(st.nextToken());
			jam[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int item = 1; item <=N; item++) {
			int weight = jam[item][0]; // 현재 보석 무게
			int val = jam[item][1]; // 현재 보석 가치
			
			for (int curW = 1; curW <=W; curW++) {
				if(weight <= curW) {
					// 선택한 보석을 하나도 담지 않았을 경우 vs 선택한 보석을 최대로 담았을 경우 -> 최대 값을 결과에 저장
					result[curW] = Math.max(result[curW], result[curW - weight]+val);
				}
			}
		}
		System.out.println(result[W]);
	}

}
