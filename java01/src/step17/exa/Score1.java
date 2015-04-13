package step17.exa;

import java.io.Serializable;

public class Score1 implements Serializable {
  
/*  특정 인스턴스 변수를 Serialize대상에서 제외하기
 * => 이 인스턴스 변수는 임시적으로 사용하는 값을 용도 이다 라고 선언.*/

  String name;
  int kor;
  int eng;
  int math;
  
  
  transient int total;
  transient float avr;
  
//  transient 로 선언된 인스턴스 변수의 값을 직렬화에 포함되지 않는다.
//  바이트 배열로 만들어지지 않는다.  => 파일로 출력되지 않는다.
//  transient 명령 붙이기
  
  public Score1(){
    
  }
  
//  이 메서드는 deserialize한 후 바로 호출 해야한다.
//  Test클래스 참조하라!
  public void compute(){
    total = kor + eng + math;
    avr = total/3f;
  }
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getKor() {
    return kor;
  }

  public void setKor(int kor) {
    this.kor = kor;
  }

  public int getEng() {
    return eng;
  }

  public void setEng(int eng) {
    this.eng = eng;
  }

  public int getMath() {
    return math;
  }

  public void setMath(int math) {
    this.math = math;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public float getAvr() {
    return avr;
  }

  public void setAvr(float avr) {
    this.avr = avr;
  }

  public Score1(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.total = kor+eng+math;
    this.avr = total/3f;
  }

  @Override
  public String toString() {
    return "Score [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math="
        + math + ", total=" + total + ", avr=" + avr + "]";
  }
  

}
