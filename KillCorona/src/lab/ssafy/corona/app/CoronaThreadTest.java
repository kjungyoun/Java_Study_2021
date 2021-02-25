package lab.ssafy.corona.app;

import lab.ssafy.corona.virus.CoronaThread;

public class CoronaThreadTest {

	public static void main(String[] args) {
		System.out.println("Main Thread Start!!");
		
		CoronaThread thread = new CoronaThread(2020);
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Main Thread End!!");

	}

}