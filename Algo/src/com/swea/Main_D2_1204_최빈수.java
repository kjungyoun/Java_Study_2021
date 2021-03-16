package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_D2_1204_최빈수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// 테스트케이스 입력
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		for (int test_case = 1; test_case <= T; test_case++) {
			// 점수의 빈도수 저장할 배열
			int count[] = new int [101];
			
			// 테스트케이스 번호 입력 버림
			in.readLine();
			
			// 1000명의 점수 count
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < 1000; i++) {
				int input = Integer.parseInt(st.nextToken());
				count[input]++;
			}
			
			// 최대 갯수의 점수를 저장할 변수 max
			int max = 100;
			for (int i = 100; i > -1; i--) {
				if(count[max] < count[i]) {
					max = i;
				}
			}
			System.out.println("#"+test_case+" "+max);
		}
	}

}
