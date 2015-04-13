package step17.ex3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/*바이트 배열을 출력하고 읽기
 * */
public class Test3 {
  public static void main(String[] args) throws Exception {
//    바이트 배열 출력하기
    byte[] data = {0x11,0x22,0x33,0x44,0x55,0x66};
    FileOutputStream out = new FileOutputStream("temp/test3.data");
    out.write(data);
    
    out.close();
    
//    바이트 배열 읽기
    FileInputStream in = new FileInputStream("temp/test3.data");
    byte[] buff = new byte[100];
    int leng=0;
    leng = in.read(buff);  //바이트 배열을 넘기면 , 데이터를 읽어서 그 배열에 저장하고,
                              //읽은 바이트의 수를 Return한다.
    System.out.println("읽은바이트수 : "+leng);
    for (int i = 0; i < leng; i++) {
      System.out.println(Integer.toHexString(buff[i]));
    }
    in.close();
  
  }
}
