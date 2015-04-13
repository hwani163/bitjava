package step21.ex5.stateless2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/*
 * ConnectionLess방식으로 서버와 통신
 * => 요청 할 때마다 서버와 연결한다.
 * ==> 특징 - 실행 시간이 더 걸린다.
 *              - 
 *          .*/
public class CalcClient {
  static Scanner keyScan = new Scanner(System.in);

  static String prompt() {
    System.out.print(">");
    return keyScan.nextLine();
  }


  static String toQueryString(String str) {
    String[] tokens = null;
    tokens = str.split(" ");

    if (tokens.length != 3) {
      if (tokens[0].equals("quit")) {
        return  tokens[0];
      } else
        return null;
    } else {
      return"compute?v1="+tokens[0]
                  +Integer.parseInt(tokens[0])
          +Integer.parseInt(tokens[2]);
    }

  }

  static void requestCompute(String query) {
    Socket socket = null;
    DataInputStream in = null;
    DataOutputStream out = null;
    
    try {
      socket = new Socket("localhost", 8888);
      in = new DataInputStream(socket.getInputStream());
      out = new DataOutputStream(socket.getOutputStream());

      
      out.writeUTF(query);
    
      System.out.println(in.readUTF());

    } catch (Exception e) {
      System.out.println("서버와의 통신오류!");
    } finally {
      try {
        in.close();
      } catch (Exception e2) {
      }
      try {
        out.close();
      } catch (Exception e2) {
      }
      try {
        socket.close();
      } catch (Exception e2) {
      }
      try {
        keyScan.close();
      } catch (Exception e2) {
      }

    }

  }

  public static void main(String[] args) {
    String input = null;
    String queryString =null;
    do {
      String intput = prompt();
      queryString = toQueryString(prompt());

      if (queryString == null) {
        System.out.println("잘못입력했어");
        continue;
      }
      requestCompute(queryString);
    } while ((queryString ==null) || !"quit".equals(queryString));
  }

}
