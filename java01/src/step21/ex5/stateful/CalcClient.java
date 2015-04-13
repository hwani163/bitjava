package step21.ex5.stateful;

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

  static class Expression {
    String op;
    int v1;
    int v2;

    public Expression(String op, int v1, int v2) {
      this.op = op;
      this.v1 = v1;
      this.v2 = v2;
    }

  }// Expression Class End.

  static Expression parseExprStrin(String str) {
    String[] tokens = null;
    tokens = str.split(" ");

    if (tokens.length != 3) {
      if (tokens[0].equals("quit")) {
        return new Expression("quit", 0, 0);
      } else
        return null;
    } else {
      return new Expression(tokens[1], Integer.parseInt(tokens[0]),
          Integer.parseInt(tokens[2]));
    }

  }

  static void requestCompute(Expression expr) {
    Socket socket = null;
    DataInputStream in = null;
    DataOutputStream out = null;
    
    try {
      socket = new Socket("localhost", 8888);
      in = new DataInputStream(socket.getInputStream());
      out = new DataOutputStream(socket.getOutputStream());

      out.writeInt(expr.v1);
      out.writeUTF(expr.op);
      out.writeInt(expr.v2);
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
    Expression expr = null;
    do {
      String intput = prompt();
      expr = parseExprStrin(intput);

      if (expr == null) {
        System.out.println("잘못입력했어");
        continue;
      }
      requestCompute(expr);
    } while (!"quit".equals(expr.op));
  }

}
