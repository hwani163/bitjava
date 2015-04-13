package step17.ex3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


/*
 * 실습 목표 : 바이트 단위로 읽기
 *  - FileInputStream의 사용*/
public class Test2 {

  public static void main(String[] args) throws Exception {
    File file = new File("temp/test.txt");
    FileInputStream in = new FileInputStream(file);
    
    int i = in.read();
    
    System.out.printf(Integer.toHexString(i));
    
     i = in.read();
    
    System.out.printf(Integer.toHexString(i));
    
     i = in.read();
    
    System.out.printf(Integer.toHexString(i));
     i = in.read();
    
    System.out.printf(Integer.toHexString(i));
     i = in.read();
    
    System.out.printf(Integer.toHexString(i));
    
  
  }
  

}
