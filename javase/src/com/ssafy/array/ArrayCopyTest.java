package com.ssafy.array;

import java.util.Arrays;

public class ArrayCopyTest {

	public static void main(String[] args) {
		int[] src = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		// 1. 배열 크기를 늘리기 - 새 배열 생성 후 복사 
		int[] copy1 = new int[src.length+5];
		System.arraycopy(src, 0, copy1, 0, src.length);
		System.out.println(Arrays.toString(copy1));
		
		int[] copy11 = Arrays.copyOf(src, src.length+5);
		System.out.println(Arrays.toString(copy11));
		
		// 2. 부분 복사
		int[] copy2 = new int[3];
		System.arraycopy(src, 5, copy2, 0, 3);
		System.out.println(Arrays.toString(copy2));
		
		int[] copy21 = Arrays.copyOfRange(src, 5, 8);
		System.out.println(Arrays.toString(copy21));
	}

}
