package com.beak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S5_10157_자리배정_sol {
	
	/**
	 * 자리배정, 달팽이 사각
	 * 완전탐색, 수학
	 * 좌표계가 평소 사용하는 배열과 다르다.
	 * C열 R행 입력순서 주의
	 * 좌표 (열,행) 으로 표시하고 있음
	 * 0,0 -> 1,1 부터 시작! => 1,1을 0,0에 대응시켜서 풀거나 배열의 크기를 1 더 크게 선언하여 0쪽 배열을 쓰지 않는 방법
	 * y 축 방향이 반대
	 * 출력 (열, 행)
	 * @throws IOException 
	 */
	
	public static void main(String[] args) throws IOException {
		// 입력이 두 줄 이상이거나 2개 이상이면 BufferedReader가 무조건 이득이다.
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(in.readLine());
		
		int[][] m = new int[R][C];
		int r = 0;
		int c = 0;
		int num = 1;
		int last = R*C; // 마지막 숫자
		
		if(K > last) {
			System.out.println(0);
			return;
		}
		
ex:		while(true) { // 하, 우, 상, 좌
			for (int i = 1; i < R; i++) { // 하
				if(num == K) {
					System.out.println((c+1) + " " + (r+1)); // 최종 출력시 +1, (c,r)로 출력
					break ex;
				}
				m[r][c] = num;
				r++; num++;
			}
			for (int i = 1; i < C; i++) { // 우
				if(num == K) {
					System.out.println((c+1) + " " + (r+1)); // 최종 출력시 +1, (c,r)로 출력
					break ex;
				}
				m[r][c] = num;
				c++; num++;
			}
			for (int i = 1; i < R; i++) { // 상
				if(num == K) {
					System.out.println((c+1) + " " + (r+1)); // 최종 출력시 +1, (c,r)로 출력
					break ex;
				}
				m[r][c] = num;
				r--; num++;
			}
			for (int i = 1; i < C; i++) { // 좌
				if(num == K) {
					System.out.println((c+1) + " " + (r+1)); // 최종 출력시 +1, (c,r)로 출력
					break ex;
				}
				m[r][c] = num;
				c--; num++;
			}
			r++; c++; // 안쪽 사이클 시작 위치로 이동
			R -= 2; C -= 2;
		}
	}

}
