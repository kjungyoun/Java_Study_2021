package com.ssafy.thread;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyTicker extends Thread{
	private Frame frame;
	private Button startB, suspendB, resumeB, stopB, stateB, exitB;
	private String msg="hello world ssafy!!!!";
	private Label  msgL;
	private ActionListener handler = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource();  //이벤트가 발생된 객체 
			
			//getState()의 상태를 추출 
			if(src == startB) start();
			else if (src == suspendB) suspend();
			else if (src == resumeB) resume();
			else if (src == stopB) isRun = false;
			else if (src == exitB) System.exit(0); // JVM을 정상적으로 종료 시켜 주는 명령
			System.out.println(getState());
		}
	};
	
	private boolean isRun = true;
	
	@Override
	public void run() {
		while(isRun) {
			msg = msg.substring(1) + msg.charAt(0); // 맨 앞쪽의 글자를 맨 뒤로 보냄
			msgL.setText(msg);
			try {
				sleep(300); // 0.3초 동안 쓰레드를 Sleep
			} catch (InterruptedException e) {
				
			}
		}
	}
	
	public MyTicker(ThreadGroup tg) {
		frame = new Frame("Thread 예제");
		
		startB 	= new Button("start");
		suspendB= new Button("suspend");
		resumeB = new Button("resume");
		stopB 	= new Button("stop");
		stateB 	= new Button("state");
		exitB 	= new Button("exit");
		
		Panel south = new Panel();
		south.add(startB);
		south.add(suspendB);
		south.add(resumeB);
		south.add(stopB);
		south.add(stateB);
		south.add(exitB);
		
		startB.addActionListener(handler);
		suspendB.addActionListener(handler);
		resumeB.addActionListener(handler);
		stopB.addActionListener(handler);
		stateB.addActionListener(handler);
		exitB.addActionListener(handler);
		
		msgL = new Label(msg, Label.CENTER);
		frame.add(msgL, "Center");
		frame.add(south,"South");
		frame.setBounds(500, 500, 500, 200);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new MyTicker(null);
		
	}
}








