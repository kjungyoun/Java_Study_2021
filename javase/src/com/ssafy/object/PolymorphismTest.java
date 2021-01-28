package com.ssafy.object;

public class PolymorphismTest {

	public static void main(String[] args) {
		//객체의 다형성 : 부모타입의 변수가 sub의 객체를 참조 할 수 있다.
		Employee emp1 = new Manager(); //자식(manager)안에 부모(employee)가 있다~
		emp1 = new Manager(); // 이 타이밍엔 매니저
		emp1 = new Engineer(); // 이 타이밍엔 엔지니어
		
//		Manager m1 = new Employee(); 컴파일 에러 발생
//		Engineer e1 = new Employee(); 컴파일 에러 발생
//		Manager mgr1 = new Engineer(); 형제끼리도 에러 발생
//		객체의 다형성은 상속을 기반으로 하고있다.
		
//		shadow impact 해결 : down casting
		
		Engineer eng1 = (Engineer)emp1;
//		Manager mgr1 = (Manager)emp1; //부모가 다운캐스팅으로 형변환 - 문법적으로는 가능,컴파일 에러는 없다.
		//but 형변환 할 수 없음 >> runtime error : ClassCastException 발생
		if (emp1 instanceof Manager) {
			Manager mgr2 = (Manager) emp1;
			System.out.println("emp1은 Manager 타입");
			System.out.println("직위 :"+mgr2.getPosition());
		}else if(emp1 instanceof Engineer) {
			Engineer eng2 = (Engineer) emp1;
			System.out.println("emp1은 Engineer 타입");
			System.out.println("스킬:"+eng2.getSkill());
		}
		
		/*
		 * Virtual Invocation (Dynamic Linking)
		 *  - 다형성 관계에서 Overriding된 메서드가 호출된다.
		 */
		
		Manager mgr = new Manager("1111","싸피",5000000, "팀장");
		System.out.println(mgr);
		
		Employee emp3 = new Manager("1111","싸피",10000000, "CEO");
		System.out.println(emp3);
		
		System.out.println("main end");
	}

}
