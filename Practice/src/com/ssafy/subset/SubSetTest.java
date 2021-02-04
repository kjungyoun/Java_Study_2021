package com.ssafy.subset;

import java.util.Scanner;

public class SubSetTest {
	static int numbers[];
	static int N,totalCount,S;
	static boolean isSelected[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S=sc.nextInt();
		numbers = new int[N];
		isSelected=new boolean[N];
		for (int i = 0; i < N; i++) {
			numbers[i]= sc.nextInt();
		}
		generateSubSet(0);
		System.out.println("총 경우의 수 : "+totalCount);
	}

	
	public static void generateSubSet(int cnt) {
		if(cnt == N) {
			int sum =0;
			int count=0;
			for (int i = 0; i < N; i++) {
				if(isSelected[i]) {
					sum += numbers[i];
					count++;
				}
			}
			if(sum == S && count>0) {
				for (int i = 0; i < N; i++) {
					if(isSelected[i]) System.out.print(numbers[i]+" ");
				}
				totalCount++;
				System.out.println();
			}
			return;
		}
		isSelected[cnt] = true;
		generateSubSet(cnt+1);
		isSelected[cnt]=false;
		generateSubSet(cnt+1);
	}
}
