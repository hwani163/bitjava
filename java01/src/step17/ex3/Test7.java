package step17.ex3;

import java.io.FileOutputStream;
import java.io.OutputStream;

// 실습목표 : 도우미 클래스를 사용하여 int , long를 출력하기
// => MyDataOutputStream 클래스는 내부에서 FileOutputStream 클래스를 사용하여
/*int, long 값을 출력한다.
=> 이렇게 출력 중간에 개입하여 데이터를 가공하는 역할을 수행하는 클래스를 Data processing Stream Class라고 한다.*/

public class Test7 {
  static class MyDataOutputStream{
    OutputStream out;
    
    public MyDataOutputStream(OutputStream out){
      this.out = out;
    }
    
    public void writeInt(int v) throws Exception{
      out.write(v>>24);
      out.write(v>>16);
      out.write(v>>8);
      out.write(v);
    }
    
    public void writeLong(long v2)throws Exception{
      out.write((int)(v2>>56));
      out.write((int)(v2>>48));
      out.write((int)(v2>>40));
      out.write((int)(v2>>32));
      out.write((int)(v2>>24));
      out.write((int)(v2>>16));
      out.write((int)(v2>>8));
      out.write((int)v2);
    }
    
    public void close() throws Exception{
      out.close();
    }
  }
  
  public static void main(String[] args) throws Exception {
    int v1 = 1207430;   //0x00126A86
    long v2 = 134504400200L;    //0x1392AB2D4D0
    FileOutputStream out = new FileOutputStream("temp/test6.data");
    MyDataOutputStream out2 = new MyDataOutputStream(out);
    
    
    out2.writeInt(v1);
    out2.writeLong(v2);
    
    out2.close();
    
    
  }
  

}
