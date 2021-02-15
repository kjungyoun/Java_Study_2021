package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1493_수의새로운연산 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine()," ");
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int num = 0;
			int pr=0,pc=0,qr=0,qc=0;
			top:
				for (int i = 1; i <= 300; i++) {
					for (int j = 1,k = i; j <= i; j++,k--) {
						num++;
						if(num == p) {
							pr = j;
							pc = k;
						}if(num == q) {
							qr = j;
							qc = k;
						}
						if(pr != 0 && pc !=0 && qr != 0 && qc !=0) break top;
					}
				}
			
			num = 0;
			top:
				for (int i = 1; i <= 300; i++) {
					for (int j =1,k=i; j <= i; j++,k--) {
						num++;
						if(j == pr+qr && k == pc+qc) break top;							
					}
				}

			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(num);
			System.out.println(sb);
		}

	}

}
