package com.ssafy.subset;

import java.util.Scanner;

public class S1_SubsetTest {
	static int[] input;
	static boolean[] isSelected;
	static int N,totalCnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
		isSelected = new boolean[N];
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		generateSubset(0);
		System.out.println("총 경우의 수 : "+totalCnt);

	}

	
	public static void generateSubset(int cnt) {
		
		if(cnt==N) {
			totalCnt++;
			for (int i = 0; i < N; i++) {
				System.out.print((isSelected[i] ? input[i] : "X")+"\t");
			}
			System.out.println();
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
