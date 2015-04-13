package step14.ex6;


/* RuntimeException을 사용하는 경우
 *  - 최상위 호출자에게 오류를 쉽게  던지고 싶을떄
 *  - 중간 호출자에게 불편함을 주는 것을 줄이기 위하여*/

public class Test3 {

  static void m1()  {
    m2();
  }

//  m2()는 m3가 예외를 던진다고 생각하지 않는다.
//  왜? m3() 선언부에 throws문장이 없기 때문이다.
  static void m2()  {
    m3();
  }


  
  /**
   * RuntimeException은 메서드 선언부에 throws문장에 추가하지 않아도 된다.*/
  
  static void m3() /*throws Exception*/ {
    System.out.println("화이팅 m3()");
    throw new RuntimeException("m3에서 던지는 예외");
  }
  
  
  public static void main(String[] args) {
    /**
     * m3()가 발생시킨 RuntimeException을 받고 싶다면 다음과 같이 try...Catch를 사용한다.
     */
    try {
      m1();
    } catch (RuntimeException e) {
      System.out.println(e.getMessage());
    }
    
//    m3에서 던지는 예외를 받지 않아도 된다. 대신 프로그램은 멈춘다!!!!!
//    결론 : m3가 발생시킨 JVM이 임의적으로 처리하는 것을 막고싶다면 ,
//    바로 위에서 처럼 try catch를 사용하세요!!
//    즉 RuntimeException은 try...catch...를 사용하지 않기 윟 만든 문업이 아니라.
//    중간 호출자가 예외 선언하는 불편을 해소 하기위해 만든 문법이다
//    그러니 최종 호출자에서는 처리하는 것이 좋다.
    m1();

  }

}
