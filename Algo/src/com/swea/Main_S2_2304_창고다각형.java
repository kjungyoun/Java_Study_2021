package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_S2_2304_창고다각형 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(in.readLine());
		int input[][] = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 2차원 배열 정렬
		Arrays.sort(input,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
			
		});
		
		// 스택에 입력
		Stack<int[]> stack = new Stack<int[]>();
		stack.push(input[0]);
		int maxh = input[0][1];		
		boolean isDown = false;
		for (int i = 1; i < N; i++) {
			if(stack.peek()[1] < input[i][1]) {
				if(isDown) {
					while(stack.peek()[1]<input[i][1] && stack.peek()[1] != maxh){
						stack.pop();
					}
					if(stack.peek()[1]<input[i][1]) {
						isDown = false;
					}
					stack.push(input[i]);
					maxh = Math.max(maxh, input[i][1]);
				}else {
					stack.push(input[i]);
					maxh = Math.max(maxh, input[i][1]);
				}
			}else if(stack.peek()[1] == input[i][1]) {
				
				stack.push(input[i]);
			}
			else {
				if(!isDown) {
					isDown = true;
					stack.push(input[i]);
				}else stack.push(input[i]);
			}
		}
		
		//스택에서 출력
		int temp[] = stack.pop();
		int cur = temp[0];
		int height = temp[1];
		int sum =0;
		
		while(!stack.isEmpty()) {
			
			int nextD = stack.peek()[0];
			int nextH = stack.peek()[1];
			if(nextH > height) {
				sum += (cur - nextD) * height;
			}else {
				sum += (cur-nextD) * nextH;
			}
			temp= stack.pop();
			cur = temp[0];
			height = temp[1];
		}
		sum+= height;
		System.out.println(sum);
	}

}
