package com.ssafy.object;

public class Test {

	public static void main(String[] args) {
		String str ="Hello";
		for (int i = 0; i < 2111111111; i++) { 
			// for문을 돌릴 수 있는 최대 크기 = int의 최대 크기 2G
			// 왜냐면 for문의 조건문 인자에 정수밖에 올 수 없기 때문
			str += i;
			System.out.println(str);
		}

	}

}
