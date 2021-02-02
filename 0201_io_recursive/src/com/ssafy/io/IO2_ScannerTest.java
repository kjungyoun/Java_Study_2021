package com.ssafy.io;

import java.util.Scanner;

public class IO2_ScannerTest {

	public static void main(String[] args) {
			String s1 = "안 \n녕\n";
			Scanner sc = new Scanner(s1);
			// 처음 next는 '안'이라는 문자열을 읽음, 구분자인 공백(space)를 만나기 전까지 읽는다.
			System.out.print("읽은 문자열 : " + sc.next());
			// 다음 next는 공백과 개행(\n)은 읽지 않고 뒤로 넘어가다가 구분자가 아닌 읽을 수 있는 값이 나오면 바로 읽음
			System.out.print(",읽은 문자열 : " + sc.next());
			System.out.println("\n================================");
			
			String s2 = "안 녕\n";
			Scanner sc2 = new Scanner(s2);
			System.out.print("읽은 문자열:"+sc2.nextLine());
			System.out.println("\n================================");
			
			String s3 = "안 \n        녕\n";
			Scanner sc3 = new Scanner(s3);
			System.out.print("읽은 문자열:"+sc3.nextLine());
			System.out.print(",읽은 문자열:"+sc3.nextLine());
			System.out.println("\n================================");
			

	}

}
