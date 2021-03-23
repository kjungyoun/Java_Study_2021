package com.ssafy.dp;

import java.util.Arrays;
import java.util.Scanner;

public class DP1_MinCoinTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		int[] D = new int[money+1]; // 각 금액에 대한 최소 동전 개수
		
		// D[i-1] , D[i-4], D[i-6]
		// D[0] 값이 항상 사용되기 때문에 D[0]의 값을 미리 셋팅하고 시작
		D[0] = 0; // 0원에 대한 최소 동전 개수 0 -> 굳이 하지 않아도 배열의 초기값은 0이므로 괜찮음
		for (int i = 1; i <= money; i++) {
			int min = Integer.MAX_VALUE;
			// 모든 경우를 다 보아야하기 때문에 if문을 세 번 사용 (else if를 쓰면 안됨)
			if(D[i-1]+1 < min) min = D[i-1]+1;
			if(i>=4 && D[i-4] < min) min = D[i-4]+1;
			if(i>=6 && D[i-6]< min) min = D[i-6]+1;
			
			D[i] = min;
		}
		System.out.println(D[money]);
		System.out.println(Arrays.toString(D));
	}

}
