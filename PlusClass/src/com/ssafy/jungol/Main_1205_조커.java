package com.ssafy.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1205_조커 {
	static int jocker,N,ans,input[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		input = new int [N];
		ans = Integer.MIN_VALUE;
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			if(input[i] == 0) jocker++;
		}
		
		Arrays.sort(input);
		if(jocker == N) {
			System.out.println(N);
			return;
		}
		search();
		System.out.println(ans);
	}
	
	public static void search() {
		// 조커 이후부터 탐색
		for (int i = jocker; i < N; i++) {
			// 조커를 사용한 수 저장
			int use = jocker;
			int len = 1;
			int prev = input[i];
			int k = i+1;
			boolean first = true;
			while(k<N) {
				int curr = input[k];
				int dif = curr - prev;
				if(dif == 1) {
					len ++;
					k++;
					prev = curr;
					continue;
				}else if (dif == 0) k++; // 자신과 같은 수면 pass
				else { // 차이가 크면
					if(first) {
						i = k-1;
						first = false;
					}
					if(use == 0) break;
					use--;
					len++;
					prev++;
				}
			}
			ans = Math.max(ans, len+use);
		}
		
	}

}
