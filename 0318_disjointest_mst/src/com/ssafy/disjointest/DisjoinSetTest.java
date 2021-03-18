package com.ssafy.disjointest;

import java.util.Arrays;

public class DisjoinSetTest {
	
	static int N;
	static int parents[];
	
	// 크기가 1인 단위 집합을 만드는 메서드
	static void make() {
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if(parents[a] == a) return a;
//		return findSet(parents[a]); // path compression 전
		return parents[a] = findSet(parents[a]); // path compression 후 
	}
	
	// union의 리턴값은 없어도 되지만 알고리즘 문제를 풀 때 필요한 경우도 있음
	static boolean union(int a, int b) {
		int aRoot = findSet(a); // a 집합의 대표자
		int bRoot = findSet(b); // b 집합의 대표자
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) {		
		N = 5;
		parents = new int[N];
		
		// 1. makeSet 작업을 함
		make();
		
		System.out.println("=======================union======================");
		System.out.println(union(0,1));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(1,2));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(3,4));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(0,2));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(0,4));
		System.out.println(Arrays.toString(parents));
		
		System.out.println("=======================find======================");
		System.out.println(findSet(4));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(3));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(2));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(0));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(1));
		System.out.println(Arrays.toString(parents));
		
		
		
	}

}
