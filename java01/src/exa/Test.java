package exa;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * SerialVersionUID 변수의 의미
 * 
 * Serialization = 클래스 정보 + 인스턴스 변수의 값 + (버전)
 * => 클래스 정보 : 객체로 복원할 떄 사용.
 * => 인스턴스 변수의 값
 * => 버전 : 클래스의 변경을 관리하기 위한 숫자값
 * 		버전은 개발자가 관리해야 한다. 자동으로 추가되는 것은 아니다.
 * 		직렬화 할 때 사용한 클래스와 
 * 		복원 할 떄 사용할 클래스가 같은 클래스 인지 검사할 때 사용한다.
 * 		예) .hwp파일을 저장할 때도 파일 형식에 대한 버젼 정보가 기록된다.
 * 			hwp 프로그램이 . hwp파일을 읽을 때 먼저 해당 파일의 버전 번호를 검사하여 읽을 수 있는지 결정한다.
 * 
 * 
 * */
public class Test {
  static void writeScore() throws Exception {
    Score[] scores = {
        new Score("홍길동", 100, 100, 100),
        new Score("임꺽정", 90, 90, 90),
        new Score("유관순", 80, 80, 80)};
    
    ObjectOutputStream out = new ObjectOutputStream(
        new BufferedOutputStream(
            new FileOutputStream("temp/ex7.test.data")));
    
    out.writeInt(scores.length);
    
    for (Score score : scores) {
      // 일부로 치명적인 문제 만들기 => 총점과 평균을 왜곡하기
      // 실행 결과를 보면 총점과 평균이 이런 왜곡된 값으로 그대로 출력되었음을 알 수 있다.
      // => 그럼, 계산 데이터를 바이트 배열로 출력하지 않는 방법은? ex9을 보라!
      score.setTotal(0);
      score.setAverage(10f);
      
      out.writeObject(score);
    }
    
    out.close();
  }
  
  static void readScore() throws Exception {
    ObjectInputStream in = new ObjectInputStream(
        new BufferedInputStream(
            new FileInputStream("temp/ex7.test.data")));
    
    int len = in.readInt();
    
    Score score = null;
    for (int i = 0; i < len; i++) {
      score = (Score)in.readObject();
      score.compute();
      System.out.println(score);
    }
    
    in.close();
  }
  
  public static void main(String[] args) throws Exception {
	  
//	  ex.9Score클래스로 직렬화한 인스턴스의 데이터를
//	  exa.Score 클래스로 읽어들이기
    writeScore();
    readScore();
    
  }

}










