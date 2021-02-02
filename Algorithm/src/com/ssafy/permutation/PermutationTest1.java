package com.ssafy.permutation;

/**
 * 반복문을 이용한 순열
 * 원소가 추가될 때 마다 for문의 깊이가 깊어짐
 */
public class PermutationTest1 {

	public static void main(String[] args) {
//		int n =10;
//		int fac =1;
//		for (int i = 1; i <=10 ; i++) {
//			 fac *= i;
//		}
//		System.out.println(fac);
		
		System.out.println("===========================중복 순열==========================");
		int n = 3;
		int cnt = 0;
		for (int i = 1; i <= n; i++) { // 첫번째 원소 선택
			for (int j = 1; j <= n; j++) { // 두번째 원소 선택
				for (int k = 1; k <= n; k++) { // 세번째 원소 선택
					cnt ++;
					System.out.printf("%d %d %d\n",i,j,k);
				}
			}
		}
		System.out.printf("cnt : %d\n",cnt);
		
		System.out.println("===========================순열==========================");
		// 중복 순열에서 중복 체크만 추가해주면 됨
		cnt = 0;
		for (int i = 1; i <= n; i++) { // 첫번째 원소 선택
			for (int j = 1; j <= n; j++) { // 두번째 원소 선택
				if(i != j) { // 이 비교구문 때문에 중복 순열보다 시간이 더 걸린다.
					for (int k = 1; k <= n; k++) { // 세번째 원소 선택
						if(i != k && j != k) {
							cnt ++;
							System.out.printf("%d %d %d\n",i,j,k);							
						}
					}
					
				}
			}
		}
		System.out.printf("cnt : %d",cnt);		
	}

}
