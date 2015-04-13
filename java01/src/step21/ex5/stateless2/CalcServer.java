package step21.ex5.stateless2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 실습목표 : Connectionful 방식의 계산기 서버 만들기
 * 
 * 쿼리스트링을 받아 데이터를 분석.*/

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

    String queryString =null;

    try {
      in = new DataInputStream(socket.getInputStream());
      out = new DataOutputStream(socket.getOutputStream());

      
        
       
      queryString = in.readUTF();
      
      String [] tokens = queryString.split("?");
      if (tokens==null) {
        
      }
       
        out.writeUTF(queryString);
      

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
