package com.ssafy.recursive;

public class R2_ArrayTest {
	
	static int arr[] = {10,20,30};
	
	// 배열의 현재 원소의 출력
	private static void printArray1(int index) {
		if(index >= arr.length) {
			System.out.println();
			return;
		}
		System.out.print(arr[index]+"\t");
		printArray1(index+1); // 나머지 출력은 내 다음 것이 진행하도록 넘김 -> 단위 반복
	}	
	
	static int arr2[][] = {{11,12,13},{20,30,40}};
	
	// 2차원 배열의 현재행 원소를 모두 출력
	private static void printRowArray(int i) {
		if(i >= arr2.length) return;
		for (int j = 0; j < arr2[i].length; j++) {
			System.out.print(arr2[i][j]+"\t");
		}
		System.out.println();
		printRowArray(i+1);
	}
	
	public static void main(String[] args) {
			printArray1(0);
			printRowArray(0);

	}

}
