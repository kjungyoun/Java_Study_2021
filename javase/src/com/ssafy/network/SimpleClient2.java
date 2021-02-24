package com.ssafy.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleClient2 {
	public static void main(String[] args) {
		// localhost 127.0.0.1) : 컴퓨터 내부의 네트워크를 통해 자신의 서버에 통신 요청
		try {
			Socket s = new Socket("1.231.235.240", 4321);
			DataOutputStream dos = null;
			DataInputStream dis = null;
			try {
				dis = new DataInputStream(s.getInputStream());
				dos = new DataOutputStream(s.getOutputStream());

				dos.writeUTF("ㅋㅋㅋ");
				System.out.println(dis.readUTF());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				FileUtil.close(dis);
				FileUtil.close(dos);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
