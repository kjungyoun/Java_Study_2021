package com.ssafy;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class ObjectStreamTest {
	
		public static void main(String[] args) {
			File target = new File("c:" + File.separator + "SSAFY" + File.separator + "objPerson.dat");
			Person person = new Person("홍길동", 20, "111111-2222222", "hong", "1234");
			try {
				//객체 저장
//				ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(target));
//				oos.writeObject(person);
//				oos.close();
				
				// 객체 로딩
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(target));
				Object readed = ois.readObject();
				if (readed != null && readed instanceof Person) {
					Person casted = (Person) readed;
					System.out.println(casted);
				}
				ois.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}

class Person implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private transient String ssn;
	
	public Person(String name, int age, String ssn, String userId, String userPass) {
		this.name = name;
		this.age = age;
		this.ssn = ssn;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", ssn=" + ssn	+ "]";
	}
}
