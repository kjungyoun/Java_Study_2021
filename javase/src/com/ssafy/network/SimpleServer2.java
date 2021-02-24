package com.ssafy.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer2 {

	public static void main(String[] args) {
		String[] msg = { "즐거운 네트워크 시간입니다.", "네트워크 수업 재미 있나요?", "날씨가 좀 추워졌어요~ 따뜻하게 입어요!!" };
		try (ServerSocket ss = new ServerSocket(4321)) {
			System.out.println("SimpleServer1 is runnig...");
			while (true) {
				Socket s = ss.accept();
					System.out.printf("[client] : %s 접속\n", s.getInetAddress()); // getInetAddress : 접속한 Client의 주소값

					new Thread() {
						public void run() {
							DataInputStream dis = null;
							DataOutputStream dos = null;
							try {
								dis = new DataInputStream(s.getInputStream());
								dos = new DataOutputStream(s.getOutputStream());

								String readMsg = dis.readUTF();
								int ran = (int) (Math.random() * 3);
								System.out.printf("[%s client] : %s", s.getInetAddress(), readMsg);
								dos.writeUTF("안녕하세요 김정윤 입니다. " + msg[ran]);
							} catch (Exception e) {
								e.printStackTrace();
							} finally {
								FileUtil.close(dis);
								FileUtil.close(dos);
								FileUtil.close(s);
							}
						}
					}.start();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
