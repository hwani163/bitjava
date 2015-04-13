package step20.ex2;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/*
 * Client : 먼저 요청하는 쪽
 * Server : 요청 받는 쪽
 * Protocol : 주고받는 데이터 형식*/

public class EchoClient  {
  public static void main(String[] args) throws Exception {

//    192.168.100.39
    //서버 소켓과 연결을 시도한다.
//    서버 소켓과 연결이 되면 통신을 담당할 소켓 객체를 리턴한다.
    Socket socket = new Socket("localhost",8888);  
    System.out.println("서버소켓과 연결됨....");
    //서버소켓과 연결끊기
    
    //데이터를 보내고 받기
    //2. 데이터를 읽고 쓰기 위해 입출력 Stream객체 준비!!
    Scanner in = new Scanner(socket.getInputStream());
    PrintStream out = new PrintStream(socket.getOutputStream());
    
    //3.데이터 보내기 => 데이터를 모두 보낼 떄 까지 리턴하지 않는다. (Blocking)
    out.println("하이하이하이루");
    //줄바꿈문자(Enter)를 포함해서 Data를 보냈다(println이 줄바꿈문자를 포함하겟다는 말이다);
    
    //4. 데이터 받기 !! => 줄바꿈 데이터를 만날 때까지 리턴하지 않는다.(blocking)
    String message =in.nextLine();
    System.out.println("서버가 보낸 메세지!!");
    System.out.println(message);
    
    
//5. 입출력이 끝났으면 닫아라!!    
    in.close();
    out.close();
    
    
    
    //서버소켓과 연결 끊기
    socket.close();
    
  }
}
