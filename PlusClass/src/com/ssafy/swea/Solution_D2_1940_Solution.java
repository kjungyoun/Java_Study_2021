package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution_D2_1940_Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(inputData));
		
		int T = Integer.parseInt(in.readLine().trim());
		
		for (int tc = 1; tc <= T; tc++) {
			int distance =0, speed=0,cs=0,cmd=0,N =0;
			//데이터 입력 받기
			N = Integer.parseInt(in.readLine().trim());
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine()," ");
				// command 데이터 입력받기
				cmd = Integer.parseInt(st.nextToken());
				// command에 따른 명령 처리
				switch (cmd) {
				// 0: 현재 속도 유지
				case 0:
					break;					
				default:
					// 1, 2 이면 cs 입력 받기
					cs = Integer.parseInt(st.nextToken());
					// 1: speed에 cs 추가하기
					if(cmd==1) {
						speed += cs;
					}else {
						// 2: speed에 cs 감소, 만약에 0미만이면 0으로 처리
						speed = speed>cs ? speed-cs : 0;
					}
					break;
				}
				distance += speed;
			}
			System.out.println("#"+tc+" "+distance);
		}
	}
	static String inputData="10\r\n" + 
			"2\r\n" + 
			"1 2\r\n" + 
			"2 1\r\n" + 
			"3\r\n" + 
			"1 1\r\n" + 
			"0\r\n" + 
			"1 1\r\n" + 
			"5\r\n" + 
			"1 2\r\n" + 
			"1 2\r\n" + 
			"2 1\r\n" + 
			"0\r\n" + 
			"0\r\n" + 
			"8\r\n" + 
			"0\r\n" + 
			"1 2\r\n" + 
			"1 1\r\n" + 
			"0\r\n" + 
			"1 2\r\n" + 
			"2 1\r\n" + 
			"1 1\r\n" + 
			"0\r\n" + 
			"10\r\n" + 
			"1 2\r\n" + 
			"1 1\r\n" + 
			"2 2\r\n" + 
			"1 2\r\n" + 
			"0\r\n" + 
			"0\r\n" + 
			"1 1\r\n" + 
			"1 1\r\n" + 
			"1 2\r\n" + 
			"0\r\n" + 
			"12\r\n" + 
			"1 2\r\n" + 
			"1 1\r\n" + 
			"1 2\r\n" + 
			"2 1\r\n" + 
			"0\r\n" + 
			"1 1\r\n" + 
			"1 1\r\n" + 
			"2 2\r\n" + 
			"2 2\r\n" + 
			"1 1\r\n" + 
			"0\r\n" + 
			"0\r\n" + 
			"15\r\n" + 
			"1 2\r\n" + 
			"1 2\r\n" + 
			"1 2\r\n" + 
			"1 2\r\n" + 
			"1 2\r\n" + 
			"1 2\r\n" + 
			"1 2\r\n" + 
			"1 2\r\n" + 
			"1 2\r\n" + 
			"1 2\r\n" + 
			"1 2\r\n" + 
			"1 2\r\n" + 
			"1 2\r\n" + 
			"1 2\r\n" + 
			"1 2\r\n" + 
			"20\r\n" + 
			"1 2\r\n" + 
			"2 1\r\n" + 
			"0\r\n" + 
			"1 2\r\n" + 
			"0\r\n" + 
			"1 1\r\n" + 
			"2 1\r\n" + 
			"1 2\r\n" + 
			"0\r\n" + 
			"2 1\r\n" + 
			"2 1\r\n" + 
			"0\r\n" + 
			"1 1\r\n" + 
			"0\r\n" + 
			"1 2\r\n" + 
			"1 2\r\n" + 
			"0\r\n" + 
			"1 2\r\n" + 
			"2 2\r\n" + 
			"2 2\r\n" + 
			"25\r\n" + 
			"2 1\r\n" + 
			"2 1\r\n" + 
			"0\r\n" + 
			"0\r\n" + 
			"0\r\n" + 
			"1 2\r\n" + 
			"0\r\n" + 
			"2 2\r\n" + 
			"1 2\r\n" + 
			"2 1\r\n" + 
			"1 1\r\n" + 
			"2 1\r\n" + 
			"0\r\n" + 
			"0\r\n" + 
			"0\r\n" + 
			"1 1\r\n" + 
			"1 2\r\n" + 
			"0\r\n" + 
			"0\r\n" + 
			"1 2\r\n" + 
			"2 2\r\n" + 
			"0\r\n" + 
			"2 2\r\n" + 
			"0\r\n" + 
			"1 1\r\n" + 
			"30\r\n" + 
			"2 1\r\n" + 
			"2 2\r\n" + 
			"2 2\r\n" + 
			"1 1\r\n" + 
			"1 2\r\n" + 
			"2 1\r\n" + 
			"0\r\n" + 
			"1 1\r\n" + 
			"0\r\n" + 
			"0\r\n" + 
			"1 2\r\n" + 
			"1 2\r\n" + 
			"2 1\r\n" + 
			"0\r\n" + 
			"0\r\n" + 
			"2 2\r\n" + 
			"2 1\r\n" + 
			"1 2\r\n" + 
			"0\r\n" + 
			"1 1\r\n" + 
			"2 2\r\n" + 
			"1 2\r\n" + 
			"2 2\r\n" + 
			"0\r\n" + 
			"1 2\r\n" + 
			"2 1\r\n" + 
			"2 2\r\n" + 
			"0\r\n" + 
			"1 1\r\n" + 
			"2 2\r\n" + 
			"";
}
