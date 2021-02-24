package lab.ssafy.corona.chat;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
	// 모든 Thread를 저장할 리스트
	private ArrayList<ChatThread> chatThreadList = new ArrayList<ChatThread>();
	private int port = 4101;
	
	// 서버를 열기 위한 설정
	public void service() {

		try (ServerSocket ss = new ServerSocket(port);) {

			System.out.println("ChatServer 가 준비되었습니다. 접속 포트는 " + port + " 입니다.");

			while (true) {
				
				// 클라이언트의 접속을 대기
				Socket s = ss.accept();
				System.out.println("ChatClient 가 접속했습니다.");
				// 클라이언트가 접속하면 한 Thread를 할당 및 ThreadList에 담아 관리 
				ChatThread t = new ChatThread(s);
				synchronized (chatThreadList) {
					chatThreadList.add(t);
				}
				t.start();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 전달 받은 메세지를 모든 Thread들에게 뿌림
	public void broadcast( String message ) {
		synchronized (chatThreadList) {
			for( ChatThread t : chatThreadList ){
				try {
					t.sendMessage( message );
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) 	{
		new ChatServer().service();
	}
	
	/*
	 * 한 클라이언트를 의미
	 */
	class ChatThread extends Thread {

		private ObjectInputStream ois;
		private ObjectOutputStream oos;
		private boolean isExit;
		
		public ChatThread(Socket socket) throws Exception {
			// 메세지를 읽고 쓰기위한 InputStream, OutputStream
			this.ois = new ObjectInputStream(socket.getInputStream());
			this.oos = new ObjectOutputStream(socket.getOutputStream());
		}
		
		// Thread 실행시 할 동작들
		public void run() {
			try {
				while ( ! isExit ) {
					String msg = (String) ois.readObject();
					
					// 메세지 종료를 위한 것
					if( "^".contentEquals(msg) ) {
						synchronized (chatThreadList) {
							chatThreadList.remove(this);
						}
						isExit = true;
					}else { // 메세지를 Server로 전달
						broadcast(msg);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				synchronized (chatThreadList) {
					chatThreadList.remove(this);
				}
			}
		}
		
		// 서버에게 전달 받은 메세지를 각 클라이언트에서 화면에 출력
		public void sendMessage(String message) throws Exception {
			oos.writeObject(message);
		}
	}
}

