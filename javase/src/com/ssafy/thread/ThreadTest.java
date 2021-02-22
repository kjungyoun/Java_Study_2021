package com.ssafy.thread;

public class ThreadTest {

	public static void main(String[] args) {
		System.out.println("Main Start");
		
		MyThread t1 = new MyThread("t1");
		MyThread t2 = new MyThread("t2");
		MyThread t3 = new MyThread("t3");
		
		t1.start();
		t2.start();
		t3.start();
		
//		t1.run();
//		t2.run();
//		t3.run();
		
		System.out.println("Main end .......");

	}

}
