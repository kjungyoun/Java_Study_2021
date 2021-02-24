package lab.ssafy.corona.chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClientSwing extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JTextArea textArea;
    private JTextField inputTextField;
    private JButton sendButton;

    private ChatConnect chatConnect;
    private String name;

    public ChatClientSwing(String ip, int port) {
    	chatConnect = new ChatConnect( this, ip, port, name);
    	createUI();
    }
    
    public ChatConnect getChatConnect() {
    	return chatConnect;
    }
    
    
    /*
     * UI를 생성하는 코드
     */
    private void createUI() {
        textArea = new JTextArea(20, 50);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        Box box = Box.createHorizontalBox();
        add(box, BorderLayout.SOUTH);
        inputTextField = new JTextField();
        sendButton = new JButton("Send");
        box.add(inputTextField);
        box.add(sendButton);

		ActionListener sendListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// 사용자 입력 값 
				String str = inputTextField.getText();
				if ( str != null && str.trim().length() > 0 ) {
					// 서버쪽으로 메세지 전달
					chatConnect.send(str);
					
				}
				inputTextField.selectAll();
				inputTextField.requestFocus();
				inputTextField.setText("");
			}
		};
        
        inputTextField.addActionListener(sendListener);
        sendButton.addActionListener(sendListener);

        this.addWindowListener(new WindowAdapter() {
        	
        	// 종료 버튼을 누르면 동작하는 작업을 구현한 메서드
            @Override
            public void windowClosing(WindowEvent e) {
            	// 종료를 위해 종료 메세지를 서버에 보냄
            	chatConnect.sendExit();
            	
            }
        });
    }
    
    
    // 클라이언트의 화면에 서버에서 받은 메세지를 출력함
    public void updateChat(String message) {
    	textArea.append(message);
        textArea.append("\n");
    }
}