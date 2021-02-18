package com.ssafy.back;

import java.util.Scanner;

public class B1_NQueenTest {
	
	static int ans,N;
	static int[] col;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		col = new int[N+1];
		// 0 퀸은 없지만 우리는 부모로부터 파생해서 유망하지 않으면 갔다가 돌아오는 방식을 했기 때문에 0부터 시작
		setQueen(0);
		System.out.println(ans);

	}
	
	/*
	 * 어느 행에 놓았는지 저장한 행번호 매개변수
	 * 즉 rowNo는 현재 퀸을 의미함
	 */
	public static void setQueen(int rowNo) {
		
		// 유망하지 않다면 돌아가기
		if(!isAvailable(rowNo)) return;
		
		if(rowNo == N) {
			ans++;
			return;
		}
		
		// 자식 노드의 가지를 파생
		for (int i = 1; i <= N; i++) {
			col[rowNo+1] = i;
			setQueen(rowNo+1);
		}
	}
	
	public static boolean isAvailable(int rowNo) {
		
		for (int i = 1; i < rowNo; i++) {
			// 퀸이 서로 위협적인 위치면 false
			if(col[rowNo] == col[i] || Math.abs(col[rowNo]-col[i]) == rowNo-i) return false;
		}
		return true;
	}

}
