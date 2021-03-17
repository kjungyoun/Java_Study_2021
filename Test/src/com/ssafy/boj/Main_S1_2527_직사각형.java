package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_2527_직사각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int k = 0; k < 4; k++) {

			StringTokenizer st = new StringTokenizer(in.readLine());
			int s1[] = new int[4];
			int s2[] = new int[4];

			for (int i = 0; i < 4; i++) {
				s1[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < 4; i++) {
				s2[i] = Integer.parseInt(st.nextToken());
			}

			if (s1[1] > s2[3] || s1[3] < s2[1] || s1[0] > s2[2] || s1[2] < s2[0]) {
				System.out.println("d");
			} else if ((s1[1] == s2[3] && (s1[0] == s2[2] || s1[2] == s2[0]))
					|| (s1[3] == s2[1] && (s1[0] == s2[2] || s1[2] == s2[0]))) {
				System.out.println("c");
			} else if ((s1[1] == s2[3]) || (s1[3] == s2[1]) || (s1[0] == s2[2]) || (s1[2] == s2[0])) {
				System.out.println("b");
			} else
				System.out.println("a");
		}
	}

}
