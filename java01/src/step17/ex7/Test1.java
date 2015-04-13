package step17.ex7;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/*
 * ObjectOutputStream  / ObjectInputStream 사용하기
 * =>인스턴스의 내용을 출력하기
 * 
 * 1단계 DataOutputStream/DataInputSTream을 사용하여 write하기
 * instance를 출력할 떄마다 각 변수의 값을 꺼내서 출력하게 되니
 * 무척 번거롭다.*/
public class Test1 {
  
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    writeScore();
    readScore();
//    출력할때 오류발생 : Exception in thread "main" java.io.NotSerializableException: step17.ex7.Score
//    왜? 자바는 보안 관계쌍 인스턴스의 데이터를 바이트 배열로 바꾸는 것을 허용하지 안흔ㄴ다.
//    => 그럼? 개발자가 해당 클레스에 대해 바이트 배열로 바꾸는 것을 허락한다고 설정해야 한다.
//    => 코드 ex8패키지를 보세요
    
//    Serialization(직렬화 , 바이트 배열화)
//    Serialize : 바이트 배열로 출력하라 : marshaling
//    Deserializa : 바이트 배열의 값을 인스턴스로 생성하라 : unmarshaling
    
    

  }

  private static void writeScore() throws FileNotFoundException, IOException {
    Score[] scores = {new Score("홍길동",100,100,100),
    new Score("임꺽정",100,100,100),
    new Score("유관순",100,100,100),};
    
    ObjectOutputStream out =new ObjectOutputStream(
                                      new BufferedOutputStream(new FileOutputStream("temp/ex7.test.data")));
    out.writeInt(scores.length);
    
    for (Score score : scores) {
      out.writeObject(score);

      
      
    }
    out.close();
  }
  
//  
  public static void readScore() throws  IOException, ClassNotFoundException {
    ObjectInputStream in =new ObjectInputStream(new BufferedInputStream(new FileInputStream("temp/ex7.test.data")));
    
    int leng = in.readInt();
    Score score =null;
    
    for (int i = 0; i < leng; i++) {
      score = (Score)in.readObject();
      
//          new Score(in.readUTF(),in.readInt(),in.readInt(),in.readInt());
//      
      System.out.println(score);      
    }
    
    in.close();
    
  }
  
    
    
  

}
