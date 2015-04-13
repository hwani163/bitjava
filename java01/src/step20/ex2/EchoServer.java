package step20.ex2;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


/*
 *
서버 소켓 : 요청을 받는 기능
포트 번호 : 데이터를 주고 받는 소켓을 구분하기 위해 붙이는 고유번호
 => 기존에 자주사용하는 포트번호
 FTP프로토콜  : 21
 Telnet 프로토콜 : 23
 Pop3(이메일) : 110
 HTTP : 80
 HTTP 프록시 : 8080
 결론 : 가능한 기존의 널리사용하는 포트번호는 사용하지 말 것!
 1000이하의 포트번호는 사용하지 말 것!
 1000이상 이라도 8080처럼 널리 사용되는 포트번호는 사용하지말 것!
 * */
public class EchoServer {
  public static void main(String[] args) throws Exception {
//    서버소켓 생성!
    ServerSocket ss = new ServerSocket(8888);
    System.out.println("서버소켓 준비완료.......");

//    2.클라이언트의 연결을 승인하라!
//    =>클라이언트가 연결을 요청하면 대기열(Queue)에 등록된다.
//    대기열에서 첫번째 클라이언트의 연결을 승인한다.
    
    System.out.println("클라이언트 연결을 기다리는중.....");
   //대기열에 클라이언트 정보가 들어 올때 까지 기다린다.( blocking)
    Socket socket = ss.accept();
    System.out.println(socket.getLocalPort()+"클라이언트가 연결됨!");
//   대기열에서 클라이언트 정보를 꺼내는 순간, 클라이언트와의 통신을 담당할 객체를 리턴한다. 
    
    //데이터를 읽고 보내기
    //3. 데이터를 읽고 쓰기위해 입출력 스트림 객체 준비
    Scanner in = new Scanner(socket.getInputStream());
    PrintStream out = new PrintStream(socket.getOutputStream());
    
//    처음에 클라이언트에서 데이터를 보내기 때문에 , 서버에서는 먼저 읽어야한다.
    
    String data = in.nextLine();
    //클라이언트에게 데이터 보내기(Response)
    out.println(data+"석환");
    
    
    //4.데이터 통신을 마친 다음에는 자원을 해제한다.
    in.close();
    out.close();
    //클라이언트 소켓과 연결 끊기
    socket.close();
    //서버소켓 자원해제
    ss.close();
  }

}
