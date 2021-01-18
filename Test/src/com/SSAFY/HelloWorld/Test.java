package com.SSAFY.HelloWorld;

public class Test {

	public static void main(String[] args) {
		int N = 6;
		int result = 0;
		int count = 0;
		while(true) {
			result += (int)(Math.random()*N+1);
			count++;
			if(result>100) break;
		}
		System.out.println(count);
		System.out.println(result);
	}
}
