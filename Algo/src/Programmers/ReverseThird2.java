package Programmers;

import java.util.Scanner;

public class ReverseThird2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int answer = 0;
		StringBuilder sb = new StringBuilder();
		
		while(n!=0) {
			// 항상 맨 첫번째에 넣어 자동으로 역순이 되도록 함
			sb.insert(0, n%3);
			n /= 3;
		}
		int third = 1;
		for(int i=0; i<sb.length();i++) {
//			answer += Character.getNumericValue(sb.charAt(i)) * third;
			answer += (sb.charAt(i)-'0') * third;
			third *= 3;
		}
		System.out.println(answer);

	}

}
