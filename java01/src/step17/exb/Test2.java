package step17.exb;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import step17.exb.Score;

/*
 * Score1 클래스의 직렬화 데이터를 Score2클래스를 사용하여 읽기
 * Score2 클래스
 * 
 * 
 * */
public class Test2 {

  
  static void readScore() throws Exception {
    ObjectInputStream in = new ObjectInputStream(
        new BufferedInputStream(
            new FileInputStream("temp/exb.test.data")));
    
    int len = in.readInt(); //출력한 성적데이터의 수 만큼 반복를 읽기
    
    Score score = null;
    for (int i = 0; i < len; i++) {
      score = (Score)in.readObject();
      score.compute(); //총점과 평균을 계산
      System.out.println(score); //간단히 화면에 출력
    }
    
    in.close();
  }
  
  public static void main(String[] args) throws Exception {
	  
//    writeScore(); //국어 영어 수학 점수를 출력한다.
    readScore();	//Score1으로 출력할 데이터를 Score2로 읽기
    
  }

}










