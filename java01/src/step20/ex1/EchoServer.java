package step20.ex1;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


/*
 * 실습목표 : 무한적으로 데이터 받기
 * 
 * 대기열 개수 지정하기
 * => 클라이언트에서 대기 가능한 클라이언트 수를 지정한다.
 * => 대기 수를 넘는 클라이언트의 연결은 거절한다.
 *      =>클라이언트는 내부적으로 지정한 타임아웃 동안 계속 서버와의 연결을 시도한다.
 * */
public class EchoServer {
  public static void main(String[] args) throws Exception {
//    두번째 파라미터값이 대기열 갯수이다.
    ServerSocket ss = new ServerSocket(8888,3);
    System.out.println("서버소켓 준비완료.......");
    System.out.println("클라이언트 연결을 기다리는중.....");
    while(true){
    Socket socket = ss.accept();
    Scanner in = new Scanner(socket.getInputStream());
    PrintStream out = new PrintStream(socket.getOutputStream());
    
    //데이터 주고받기
    String data = in.nextLine();
    
    out.println(data+"-from.석환서버-");
    System.out.println(data);
    in.close();
    out.close();
    socket.close();
    }
//    ss.close();
  }

}
