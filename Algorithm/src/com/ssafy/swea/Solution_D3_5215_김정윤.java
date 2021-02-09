package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_5215_김정윤 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = null;
		 int T = Integer.parseInt(in.readLine());
		 for (int test_case = 1; test_case <= T; test_case++) {
			 int max = Integer.MIN_VALUE;
			 st = new StringTokenizer(in.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int [][] data = new int[N][2];
			
			for (int i = 0; i < N; i++) { // 데이터 저장
				st = new StringTokenizer(in.readLine()," ");
				data[i][0] = Integer.parseInt(st.nextToken());
				data[i][1] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < 1<<N; i++) { // 2^n 개의 경우의 수를 check
				int calSum = 0; // 칼로리의 합을 저장
				int tasteSum = 0; // 맛의 합을 저장
				for (int j = 0; j <N; j++) {
					if((i & 1<<j) != 0) { // j 가 data 배열의 index로 사용
						calSum += data[j][1];
						tasteSum += data[j][0];
					}
					if(calSum<=L) {
						max = Math.max(max, tasteSum);
					}
				}
			}
			System.out.println("#"+test_case+" "+ max);
		}

	}

}
