package com.ssafy.sort;

import java.util.Arrays;

public class Sort {
	public static void countingSort(int[] list) {
		final int SIZE = list.length;
		// 정렬된 결과를 저장할 배열 생성
		int[] result = new int[SIZE];
		// 입력의 가장 큰 값을 찾기 위한 변수
		int max = Integer.MIN_VALUE;
		// 입력의 최소 값을 구하기 위한 변수 -> 카운팅 배열에서 입력 최소값 이전의 요소들은 모두 0이므로 셀 필요 없음
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < SIZE; i++) {
			min = Math.min(min, list[i]);
			max = Math.max(max, list[i]);
		}
		// 입력 배열 원소의 최대값 표현 가능한 크기의 카운팅 배열 생성
		int count[] = new int[max+1];
		
		// 입력 배열 원소 카운팅
		for (int i = 0; i < SIZE; i++) {
			count[list[i]]++;
		}
		
		// 카운팅 배열 변형 : 누적합
		for (int i = min+1; i <=max; i++) {
			count[i] += count[i-1];
		}
		
		// 입력 배열 원소 하나씩 들여다보며 결과 배열의 각 원소값에 해당하는 위치에 채움
		for (int i = SIZE-1; i >=0; i--) {
			result[--count[list[i]]] = list[i];
		}
		
		// 매개변수로 건내준 배열을 정렬하여 다시 넘겨줌
		// 호출자는 호출하면 당연히 자신이 넘겨준 배열이 정렬되있다고 생각함
		System.arraycopy(result, 0, list, 0, SIZE);
	}
	
	public static void mergerSort(int[] list) {
		mergeSort(list, 0,list.length-1);
	}
	
	private static void mergeSort(int[] list, int start, int end) {
		if(start == end) return; // 나눈 요소가 1개짜리이면 return
		
		int middle = (start+end)/2;
		mergeSort(list,start,middle); // 왼쪽 집합
		mergeSort(list,middle+1, end); // 오른쪽 집합 -> 수행되면 정렬된 상태임
		
		// 정렬된 2 집합을 이용하여 병합
		merge(list,start,middle,end);
	}

	private static void merge(int[] list, int start, int middle, int end) {
		int[] newArr = new int[end - start+1];
		// 왼쪽, 오른쪽의 시작 위치를 저장
		int left = start,right = middle+1;
		int idx = 0; // 결과 배열 인덱스
		
		do {
			if(list[left] < list[right]) {
				newArr[idx++] = list[left++];
			}else {
				newArr[idx++] = list[right++];
			}
		} while (left < middle+1 && right <end+1);
		
		// 오른쪽 집합이 다 소비된 경우.
		while(left < middle+1) {
			newArr[idx++] = list[left++];
		}
		
		// 왼쪽 집합이 다 소비된 경우
		while(right < end +1) {
			newArr[idx++] = list[right++];
		}
		System.arraycopy(newArr, 0, list, start, idx);
	}
}
