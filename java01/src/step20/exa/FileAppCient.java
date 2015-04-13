package step20.exa;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class FileAppCient {
   

  public static void main(String[] args) throws Exception {
     
      Socket socket = new Socket("localhost",8888);  
    System.out.println("서버소켓과 연결됨....");
    DataInputStream input = new DataInputStream(socket.getInputStream());
    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
     
     System.out.println("파일명 : ");
     Scanner keyScan = new Scanner(System.in);
     String fileURI = keyScan.nextLine();
    
     out.writeUTF(fileURI);
     String inputString = input.readUTF();
     System.out.println(inputString);
     
     File file = new File(fileURI);
     BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file));
     
     long fileSize = file.length();
     System.out.println("파일크기 : "+fileSize);
     out.writeLong(fileSize);    
     
      
     System.out.println("전송준비완료");
     int leng=0;
     while((leng=bin.read())!=-1){
       out.write(leng);
     }
     System.out.println("파일전송완료");
     input.close();
     bin.close();
     out.close();
     socket.close();
    
    
  }

  
}
