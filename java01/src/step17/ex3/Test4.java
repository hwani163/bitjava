package step17.ex3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Test4 {
  /*
   * 실습 목표 : FileInputStream / FileOutputStream 을 사용하여 문자열 출력하고 읽기
   * -byte stream클래스는 바이트 단위로 데이ㅓ를 읽고 쓴다.
   * - 또한 데이터를 읽고 쓸 때 */
  public static void main(String[] args) throws Exception {
    String str = "ABCabc012?!# $%&가각간";
    FileOutputStream out = new FileOutputStream("temp/test4.data");
    
    out.write(str.getBytes());
    out.close();
    
    FileInputStream in = new FileInputStream("temp/test4.data");
    byte[] buf = new byte[100];
    int len = 0;
    len = in.read(buf);
    
   int b =0;
   int count=0;
   while((b=in.read())!=-1){
     System.out.printf("%d : %s\n",count++,Integer.toHexString(b));
     
     in.close();
   }
  }

}
