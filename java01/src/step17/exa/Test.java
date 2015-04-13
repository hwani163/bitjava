package step17.exa;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import step17.exa.Score;

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
 * 실습내용
 * Score1 클래스를 사용하여 출력된 데이터를 Score2 클래스로 읽어 드릴수 있는지 검사해 보자.
 * 단 실습할 때 Score1클래스를 Score로 바꾼후 출력하고,
 * 읽어 드릴때는 Scroe2클래스를 Score로 바꾼후 실행한다.
 * 
 * 
 * */
public class Test {
  static void writeScore() throws Exception {/*
	    Score[] scores = {new Score("홍길동",100,100,100),
	    	    new Score("임꺽정",100,100,100),
	    	    new Score("유관순",100,100,100),};
	    	    
	    	    ObjectOutputStream out =new ObjectOutputStream(
	    	                                      new BufferedOutputStream(new FileOutputStream("temp/exa.test.data")));
	    	    out.writeInt(scores.length); //총 성적 데이터의 수 출력하기 
	    	    
	    	    for (Score score : scores) {
	    	      score.setTotal(0);
	    	      out.writeObject(score); //각 학생의 성적데이터 출력!
	    	    }
	    	    out.close();*/
	    	  }
  
  static void readScore() throws Exception {
    ObjectInputStream in = new ObjectInputStream(
        new BufferedInputStream(
            new FileInputStream("temp/exa.test.data")));
    
    int len = in.readInt(); //출력한 성적데이터의 수 만큼 반복를 읽기
    
    Score2 score = null;
    for (int i = 0; i < len; i++) {
      score = (Score2)in.readObject();
      score.compute(); //총점과 평균을 계산
      System.out.println(score); //간단히 화면에 출력
    }
    
    in.close();
  }
  
  public static void main(String[] args) throws Exception {
	  
    writeScore(); //국어 영어 수학 점수를 출력한다.
//    readScore();
    
  }

}










