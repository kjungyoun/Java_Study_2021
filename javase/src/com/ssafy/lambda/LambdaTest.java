package com.ssafy.lambda;

interface LambdaInter{
	public void test();
}

class ExLambda{
	public void useLambda(LambdaInter l) {
		l.test();
	}
}

public class LambdaTest {
	public static void main(String[] args) {
		ExLambda ex = new ExLambda();
		ex.useLambda(()->{
			// 중괄호 안에는 인자가 들어감
			System.out.println("람다 잘되나?");
		});
		
		ex.useLambda(new LambdaInter() {
			
			@Override
			public void test() {
				System.out.println("익명 클래스로 처리하기");
				
			}
		});
	}

}
