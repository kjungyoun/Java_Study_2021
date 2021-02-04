package com.ssafy.subset;

/**
 * Sub Set의 개수는 2의 N승 개
 * 특정 원소를 선택했을 때와 안했을 때를 만들 수 있음
 * 0 : 원소를 선택 안했을 경우
 * 1 : 원소를 선택 했을 경우
 * 0 		000		원소를 하나도 선택 안한 경우
 * 1		001		맨 끝의 원소를 선택한 경우
 * 2		010		중간에 원소를 선택한 경우
 * 3		011		끝의 두 원소를 선택한 경우
 * ...
 * 7		111		모든 원소를 선택한 경우
 * 
 * - 결국 Sub Set은 2의 N승에 대해 이진수로 표현하여 구현 가능
 *
 */
public class SubSetTest1 {
	static String[] datas = {"a","b","c","d"};
	static int N = datas.length;
	static int[] subset = new int[N];
	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) { // 첫번째 요소 선택
			subset[0]=i;
			for (int j = 0; j < 2; j++) {	// 두번째 요소 선택
				subset[1] = j;
				for (int k = 0; k < 2; k++) {	// 세번째 요소 선택
					subset[2] = k;
					for (int r = 0; r < 2; r++) {	// 네번째 요소 선택 (하나의 subset 완성)
						subset[3] = r;
						print();
					}
				}
			}
		}

	}

	public static void print() {
		System.out.print("[");
		for(int i = 0; i < N; i++) {
//			System.out.print(subset[i]+" ");
			if(subset[i]==1) System.out.print(datas[i]+" ");
		}
		System.out.println("]");
	}
}
