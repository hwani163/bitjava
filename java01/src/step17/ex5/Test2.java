package step17.ex5;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * 실습목표 : Buffer기능을 수행하는 데이터 프로세싱 Stream Class 데코레이터
 * BufferdInputStream
 * 
 * 내용 : 20~30Mb 크기의 파일을 읽는다.
 * 1) 버퍼 기능을 붙이지 않고 읽어보고 , 
 * 2) 버퍼 기능을 붙여서 읽어본다.
 * 두 작업의 속도 차이를 알아 본다. => BufferdInputStream의 역할을 이해한다.
 * 
 * 데이터 읽기 = 데이터 찾기 시간(data seek time) + 데이터 전송시간(data transfer time)
 * 예) 퀀텀하드디스크
 *      데이터 찾기시간 : 0.0105초
 *      데이터 전송시간 : 0.00000006초
 *      데이터를 전송하는 시간보다 데이터를 찾는 시간이 매우 많이걸린다.
 *      그래서 , 데이터 읽기 속도를 높이여면 , 데이터를 찾았을 때 많이 읽어야 한다.
 *      보통 일정크기의 바이트 배열(Buffer)를 만들어서 read()를 호출할 때 때 왕창 버퍼로 읽는다.
 *       */
public class Test2 {
public static void main(String[] args) throws IOException {
 
  System.out.println("버퍼사용");
testWithBuffer();
System.out.println("버퍼사용전");
testWithOutBuffer();
System.out.println("BuffedInputStream 사용");
testWithDecorator();
  
  
}
private static void testWithDecorator() throws IOException{
//  BufferdInpuStream 도입
  FileInputStream in = new FileInputStream("temp/jls8.pdf");
  BufferedInputStream in2 = new BufferedInputStream(in);
  
  
  int b =0;
  long startTime = System.currentTimeMillis();
//  byte[] buff = new byte[1024];
  while((b=in2.read()) != -1){
//       계속읽는다.
  }
  
  long endTime = System.currentTimeMillis();
  
  System.out.printf("경과시간 : %d 밀리초\n" , endTime - startTime);
  in2.close();
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

