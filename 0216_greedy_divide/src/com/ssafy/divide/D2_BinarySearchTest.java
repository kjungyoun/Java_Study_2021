package com.ssafy.divide;

import java.util.Arrays;

public class D2_BinarySearchTest {

	public static void main(String[] args) {
		int [] arr = {3,11,15,29,20,25,13,21,45};
		// 이진 탐색을 위해선 반드시 정렬해주어야한다.
		Arrays.sort(arr);
		System.out.println(binarySearch(arr,15));
		System.out.println(binarySearch(arr,15,0,arr.length-1));
		System.out.println(Arrays.binarySearch(arr, 15));
		System.out.println(binarySearch(arr,45));
		System.out.println(binarySearch(arr,45,0,arr.length-1));
		System.out.println(Arrays.binarySearch(arr, 0, arr.length, 45));
		System.out.println(binarySearch(arr,15));
		System.out.println(binarySearch(arr,15,0,arr.length-1));
		
		// Arrays.binarySearch : 원소 못찾으면 -insertionpoint-1
		// 즉 여기 쯤 있어야 하는데 라는 위치에 음수를 표기한 것
		// 1을 빼주는 이유는 0과 -0 은 표기가 같기 때문에 0 위치를 표현하기 위함
		// 따라서 예상되는 위치를 출력하기 위해서는 리턴 값에 절대값을 씌운 뒤 -1 을 해준다
		// ex |-3| - 1 = 2 가 있었다면 해당 값이 있었을 위치
		System.out.println(Arrays.binarySearch(arr, 0, arr.length, 14));
		
	}
	
	// 반복을 이용한 이진 탐색
	private static int binarySearch(int arr[] ,int key) {
		int start=0,end = arr.length-1;
		
		while(start<=end) { // while 조건 확인
			int mid = (start + end)/2;
			if(arr[mid] == key) return mid;
			else if(arr[mid]<key) start = mid+1;
			else end = mid-1;
		}
		// 값을 못찾았을 때
		return -1;
	}
	
	// 재귀를 이용한 이진 탐색
	// 재귀는 반복문 안의 내용을 그대로 가져옴
	// 매개변수는 각 반복에서 계속 변하는 값을 받아오는게 핵심
	private static int binarySearch(int arr[], int key,int start, int end) {
		// 못 찾는 경우, 기저조건
		if(start > end)return -1;
		
		int mid = (start + end)/2;
		if(arr[mid] == key) return mid;
		else if(arr[mid]<key) return binarySearch(arr,key,mid+1,end);
		else return binarySearch(arr,key,start,mid-1);
	}

}
