package com.ssafy.subjectTest;

import java.util.Arrays;
import java.util.Collections;

public class SortTest {

	public static void main(String[] args) {

		int[] arr = {4,2,6,1,8};
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);//오름차순
		System.out.println(Arrays.toString(arr));
		
		Integer[] arr1 = {4,2,6,1,8};
		Arrays.sort(arr1,Collections.reverseOrder()); // 내림차순
		System.out.println(Arrays.toString(arr1));
		
		System.out.println();
		
		String[] srr = {"xds", "atr","dsj","ppp"};
		System.out.println(Arrays.toString(srr));
		Arrays.sort(srr); // 오름차순
		System.out.println(Arrays.toString(srr)); 
		Arrays.sort(srr, Collections.reverseOrder()); // 내림차순
		System.out.println(Arrays.toString(srr));
		
		System.out.println();
		
		A[] aarr = {new A("xx",7), new A("abc",9), new A("bbb",5), new A("ttt",6)};
		System.out.println(Arrays.toString(aarr));
		Arrays.sort(aarr);// 오름차순
		System.out.println(Arrays.toString(aarr));
		Arrays.sort(aarr,Collections.reverseOrder()); // 내림차순
		System.out.println(Arrays.toString(aarr));
		
	}
	static class A implements Comparable<A>{
		String s;
		int i;
		public A(String s, int i) {
			this.s = s;
			this.i = i;
		}
		@Override
		public String toString() {
			return "[" + s + "," + i + "]";
		}
		@Override
		public int compareTo(A o) {
			return this.s.compareTo(o.s);
		}
		
		
	}
}
