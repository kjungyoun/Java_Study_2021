package com.ssafy.modifiers;

class MySingleton{
	private static MySingleton instance;
	private MySingleton() {
		
	}
	public static MySingleton getInstance() {
		if(instance==null)
			instance = new MySingleton();
		return instance;
	}
}

public class SingletonTest {

	public static void main(String[] args) {
		MySingleton s1 = MySingleton.getInstance();
		System.out.println(s1.hashCode());
		
		MySingleton s2 = MySingleton.getInstance();
		System.out.println(s2.hashCode()); // 싱글톤이기 때문에 이미 생성된 객체를 리턴해줌

	}

}
