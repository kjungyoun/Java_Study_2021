package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_D3_1220 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		 for (int test_case = 1; test_case <= 10; test_case++) {
			 
			 int ans = 0;
			 int N = Integer.parseInt(in.readLine());
			 int[][]arr = new int[N][N];
			 boolean[][] flag = new boolean[N][N];
			 
			 for (int i = 0; i < N; i++) { // 입력 저장
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			 
			 for (int i = 0; i < N; i++) {
				 top: for (int j = 0; j < N; j++) {
					if(arr[i][j]==1) { // 붉은 자석이면
						for (int k = i; k < N; k++) {
							if(arr[k][j]==2) { // 파란색 자석을 찾으면
								if(flag[k][j]) continue top; // 이미 샌 파란색 자석이면
								else { // 새지 않은 파란색 자석이면
									ans++;
									flag[k][j] = true;
									continue top;
								}
							}
						}
					}
				}
			}
			 System.out.println("#"+test_case+" "+ans);
		}

	}

}
