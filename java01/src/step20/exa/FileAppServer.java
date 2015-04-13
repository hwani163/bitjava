package step20.exa;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileAppServer {

  public static void main(String[] args) throws Exception {

    ServerSocket ss = new ServerSocket(8888);
    System.out.println("서버소켓 준비완료.......");
    System.out.println("클라이언트 연결을 기다리는중.....");
    
    Socket socket = ss.accept();
    
    DataInputStream in = new DataInputStream(socket.getInputStream());
    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
    

    String fileName = in.readUTF();
    System.out.println("전송 파일명 : " + fileName);
    System.out.println("파일이 확인되었습니다.");
    out.writeUTF("클라이언트님 파일확인되었어용 ^^ 파일크기 넘기세욧");
    
    
    long  dataSize = in.readLong();
    System.out.println("파일크기 : " + dataSize);
    System.out.println("파일크기가 확인되었습니다.");
    
    
    System.out.println("파일다운로드를 시작합니다.");
    String copyName = "Copy"+fileName;
    System.out.println(copyName);
    
    BufferedOutputStream fileOutput = new BufferedOutputStream(new FileOutputStream(copyName));
    int leng=0;
    while((leng=in.read())!=-1){
      fileOutput.write(leng);
    }
    

    System.out.println("파일다운로드가 완료되었습니다.");
    
    
    
    in.close();
    fileOutput.close();
    socket.close();
    ss.close();

  }

}
