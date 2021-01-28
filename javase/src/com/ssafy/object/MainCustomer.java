package com.ssafy.object;

public class MainCustomer extends Customer {
	private String hobby;
	public MainCustomer() {}
	public MainCustomer(String name, String address, int age) {
		setName(name);
		setAddress(address);
		setAge(age); // 공식적으로 부모클래스 private을 접근하는 방법 set
	}
	public MainCustomer(String name, String address, int age, String hobby) {
		this(name, address, age);
		this.hobby = hobby;
	}
	// 부모로부터 toString, setter, getter 상속 받은 상태
	
	/**
	 * Overriding : - 부모로 부터 상속 받은 메서드와 동일한 기능을 제공하지만
	 * 				상세 구현이 조금 다른 경우
	 * 				- 이때, 상속받은 메서드와 (이름, 인자, 리턴타입  = 시그니처)을 동일하게 선언함으로써
	 * 				유지보수성을 높일 수 있다.
	 * 			효과
	 * 				- 메서드 이름과 인자가 같기 때문에 메서드 호출 방법이 부모와 동일하고
	 * 				리턴타입이 같으므로 호출 후에 처리 방법이 동일하다.
	 * 				>>> 기존의 코드를 수정하지 않고 추가된 메서드를 반영시킬 수 있다.
	 * 				- 호출에 대한 편리성 제공
	 * 				>>> super, sub 구별 않고 기능이 같다면 동일한 이름으로 메소드를 호출할 수 있다.
	 * 				- Virtual Invocation에 의해 다형성 관계에서 override된 메서드가 호출됨
	 * 				>>> 기존의 코드를 수정하지 않고 추가된 메서드를 반영시킬 수 있다.
	 * 
	 * Overriding 
	 * 문법 
	 * 		1. 메서드 이름과 인자는 반드시 동일해야 한다.
	 * 		2. 리턴타입
	 * 			- 1.6 ver : 리턴타입은 반드시 동일해야 함
	 * 			- 1.7 ver : 리턴타입은 동일하거나 상속 받은 sub를 리턴.
	 * 				ex) public Customer getCustomer() - super
	 *  
	 * 					public Customer getCustomer() - sub가 override 할때
	 * 					public MainCustomer getCustomer() - sub가 override 할때
	 *					>> 둘 다 컴파일 가능
	 *		3. Access modifier : 같거나 더 넓은 방향 (public 방향)으로 선언해야 한다.
	 * 		4. Exception을 throws할 때 
	 * 			- 부모에서 선언한 동일한 Exception을 throw 하거나
	 * 			- sub를 throw 하거나
	 * 			- throw 안해도 됨. super throw 하면 컴파일 에러남
	 * 
	 * 
	 * super : 부모를 가리키는 지시자 (this는 나 자신)
	 * 			- 메서드 재정의에 의해 무시된 부모의 메서드를 접근할 경우
	 * 			super.메서드명() 으로 접근
	 */
	public String toString() {
		StringBuilder builder = new StringBuilder(super.toString()); 
		builder.append(", hobby=").append(hobby);		
		return builder.toString();
	}
}
