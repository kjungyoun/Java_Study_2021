package com.ssafy.io;

import java.util.Scanner;

public class IO1_ScannerTest {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("정수,실수,문자열을 차례로 입력하세요.");
			System.out.println("읽은 정수 : " + sc.nextInt());
			System.out.println("읽은 실수 : " + sc.nextDouble());
			// next는 앞 데이터인 Double 다음의 공백을 읽지 않고 문자열 내부의 공백도 포함하지 않는다.
			System.out.println("읽은 문자열 : " + sc.next());
			
			// nextLine은 앞 데이터인 Double 다음의 공백 (tab, space) 들을 전부 읽는다.
			System.out.println("읽은 문자열 : " + sc.nextLine());

	}

}
