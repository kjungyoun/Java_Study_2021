package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_G5_2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Stack<int[]> stack = new Stack<int[]>();
		int N = Integer.parseInt(in.readLine());
		// 각 건물의 송신 건물 번호 저장
		int build[] = new int[N];
		int input[][] = new int[N][2];
		String sr = in.readLine();
		// StringTokenizer 를 이용하면 공백 기준으로 String으로 분리 가능
		StringTokenizer st = new StringTokenizer(sr," ");
		for (int i = 0; i < N; i++) {
			// String을 Int형으로 형변환
			int num = Integer.parseInt(st.nextToken());
			input[i][0] = i+1; // 건물 번호
			input[i][1] = num; // 건물 높이
		}

		for (int i = 0; i < N; i++) {
			if (i == 0) { // 맨처음 들어오는 값 셋팅
				build[i] = 0;
				// 첫번째 인자 건물 번호, 두번째 인자 건물 높이
				stack.push(input[i]);
				continue;
			}
			if (stack.peek()[1] >= input[i][1]) { // 스택에 있는 건물의 높이가 더 클 경우
				// 해당 건물 번호를 build에 저장
				build[i] = stack.peek()[0];
				stack.push(input[i]);

			} else {
				// 입력으로 들어온 높이가 더 클 경우
				//  for문 안에서 사이즈 변화 가능하기 때문에 밖에서 사이즈 미리 저장
				int size = stack.size(); 
				for (int j = 0; j < size; j++) {
					//스택안 보다 num이 더 클 경우
					if (stack.peek()[1] < input[i][1]) {
						stack.pop();

						if (stack.isEmpty()) {
							// 나보다 높은 애들이 없으면
							build[i] = 0;
							break;
						}
					} 
					// 다음 비교에서 스택안이 더 클 경우
					else{ 
						build[i] = stack.peek()[0];
						break;
					}
				}
				// 자신을 저장
				stack.push(input[i]);
			}
		}
		for (int x : build) {
			System.out.print(x + " ");
			Arrays.fill(build, 1);
		}
	
	}

}
