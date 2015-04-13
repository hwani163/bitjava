package step17.ex5;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 실습목표 : Buffer기능과 원시 자료형 데이터 출력 기능을 동시에 추가ㅏ하ㅏㅎ하기하ㅏㅎ하
 * 
 *       */
public class Test3 {
public static void main(String[] args) throws Exception {
 
//  System.out.println("버퍼사용");
//testWithBuffer();
//System.out.println("버퍼사용전");
//testWithOutBuffer();
//System.out.println("BuffedInputStream 사용");
testWriting();
testReading();
  
  
}

public static void testWriting() throws Exception{

    DataOutputStream out = new DataOutputStream(
                                        new BufferedOutputStream(
                                             new FileOutputStream("temp/ex5.test3.data")));
    
    out.writeUTF("홍길동");
    out.writeInt(20);;
    out.writeBoolean(false);
    out.writeUTF("111-111");
    
   
  out.close();
}
private static void testReading() throws IOException{
//  BufferdInpuStream 도입
  
  DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("temp/ex5.test3.data")));
  
    String name = in.readUTF();
    int age = in.readInt();
    boolean gender = in.readBoolean();
    String tel = in.readUTF();
    System.out.printf("%s , %d , %b , %s\n",name,age,gender,tel);
 
  
  
  in.close();
}

private static void testWithOutBuffer() throws IOException{
  FileInputStream in = new FileInputStream("temp/jls8.pdf");
  int b =0;
  
  long startTime = System.currentTimeMillis();
  
  while((b=in.read()) != -1){
//       계속읽는다.
  }
  
  long endTime = System.currentTimeMillis();
  
  System.out.printf("경과시간 : %d 밀리초\n" , endTime - startTime);
  in.close();
}
  


private static void testWithBuffer() throws FileNotFoundException, IOException {
  //  버퍼 사용전
  //  pdf는 바이너리파일이다  기본 텍스트 편집기(메모장,vi)로 변경할 수 없다.
       FileInputStream in = new FileInputStream("temp/jls8.pdf");
       byte[] buff = new byte[512];
       int b =0;
       
       long startTime = System.currentTimeMillis();
       
       while((b=in.read(buff)) != -1){
  //       계속읽는다.
       }
       
       long endTime = System.currentTimeMillis();
       
       System.out.printf("경과시간 : %d 밀리초\n" , endTime - startTime);
       in.close();
}
}

