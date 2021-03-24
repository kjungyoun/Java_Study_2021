package com.ssafy.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/*
#결과
#1 90
#2 90
#3 23915
 */
public class Knapsack {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		int T = Integer.parseInt(in.readLine());
		
		int N,W;
		int [] weight, profits;
		int[][] results;
		StringTokenizer st = null;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			weight = new int[N+1];
			profits = new int[N+1];
			results = new int[N+1][W+1];
			
			for (int i = 1; i <=N; i++) {
				st = new StringTokenizer(in.readLine());
				weight[i] = Integer.parseInt(st.nextToken());
				profits[i] = Integer.parseInt(st.nextToken());
			}
			
			int cw=0, value=0;
			int preVal = 0; // 이전 아이템까지 고려한 가치
			int diffVal=0;  // (배낭무게 - 현재 선택된 아이템 무게)의 이전 가치
			for (int item = 1; item <=N; item++) {
				cw = weight[item]; 		// 현 아이템의 무게
				value = profits[item]; // 현 아이템의 가치
				
				// 현 아이템을 1부터 W까지의 가치 테이블을 만들어보기
				for (int w = 1; w <=W; w++) {
//					if(cw <= w) { // 현재 배낭에 현재 아이템을 담을 수 있다.
//													// 이전 아이템의 가치	(배낭무게 - 현재 아이템 무게) 가치 + 현재 아이템의 가치
//						results[item][w] = Math.max(results[item-1][w], results[item-1][w-cw] + value);
//					}else { // 배낭에 현재 아이템을 담을 수 없을 때
//						// 이전 아이템의 가치를 담음
//						results[item][w] = results[item-1][w];
//					}
					preVal = results[item-1][w];
					
					if(cw <= w) {
						diffVal = results[item-1][w-cw];
						results[item][w] = Math.max(preVal, diffVal+value);
					}else {
						results[item][w] = preVal;
					}
				}
			}
			System.out.println("#"+tc+" "+results[N][W]);
		}
	}
	
	static String str = "3\n" + 
			"4 10\n" + 
			"5 10\n" + 
			"4 40\n" + 
			"6 30\n" + 
			"3 50\n" + 
			"4 16\n" + 
			"2 40\n" + 
			"5 30\n" + 
			"10 50\n" + 
			"5 10\n" + 
			"5 675\n" + 
			"331 4015\n" + 
			"120 8001\n" + 
			"265 9209\n" + 
			"13 6705\n" + 
			"359 809";

}
