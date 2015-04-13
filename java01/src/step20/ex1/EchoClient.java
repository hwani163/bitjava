package step20.ex1;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/*
 * 실습목표 : 키보드에서 입력 받은 문자열을 서버에 보내기*/

public class EchoClient  {
  public static void main(String[] args) throws Exception {
    //키보드 입력 스트림을 스캐너에 연결하기
//    스캐너는 Decorater는 아니지만 Decorater같은 역할을 수행한다.
//    Decorater는 같은 부모를 갖는다. Scanner가 Decorater가 되려면 InputStream의 자식 이어야 한다.    
    Scanner keyScan = new Scanner(System.in);
    Socket socket = new Socket("localhost",8888);  
    System.out.println("서버소켓과 연결됨....");
    Scanner in = new Scanner(socket.getInputStream());
    PrintStream out = new PrintStream(socket.getOutputStream());
    
    
    //키보드에서 읽은 값을 서버에 보낸다.
    String input = keyScan.nextLine();
    out.println(input);
    
    
    
    
    //서버에서 온메세지를 받는다.
    String message =in.nextLine();
    System.out.println("서버가 보낸 메세지!!");
    System.out.println(message);
    
    
    in.close();
    out.close();
    
    
    
    keyScan.close();
    socket.close();
    
  }
}
