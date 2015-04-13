package step16.ch09;

/*
 * 실습목표 : 다중 interface상속받기
 * -> interface는 클래스와 달리 여러개의 interface를 상속 받을 수 있다.
 * 
 * 용어정리
 * 메서드의 형식 => 리턴타입 , 메서드명 , 파라미터타입을 가리킴
 * ->자바언어 : "method signature"
 * ->C언어 : function prototype
 * signature가 다르면 다른 method이다.*/

public class Test3 {

  static interface Battery{
    void charge();
    void dashboard();
  }
  
  static interface Car{
    void accelerate();
    void reduce();
    void stop();
    void dashboard();
  }
  
/*  클래스는 다중 상속이 불가는 하다고 했습니다.
 *  super클래스에 같은 이름의 메서드가 있을 때 그중에서 어떤 메소드를 상속 받아야 할지 
 *  결정할 수 없기 때문이라고 했습니다
 *  위의 Batterty 와 Car도 같은 이름의 메서드가 있습니다.
 *  따라서 두개의 모두 상속 받을 때 충돌이 발생하지 않겠습니까?
 *  
 *  
 *  답변 : interface의 method는 구현하지 않았기 때문에 어떤 method를 상속 받더라도 문제가 없다.
   */
  static interface  ElectricCar extends Battery , Car{
    void aircorn();
  }
  
  
//  다중 인터페이스 구현!
//  질문 :  여러개의 인터페이스를 구현할 떄,
//            그 인터페이스에 같은 형식을 갖는 메서드가 있다면 (예 : void dashBoard()),
//              클래스 에서는 어떻게 해야하나?
  
//  답볍 : 문법적으로 본다면 TeslaCar는 분명히 Battery 규칙을 준수하고 있다.
  
//  특이한 질문: 각 인터페이스의 메서드를 따로 구현하는 방법은 없습니까?
//  평범한 답변: 없다. 구분해서 구현하는 방법 없어 
  static class TeslaCar implements Battery, Car{
    @Override public void accelerate() {}   //Car의 규칙
    @Override public void reduce() {}       //Car의 규칙
    @Override public void stop() {}       //Car의 규칙
    @Override public void charge() {}       //Battery의 규칙
    @Override public void dashboard() {}       //Battery의 규칙 , Car의 규칙    
  }
  
  
  
  public static void main(String[] args) {
    
    

  }

}
