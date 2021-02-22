package com.ssafy.thread;

public class MyThread extends Thread {
	private int i;
	
	/**
	 * @param name 쓰레드 이름
	 * 	쓰레드 이름을 지정하지 않으면 thread-0 부터 순차적으로 부여된다.
	 */
	public MyThread(String name) {
		super(name);
	}
	
	/**
	 * run() : 쓰레드에 의해 병행 처리되는 함수
	 */
	public void run() {
		for (i = 1; i <= 50; i++) {
			// Thread.currenThread() : 현재 코드를 동작 시켜주는 쓰레드를 얻어오기
			System.out.println(Thread.currentThread().getName()+":"+i);
//			try { sleep(300);}catch (Exception e) {}
		}
	}
}










