package step17.exb;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import step17.exb.Score;

/*
 * serialVersionUID 변수의 사용법
 * 
 * 개발자가 직접 직렬화 클래스의 버전을 지정한다.
 * 
 * 내용
 * Score1을 Score로 바꾼후 출력한다.
 * 
 * 
 * */
public class Test {
  static void writeScore() throws Exception {/*
	    Score[] scores = {new Score("홍길동",100,100,100),
	    	    new Score("임꺽정",100,100,100),
	    	    new Score("유관순",100,100,100),};
	    	    
	    	    ObjectOutputStream out =new ObjectOutputStream(
	    	                                      new BufferedOutputStream(new FileOutputStream("temp/exb.test.data")));
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










