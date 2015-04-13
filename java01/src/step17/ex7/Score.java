package step17.ex7;

public class Score {

  String name;
  int kor;
  int eng;
  int math;
  int total;
  float avr;
  
//  defalt인스턴스를 생성할 수 있도록 기본 생성자도 만든다.
  public Score(){
    
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

  public Score(String name, int kor, int eng, int math) {
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
