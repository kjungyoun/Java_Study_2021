package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_다항식 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		String cal = in.readLine();

		if (cal.equals("*")) {
			int N = Integer.parseInt(in.readLine()); // 첫번째 다항식의 전체 차수 입력
			int first[] = new int[N + 1]; // 첫번째 다항식 정보를 저장할 배열 선언

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine()); // N번에 걸쳐 다항식의 정보를 받음
				int num = Integer.parseInt(st.nextToken()); // 계수를 num 변수에 저장
				int idx = Integer.parseInt(st.nextToken()); // 차수를 idx 변수에 담고 다항식의 인덱스로 이용

				first[idx] = num; // 첫번째 다항식 배열에 해당 차수에 계수를 저장
			}

			int M = Integer.parseInt(in.readLine()); // 두번째 다항식의 전체 차수 입력
			int second[] = new int[M + 1]; // 두번째 다항식 정보를 저장할 배열 선언

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine()); // M번에 걸쳐 다항식의 정보를 받음
				int num = Integer.parseInt(st.nextToken()); // 계수 저장
				int idx = Integer.parseInt(st.nextToken()); // 차수 저장

				second[idx] = num; // 두번째 다항식 배열에 해당 차수에 계수를 저장
			}

			int result[] = new int[N + M + 1]; // 결과를 저장할 배열 선언

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					result[i + j] += first[i] * second[j]; // 첫째 다항식과 둘째 다항식의 차수 합인 곳에 계수의 곱을 저장
				}
			}
			
			for (int i = N+M; i > -1; i--) {
				if(result[i] !=0) // 결과배열에서 계수가 0이 아니면
					System.out.println(result[i] +" "+ i); //출력
			}
		}
	}

}
