package step20.ex5.my;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CalcServer {

  public static void main(String[] args)   {
    ServerSocket ss =null;
    Scanner in =null;
    PrintStream out =null;

    try {
      ss = new ServerSocket(9999);
      System.out.println("тодотгол 준비완료.......");
      System.out.println("클라이언트 연결을 기다리는중.....");
     
      Socket socket = ss.accept();
      System.out.println("클라이언트가 연결됨!");
      
     in = new Scanner(socket.getInputStream());
     out = new PrintStream(socket.getOutputStream());
      
      while (true) {
        String request = in.nextLine();
        int calResult = 0;
        if (request.equals("quit")) {
          out.println("goodBye");
          
          break;
        } else {
          String[] formula = request.split(" ");
          
          int first = Integer.parseInt(formula[0]);
          String operator = formula[1];
          int second = Integer.parseInt(formula[2]);
          
          switch (operator) {
          case "+":
            calResult = first + second;
            out.println("석환의 더하기 계산결과입니다 : " + calResult);
            break;
          case "-":
            calResult = first - second;
            out.println("석환서버의 빼기 계산결과입니다 : " + calResult);
            break;
          case "*":
            calResult = first * second;
            out.println("석환서버의 곱하기 계산결과입니다 : " + calResult);
            break;
          case "/":
            if (second != 0) {
              calResult = first / second;
              out.println("석환서버의 나누기 계산결과입니다 : " + calResult);
              break;
            } else {
              out.println("0으로 나눌 수 없습니다.");
              break;
            }
            
          default:
            out.println("이상한거 입력하지마세요.");
            break;
          }
          
        }
        
      }
    } catch (Exception e) {
      // TODO: handle exception
    }
    finally{
      in.close();
      out.close();
      try {ss.close();} catch (IOException e) {
        e.printStackTrace();
      }
    }


  }

}
