package step21.ex2;

import exa.Test;

/*이너클래스와 아우터클래스의 교류!
 * 중첩 클래스도 바깥 클래스의 멤버이기 때문에 바깥 클래스의 다른 멤버에 접근할 수 있다.*/
public class Test7 {
  
  int value;
  
  class InnerClass{
    int value;
    public void setValue(int v){
//      value = v;
      value = v;
    }
  }
public void m01(int param){
  InnerClass p = new InnerClass();
  p.setValue(param);
  System.out.println(this.value);
}
public static void main(String[] args) {
  Test7 p = new Test7();
  p.m01(1000);
  Test7 p2 = new Test7();
  p2.m01(2000);
}
}
