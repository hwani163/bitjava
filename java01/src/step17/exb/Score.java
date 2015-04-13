package step17.exb;

import java.io.Serializable;

/*
 * 직렬화 하기전*/
public class Score implements Serializable {
  /**
	 * 
	 */
	private static final long serialVersionUID = 100L;
String name;
  int kor;
  int eng;
  int math;
  int soc;
  int sci;
  
  public int getSoc() {
	return soc;
}

public void setSoc(int soc) {
	this.soc = soc;
}

public int getSci() {
	return sci;
}

public void setSci(int sci) {
	this.sci = sci;
}

// transient 로 선언된 인스턴스 변수의 값을 직렬화에 포함되지 않는다.
  // 바이트 배열로 만들어지지 않는다. => 파일로 출력되지 않는다.
  transient int total;
  transient float average;
  
  @Override
public String toString() {
	return "Score [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math="
			+ math + ", soc=" + soc + ", sci=" + sci + "]";
}

// 과학 , 사회 점수 추가하여 사용!
  public void compute() {
    total = kor + eng + math+soc+sci;
    average = total / 5f;
  }
  
  // 빈 인스턴스를 생성할 수 있도록 기본 생성자도 만든다.
  public Score() {}
  
  public Score(String name, int kor, int eng, int math , int sci , int soc) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.sci = sci;
    this.soc = soc;
    compute();
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

  public float getAverage() {
    return average;
  }

  public void setAverage(float average) {
    this.average = average;
  }
  
  
  
}
