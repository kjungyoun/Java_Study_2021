package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1940_김정윤 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(in.readLine());
			int distance = 0; // 현재 이동한 거리 저장
			int currSpeed = 0; // 현재 속도 저장
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				int command = Integer.parseInt(st.nextToken());
				if (command == 0) {
					distance += currSpeed;
					continue;
				} else {
					int speed = Integer.parseInt(st.nextToken());
					if (command == 1) { // 가속일 경우
						currSpeed += speed;
					} else if (command == 2) { // 감속일 경우
						if(currSpeed < speed) { // 현재 속도보다 감속 속도가 더 클 경우
							currSpeed = 0;
						}else {
						currSpeed -= speed;
						}
					}
					distance += currSpeed;
				}
			}
			System.out.println("#"+test_case+" "+distance);
		}
	}

}
