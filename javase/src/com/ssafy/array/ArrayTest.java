package com.ssafy.array;

import java.util.Arrays;

import com.ssafy.object.Customer;

public class ArrayTest {

	public static void main(String[] args) {
		int[] a1 = new int[3];
		System.out.println(Arrays.toString(a1));
		
		// Customer 객체를 담을 배열 객체를 생성
		Customer custs[] = new Customer[3];
		System.out.println(Arrays.toString(custs));
		custs[0] = new Customer(); // 첫 객체를 생성할 때 클래스 area에 클래스 로딩
		System.out.println(custs[0]);
		

	}

}
