package step17.ex3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 실습목표 : int , long값을 출력하기*/
public class Test6 {

  public static void main(String[] args) throws IOException {
    int v1 = 1207430;   //0x00126A86
    long v2 = 134504400200L;    //0x1392AB2D4D0
    
    FileOutputStream out = new FileOutputStream("temp/test6.data");
   

    out.write(v1>>24);
    out.write(v1>>16);
    out.write(v1>>8);
    out.write(v1);
    
    
    out.write((int)(v2>>56));
    out.write((int)(v2>>48));
    out.write((int)(v2>>40));
    out.write((int)(v2>>32));
    out.write((int)(v2>>24));
    out.write((int)(v2>>16));
    out.write((int)(v2>>8));
    out.write((int)v2);
    
    
    
    
    
    out.close();
    
  }
}
