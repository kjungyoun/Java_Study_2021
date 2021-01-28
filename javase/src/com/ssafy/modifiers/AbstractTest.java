package com.ssafy.modifiers;

import java.util.Calendar;

abstract class Animal {
	String name;
	String kind;
	int age;
	Animal(){}
	
	public Animal(String name, String kind, int age) {
		this.name = name;
		this.kind = kind;
		this.age = age;
	}
	public abstract void bark();
	public abstract void special();
}

class Dog extends Animal{
	// sub 클래스는 반드시 추상 메서드를 override 해야한다.
	public Dog() {
		super();
	}
	public Dog(String name, String kind, int age) {
		super(name, kind, age);
	}
	public void bark() {
		System.out.println("멍멍");
	};
	public void special() {
		keep();
	}
	public void keep() {
		int time = Calendar.getInstance().get(Calendar.HOUR);
		if (time>=9 && time<18) {
			System.out.println("잘 지키고 있어요.");
		}else {
			System.out.println("나도 좀 쉽시당~~");
		}
	}
}

class Duck extends Animal{
	public Duck() {
		super();
	}
	public Duck(String name, String kind, int age) {
		super(name, kind, age);
	}
	public void bark() {
		System.out.println("꽥꽥");
	};
	public void special() {
		fly();
	}
	public void fly() {
		if(kind != null && kind.equals("집오리")) {
			System.out.println("오리는 날 수 없다 엄마에게 혼났죠~~");
		}else {
			System.out.println("날아올라 이렇게 멋진 날개를 펴 꿈을 꾸어요, 난 날아올라~~");
		}
	}
}
public class AbstractTest {

	public static void main(String[] args) {
//		Animal ani = new Animal(); 추상 클래스로 객체 생성 불가

//		추상 클래스에 다형성을 적용
		Animal dog = new Dog("몽", "진돗개", 1);
		
//		추상 클래스는 배열 객체를 생성할 수 있다.
		Animal[] animal = new Animal[2];
		animal[0] = new Dog();
		animal[1] = new Duck("채리필터", "집오리", 20);
		
		for(Animal ani : animal) {
			ani.bark();
//			if(ani instanceof Dog) {
//				Dog d = (Dog) ani; //형변환
//				d.keep();
//			}else if (ani instanceof Duck) {
//				Duck duck = (Duck) ani; //형변환
//				duck.fly();
//			}
			ani.special();
		}
	}
}
