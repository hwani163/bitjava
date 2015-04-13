package step17.ex5;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/*
 * Data Processing Stream Class 사용
 *  =>DataOutputStream 클래스 사용법 익히기
 *  
 *  =>java.io 패키지의 클래스들은 기능을 쉽게 확장할 수 있도록 
 *     Decorator 패턴으로 구현되어 있다.
 *     
 *  =>data sink stream 클래스는 작업자 역할을 수행하고 , 
 *      예 : FileOutputStream , FileInputStream , FileReader , FileWriter ...)
 *      data processing stream 클래스는 Decorator 역할을 수행한다.
 *      예 : DataOutputStream/DataInputSTream,
 *            ObjectOutputStream/ObjectOutputStream
 *            BufferdOutputStream/BufferdInputStream...
 * 실습을 통해 알아보자!
 * */
public class Test1 {

  public static void main(String[] args) throws Exception {
    
    int v1 = 1207430;   //0x00126A86
    long v2 = 134504400200L;    //0x1392AB2D4D0
    
    FileOutputStream out = new FileOutputStream("temp/ex5.test1.data");
    
//    데코레이터 붙이기
//    기존의 FileOutputSTream 객체에 기능을 덧붙인다.
//      =int나 long을 바이트로 쪼개서 출력하는 기능을 덧붙인다
    DataOutputStream out2 = new DataOutputStream(out);
    out2.writeInt(v1);
    out2.writeLong(v2);
    
    out2.close();
    out.close();  
//    DataOUtputStream 을 닫으면 자동응로 닫힌다.
    
    
    
  }

}
