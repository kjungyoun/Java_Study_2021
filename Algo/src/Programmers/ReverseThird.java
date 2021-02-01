package Programmers;

import java.util.Scanner;

public class ReverseThird {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		 int answer = 0;
	        int count =0; // 3진수 자리수 저장
	        long third=0; // 처음 3진수 저장 -> 테스트케이스가 너무 커서 int형의 크기를 넘어가므로 long형으로 지정
	        long ten = 1;
	        // n을 3진수로 표현
	        while(n!=0){
	        third += (n%3)*ten;
	        n = n/3;
	        ten *= 10;
	        count++;
	        }
	        
	        ten = 1;
	        for( ; count>0; count--) { 
	        	long temp = third;
	        	
	        	for(int j=0; j<count-1;j++) { // 해당 숫자의 맨 앞자리 수를 구함 (반전)
	        		temp /=10;
	        	}
	        	// 맨 앞자리부터 다시 3의 지수승을 곱하면서 반전 구현
	        	answer += temp * ten;
	        	ten *=3;
	        	long k = 1;
	        	
	        	// 해당 수의 맨 앞자리수를 제거하기 위한 구현
	        	for(int j=0;j<count-1;j++) {
	        		k *= 10;
	        	}
	        	third -= temp * k;
	        }
	        System.out.println(answer);

	}

}
