package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B1_14696_딱지놀이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(in.readLine());
		round: for (int i = 0; i < N; i++) {
			int A[] = new int[5];
			int B[] = new int[5];
			
			for (int j = 0; j < 2; j++) {
				st = new StringTokenizer(in.readLine());
				int size = Integer.parseInt(st.nextToken());
				for (int k = 0; k < size; k++) {
					if(j==0) {
						A[Integer.parseInt(st.nextToken())]++;
					}else {
						B[Integer.parseInt(st.nextToken())]++;
					}
				}
			}
			
			for (int j = 4; j >0; j--) {
				if(A[j] > B[j]) {
					System.out.println('A');
					continue round;
				}else if (A[j] < B[j]) {
					System.out.println('B');
					continue round;
				}
			}
			System.out.println("D");
		}

	}

}
