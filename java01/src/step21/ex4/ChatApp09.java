package step21.ex4;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;

// 실습 목표: 채팅 화면 만들기
// => 서버에 연결하기.
// => 서버에 연결되면, 메시지 창에 연결되었다는 안내 문구를 출력한다.

/*
 * ActionEvent
 * => 버튼을 눌렀을 때
 * TextFileld 에서 엔터를 쳤을 때
 * ActionEvent를 발생시키는 객체는 액션 명령을 등록할 수 있따.
 * 액션 명령은 이벤트에 보관하면*/
//
public class ChatApp09 extends Frame implements ActionListener {
  private static final long serialVersionUID = 1L;

  TextField tfServerAddress = new TextField(20);
  Button btnConnect = new Button("Connect");
  TextArea taContent = new TextArea(10, 20);
  TextField tfMessage = new TextField(20);
  Button btnSend = new Button("Send");

  Socket socket;
  Scanner in;
  PrintStream out;
      
  public ChatApp09() {
    super("비트챗");
    
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        try {
          out.println("quit");
          String response = in.nextLine();
          taContent.append(response + "\n");
          
        } catch (Exception ex) {
          // 연결 끊다가 오류 났는데 어쩌라고? 무시!
        } finally {
          try {in.close();} catch (Exception ex) {}
          try {out.close();} catch (Exception ex) {}
          try {socket.close();} catch (Exception ex) {}
        }
        System.exit(0);
      }
    });
    
    // BorderLayout에게 어디에 배치할지 정확하게 알려준다.
    Panel connectPanel = new Panel(new FlowLayout(FlowLayout.LEFT));
    connectPanel.add(tfServerAddress);
    connectPanel.add(btnConnect);
    add(connectPanel, BorderLayout.NORTH);

    add(taContent); // 위치를 지정하지 않으면 BorderLayout.CENTER에 배치한다.

    Panel messagePanel = new Panel(); // 기본 가운데 정렬
    messagePanel.add(tfMessage);
    messagePanel.add(btnSend);
    add(messagePanel, BorderLayout.SOUTH);
    
    btnConnect.addActionListener(this);
    btnSend.addActionListener(this);
    
    
    
    
    
    setSize(300, 400);
    
   
  }
  
  
    
    
   
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnConnect || e.getSource() == tfMessage) {
      try {
        Thread t = new Thread(new Runnable() {
          @Override
          public void run() {
            try {
              taContent.append("서버와 연결되었습니다\n");
              socket = new Socket(tfServerAddress.getText(), 8888);
              in = new Scanner(socket.getInputStream());
              out = new PrintStream(socket.getOutputStream());
              while(true){
              taContent.append(Thread.currentThread().getName()+":"+in.nextLine()+"\n");
            }
            } catch (IOException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
            }
          }
       });
        t.start();
        
        
        
        
            
         
        
        
      } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "서버 연결 실패!");
      }
      
    } else if (e.getSource() == btnSend || e.getSource()==tfMessage) {
      out.println(tfMessage.getText());
      tfMessage.setText("");
      
        
    }
    
  }

  public static void main(String[] args) {
    ChatApp09 chatApp = new ChatApp09();
    
    // chatApp 인스턴스에 들어있는 정보를 바탕으로 
    // OS에게 윈도우를 만들어 달라고 요청하라!
    chatApp.setVisible(true);
    
  }
}









