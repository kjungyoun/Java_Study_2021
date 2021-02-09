package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1206 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int test_case = 1; test_case <= 10; test_case++) {
			int sum = 0; // 조망권을 확보한 세대 수의 합 저장
			int N = Integer.parseInt(in.readLine());
			int [] arr = new int[N];
			st = new StringTokenizer(in.readLine()," ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 2; i < N-2; i++) {
				int min = Integer.MAX_VALUE; // 빌딩의 높이 차이가 가장 적은 값을 저장
				int j=1,count=0;
				while(true) {
					if(i-j>-1 && i+j<N && arr[i]> arr[i-j] && arr[i]> arr[i+j]) { // i번째의 빌딩이 양 옆보다 높을 때
						min = Math.min(arr[i]-arr[i-j], Math.min(min, arr[i]-arr[i+j])); // 왼쪽과의 차이와 오른쪽과의 차이중 가장 최소인 값 저장
						j++;
						count++;
						continue;
					}else if(i-j<0 && count>=2 && i+j<N && arr[i]> arr[i+j]) {
						min = Math.min(min, arr[i]-arr[i+j]);
						j++;
						count++;
						continue;
					}else if(i+j>=N && i-j>-1 && count>=2 && arr[i]> arr[i-j]) {
						min = Math.min(min, arr[i]-arr[i-j]);
						j++;
						count++;
						continue;
					}else { // 자신보다 높은 빌딩이 등장하여 막혔을 경우
						if(count<2) { // 2칸 이상 확보하지 못했을 경우
							min = 0;
							break;
						}else {// 2칸이상 확보했을 경우
							sum += min;
							break;
						} 
					}
				}
			}
			System.out.println("#"+test_case+" "+sum);
		}

	}

}
