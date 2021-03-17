package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S5_10157_자리배정 {
	static int dr[] = { 0, 1, 0, -1 };
	static int dc[] = { 1, 0, -1, 0 };
	static int k, num, C, R, arr[][];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[C][R];
		k = Integer.parseInt(in.readLine());
		num = 1;
		StringBuilder sb = new StringBuilder();

		int nr, nc;
		int r = 0, c = -1, idx = 0;
		while (true) {
			if (num > C * R) {
				System.out.println(0);
				return;
			}
			nr = r + dr[idx];
			nc = c + dc[idx];
			if (nr > -1 && nr < C && nc > -1 && nc < R && arr[nr][nc] == 0) {
				if (num == k) {
					sb.append(nr + 1).append(" ").append(nc + 1);
					System.out.println(sb);
					return;
				}
				arr[nr][nc] = num++;
				r = nr;
				c = nc;
			} else {
				idx = (idx + 1) % 4;
			}
		}
	}

}
