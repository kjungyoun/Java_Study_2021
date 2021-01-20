package com.ssafy.array;

import java.util.Arrays;
/**
 * 함수의 인자, 리턴값 전달, 변수에 대입할 때 메모의 값을 전달하는 방식
 * 
 * primitive : 변수를 위한 메모리에 값이 저장됨
 * reference : 변수를 위한 메모리에 객체를 참조하는 참조값 (hash code)
 *
 */

public class PassbyValue {

	public static void pv1(int[] a) {
		a[0] = 10;
	}
	public static int[] pv2(int[] a) {
		int[] c = new int[a.length];
		for (int i = 0; i < c.length; i++) {
			c[i] = a[i];
		}
		c[0] = 10;
		return c;
	}
	
	public static void main(String[] args) {
		int[] data = {1,2,3};
//		pv1(data);
		int[] change = pv2(data);
		System.out.println(Arrays.toString(data));
		System.out.println(Arrays.toString(change));
	}

}
