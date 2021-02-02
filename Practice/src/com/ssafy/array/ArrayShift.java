package com.ssafy.array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayShift {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 오른쪽으로 shift
		int temp = 0;
		for (int i = arr.length-1; i >-1; i--) {
			if(i == arr.length-1) {
				temp = arr[i];
			}
			if(i == 0) {
				arr[i] = temp;
				break;
			}
			arr[i] = arr[i-1];
		}
		
		// 왼쪽으로 shift
		for (int i = 0; i < arr.length; i++) {
			if(i==0) {
				temp = arr[i];
			}
			if(i == arr.length-1) {
				arr[arr.length-1] = temp;
				break;
			}
			arr[i] = arr[i+1];
		}
		
		
	System.out.println(Arrays.toString(arr));
	}
}
