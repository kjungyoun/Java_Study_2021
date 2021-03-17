package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 백준 B2 2605 줄세우기
 */
public class Main_B2_2605 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		LinkedList<Integer> list = new LinkedList<Integer>();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N+1];
		st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++) {
			list.add(Integer.parseInt(st.nextToken()), i);
		}
		for (int i = N-1; i >= 0; i--) {
			System.out.print(list.get(i)+" ");
		}
	}
}
