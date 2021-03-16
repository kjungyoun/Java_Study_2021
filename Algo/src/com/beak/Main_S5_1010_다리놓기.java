package com.beak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S5_1010_다리놓기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// 테스트케이스 입력
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		for (int test_case = 0; test_case < T; test_case++) {
			st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			long sum = 1;
			long div = 1;
			if (N > M - N) {
				for (int i = M; i > N; i--) {
					sum *= i;
				}
				for (int i = 1; i <= M - N; i++) {
					div *= i;
				}
			} else {
				for (int i = M; i > M - N; i--) {
					sum *= i;
				}
				for (int i = 1; i <= N; i++) {
					div *= i;
				}
			}
			System.out.println(sum/div);

		}
	}

}
