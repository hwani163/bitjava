package step21.ex2;
/*
 * 실습목표 : Inner Class 만들기
 * -> 클래스 안에 클래스를 정의 하는 것.
 * -> 클래스의 사용 범위를 특정 클래스나 블록 안으로 제한 하기 위해서. ( 특정 클래스 안에서만 사용하기 위해서)
 * 
 * 용어정리 : 
 *              package Member Class : 일반적으로 선언하는 클래스
 * Inner클래스의 종류 4가지가 있어욤
 * 1) TopLevel Inner Class
 *    패키지 멤버로 만들기에는 너무 작은 클래스 인 경우 특정 클래스의 inner 클래스로 만든다.
 *    예) 상수 값을 전문으로 정의하는 클래스( 안드로이드에서 많이 사용한다.)
 *    
 * 2) member inner class
 * -> 특정 클래스의 인스턴스에서 사용하는 클래스
 * => 인스턴스를 통해서 생성가능.
 * 
 * 3) local inner class
 * =>특정 메서드에서 사용하는 클랫
 * 
 * 4) anoymous inner class
 * -> 익명클래스이다. 단 한 인스턴스만 필요할 때 사용한다.
 * => 클래스의 이름이 없기때문에 클래스를 정의하자마자 생성하여야 합니다
 * 
 *     => */
public class Test1 {
 
  
  //top level inner class
  static class TopLevelInnerClass{
    
  }
  
  class MemberInnerClass{} //멤버이너클래스
  
  //익명 이너클래스
   
  Object obj = new Object(){};
  
  public void mathod(){
    class LocalInnerClass{}   //로컬 이너클래스
    
    Object obj2 = new Object() {};   //익명 이너클래스
    
  }
  
  
  
  
  public static void main(String[] args) {
    //top Level inner class 사용
//    => static 블록에서는 그냥 사용한다
    TopLevelInnerClass r1 = new TopLevelInnerClass();
    
//    2) Member Inner Class사용
    
    int[] a = new int[3];
    System.out.println(a.length);
  }
  
  

}
