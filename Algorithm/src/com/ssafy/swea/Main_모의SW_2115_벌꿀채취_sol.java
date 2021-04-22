package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_모의SW_2115_벌꿀채취_sol {
	
	static int[][]map;
	static int N,M,C,maxSum;
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			System.out.println("#"+tc+" "+getMaxBenefit());
		}
	}
	
	private static int getMaxBenefit() {
		
		return processCombination();
	}
	
	
	private static int processCombination() {
		int result = 0, aBenefit = 0, bBenefit = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N-M; j++) { // 첫 열부터 연속된 M개 채취가 가능한 열까지, 일꾼 A의 선택
				
				// 선택된 M개 벌통에서 얻을 수 있는 최대 이익
				maxSum = 0;
				makeMaxSubset(i, j, 0, 0, 0);
				aBenefit = maxSum;
				
				maxSum=0;
				bBenefit = 0;
				// 일꾼 B의 선택
				// 일꾼 A와 같은 행에서 선택
				for (int j2 = j+M; j2 <= N-M; j2++) {
					makeMaxSubset(i, j2, 0, 0, 0); // maxSum
					if(bBenefit< maxSum) bBenefit = maxSum;
				}
				
				// 일꾼 A의 다음행에서 선택
				for (int i2 = i+1; i2 < N; i2++) {
					for (int j2 = 0; j2 <= N-M; j2++) {
						makeMaxSubset(i2, j2, 0, 0, 0);
						if(bBenefit<maxSum)bBenefit = maxSum;
					}
				}
				
				if(result < aBenefit + bBenefit) result = aBenefit + bBenefit;
			}
		}
		return result;
	}
	
	private static void makeMaxSubset(int i, int j, int cnt, int sum, int powerSum) {
		
		// 제한 양을 넘었는지 확인
		if(sum > C) return;
		
		// 마지막 원소까지 다 부분집합에 고려해봤다면
		if(cnt == M) {
			if(maxSum < powerSum) maxSum = powerSum;
			return;
		}
		
		// 선택
		makeMaxSubset(i, j+1, cnt+1, sum+map[i][j], powerSum+(map[i][j] * map[i][j]));
		
		// 비선택
		makeMaxSubset(i, j+1, cnt+1, sum, powerSum);
	}
}
