package step20.ex3;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatApp {

  public static void main(String[] args) throws Exception {
    if (args.length==2) {
      runClient(args[0] , Integer.parseInt(args[1]));
    }
    else if(args.length==1){
      runServer(Integer.parseInt(args[0]));
    }
    else {
      System.out.println("프로그램 사용법 : ");
      System.out.println("클라이언트 : ChatApp=> Server주소 포트번호");
      System.out.println("서버 : ChatApp => 포트번호");
    }

  }

  private static void runServer(int port) throws Exception {
    Scanner keyScan = new Scanner(System.in);
    System.out.println("당신의 별명은 무엇 입니까?");
    String allias = keyScan.nextLine();
    
    
    ServerSocket ss = new ServerSocket(8888);
    System.out.println("연결완료");
  Socket socket = ss.accept();
  
  Scanner in = new Scanner(socket.getInputStream());
  PrintStream out = new PrintStream(socket.getOutputStream());
  String input =null;
  String message = null;
  while(true){
   message = in.nextLine();
  System.out.println(message);
  
  input = keyScan.nextLine();
  out.println(allias+" : "+input);
  if (message.endsWith("goodbye")) {
    break;
  }
  }
  in.close();
  out.close();
  socket.close();
  ss.close();
  
}

  private static void runClient(String ip , int port) throws Exception {
    //첫번째로 별명을 입력받기
//    이 별명은 서버에 보낼 메세지에 붙일 것이다.
    Scanner keyScan = new Scanner(System.in);
    System.out.println("당신의 별명은 무엇입니까?");
    String alias= keyScan.nextLine();
    
    
  Socket socket = new Socket(ip,port);  
  System.out.println("상대와 연결됨....");
  
  Scanner in = new Scanner(socket.getInputStream());
  PrintStream out = new PrintStream(socket.getOutputStream());
  String input =null;
  String message =null;
  
  
  while(true){
     input = keyScan.nextLine();
    out.println(alias+ ":" +input);
   message =in.nextLine();
  System.out.println(message);  
  if (input.equals("goodbye")) {
    break;
  }  
  }
  
  in.close();
  out.close();
  
  
  
  socket.close();
  
    
  }

}
