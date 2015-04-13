package step20.ex5.my;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class CalcClient {

  public static void main(String[] args) throws Exception {
    
    /*  실행 순서
     *    0. 키보드 스캔의 준비
     *    1. 서버에 연결
     *    2. 입출력 스트림 준비
     *    3. 사용자로부터 계산 식을 입력 받는다.
     *    4. Server에 전송한다.
     *    5. Server에 응답결과를 출력한다.
     *    6.만약 입력받은 값이 "qui"라면 종료한다.
     *    7.3번으로 간다.
     * */
    Scanner keyScan = new Scanner(System.in);
System.out.println("계산식을 입력하세욧");    
    String request = keyScan.nextLine();
    
//    switch
    
    
    Socket socket = new Socket("localhost",8888);
    Scanner in = new Scanner(socket.getInputStream());
    PrintStream out = new PrintStream(socket.getOutputStream());
    
    
    request.split("+");
    
  }

}
