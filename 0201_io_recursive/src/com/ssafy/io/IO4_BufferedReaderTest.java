package com.ssafy.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IO4_BufferedReaderTest {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// IOException은 CheckedException이므로 예외처리를 반드시 해야함 
		int n = Integer.parseInt(in.readLine());
		
		// 줄이 바뀔 때 마다 st = new StringTokenizer를 해야함
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		for (int i = 0; i < n; i++) {
			System.out.println(st.nextToken());
		}

	}

}
