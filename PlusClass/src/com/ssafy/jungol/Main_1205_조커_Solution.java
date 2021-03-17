package com.ssafy.jungol;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main_1205_조커_Solution {
	static int jocker,N,ans,input[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int zero = 0;
		int [] data = new int[N];
		for (int i = 0; i < N; i++) {
			data[i] = sc.nextInt();
			if(data[i] == 0) zero++;
		}
		if(zero == N) {
			System.out.println(N);
			return;
		}
		Arrays.sort(data);
		int ans = 0; // 모든 위치에서 가장 큰 값을 저장할 변수
		for (int i = zero; i < N; i++) {
			// 0의 개수
			int jocker = zero;
			// 처음 시작 데이터
			int prev = data[i];
			// 연속 숫자 카운트
			int cnt = 1;
			// 연속되지 않은 첫번째 위치 찾기 위한 변수
			boolean first = true;
			// 비교할 첫번째 위치
			int k = i+1;
			while(k< N) {
				int curr = data[k];
				if(prev == curr) {
					k++;
				}else if(prev + 1 == curr) {
					cnt++;
					prev = curr;
					k++;
				}else { // 연속된 숫자가 아닌 경우
					if(first) {
					i = k-1;
					first = false;
					}
					if( jocker == 0) break;
					jocker --;
					cnt++;
					prev++;
				}
			}
			ans = Math.max(ans, cnt+ jocker);
		}
		System.out.println(ans);
	}
}
