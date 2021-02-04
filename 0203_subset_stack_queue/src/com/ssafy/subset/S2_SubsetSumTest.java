package com.ssafy.subset;

import java.util.Scanner;

public class S2_SubsetSumTest {
	static int[] input;
	static boolean[] isSelected;
	static int N,totalCnt,S;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		input = new int[N];
		isSelected = new boolean[N];
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		generateSubset(0);
		System.out.println("총 경우의 수 : "+totalCnt);

	}

	
	public static void generateSubset(int cnt) {
		// 기저조건
		if(cnt==N) {
			int sum =0;
			int selectedCnt = 0;
			for (int i = 0; i < N; i++) {
				if(isSelected[i]==true) {
					sum += input[i];
					selectedCnt++;
				}
			}
			if(sum == S & selectedCnt>0) {
				totalCnt++;
				for (int i = 0; i < N; i++) {
					if(isSelected[i]) System.out.print(input[i]+"\t");
				}
				System.out.println();
			}
			return;
		}
		// 선택 (여기로 다시 돌아왔을 때는 나의 선택지를 고정한 상태로 뒤에 가능한 모든 선택지를 해본 다음 돌아온 것)
		isSelected[cnt] = true;
		generateSubset(cnt+1);
		//비선택
		isSelected[cnt]=false;
		generateSubset(cnt+1);
		
	}
}
