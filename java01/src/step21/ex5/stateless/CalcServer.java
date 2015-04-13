package step21.ex5.stateless;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 실습목표 : Connectionful 방식의 계산기 서버 만들기
 * 
 * Connectionful (Stateful)
 * =>일단 클라이언트가 연결되면 , 클아이언트에서 연결을 끊을 때 까지
 * =>계속 요청을 처리해준다.
 * 특징
 * 연결은 한번만 이루어지기 떄문에 연결하는데 시간을 낭비하지 않는다.
 * 클라이언트가 계산을 요청하지 않아도 계속 연결을 유지해야 한다.
 * 
 * 
 * ConnectionLess(Stateless)
 * =>계산요청을 할 때 마다 연결하고 , 계산을 수행하고 , 응답하고 , 연결을 끊는다.
 * =>곧 계산을 수행 할 때마다 매번 연결을 수행한다.
 * => 특징 : 
 * 매번 계싼을 요청 할 때마다 연결을 해야 하기 때문에 속도가 지연된다.*/

public class CalcServer {
  public static void main(String[] args) throws Exception {
    ServerSocket ss = new ServerSocket(8888);
    System.out.println("서버 실행중...");
    while (true) {
      service(ss.accept());
    }
  }

  private static void service(Socket socket) throws IOException {
    System.out.println("클라이언트와 연결 되었습니다.");
    DataInputStream in = null;
    DataOutputStream out = null;

    int v1;
    int v2;
    int result = 0;
    String op = null;

    try {
      in = new DataInputStream(socket.getInputStream());
      out = new DataOutputStream(socket.getOutputStream());

      
        
        v1 = in.readInt();
        op = in.readUTF();
        v2 = in.readInt();
        out.writeUTF(compute(v1, v2, op));
      

    } catch (Exception e) {
      System.out.println("클라이언트와 통신 오류!");
    }

    try {
      in.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public static String compute(int v1, int v2, String op) throws IOException {
    int result = 0;
    switch (op) {
    case "+":
      result = v1 + v2;
      break;
    case "-":
      result = v1 - v2;
      break;
    case "*":
      result = v1 * v2;
      break;
    case "/":
      result = v1 / v2;
      break;
    case "quit":
      return "Bye";
    default:
      return "지원하지 않는 연산자 입니다.";
    }
    return "계산결과는 : " + result + "입니다.";
  }
}
