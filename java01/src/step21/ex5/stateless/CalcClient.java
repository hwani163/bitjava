package step21.ex5.stateless;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;
/*
 * Connectionful 방식으로 서버와 통신
 * => 한번 서버와 연결하면 계속 계산을 요청 할 수 있음.*/
public class CalcClient {

  public static void main(String[] args) {
    Socket socket =null;
    DataInputStream in =null;
    DataOutputStream out =null;
    Scanner keyScan = new Scanner(System.in);
    
    
    try {
      socket = new Socket("localhost",8888);
      in = new DataInputStream(socket.getInputStream());
      out = new DataOutputStream(socket.getOutputStream());
      
      String input =null;
      String [] tokens =null;
      int v1 =0 , v2=0;
      String op ="";
      
      do {
        System.out.print(">");
        input = keyScan.nextLine();
        tokens = input.split(" ");
        if (tokens.length != 3) {
          if (tokens[0].equals("quit")) {
            op ="quit";
          }
          else {
            System.out.println("잘못된 식을 입력하셨습니다.");            
          }
        }else {
          v1 = Integer.parseInt(tokens[0]);
          op=tokens[1];
          v2 = Integer.parseInt(tokens[2]);
        }
        out.writeInt(v1);
        out.writeUTF(op);
        out.writeInt(v2);
        System.out.println(in.readUTF());

        
      } while (!"quit".equals(op));
    } catch (Exception e) {
      System.out.println("서버와의 통신오류!");
    }finally{
      try {in.close();} catch (Exception e2) {}
      try {out.close();} catch (Exception e2) {}
      try {socket.close();} catch (Exception e2) {}
      try {keyScan.close();} catch (Exception e2) {}


    }

  }

}
