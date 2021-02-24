package com.ssafy.network;

import java.io.DataInputStream;
import java.net.Socket;

public class SimpleClient1 {
	public static void main(String[] args) {
		// localhost 127.0.0.1) : 컴퓨터 내부의 네트워크를 통해 자신의 서버에 통신 요청
		try (Socket s = new Socket("1.231.235.240", 4321)){
			try(DataInputStream dis = new DataInputStream(s.getInputStream())){
				
				System.out.println(dis.readUTF());
			}
		} catch (Exception e) {
			
		}
	}
}
