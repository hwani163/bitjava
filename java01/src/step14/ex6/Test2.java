package step14.ex6;

/*
 * Exception을 사용하여 예외를 호출자에게 전달 하는 경우
 * m3()에서 발생된 예외를 main()에서 처리하려면 , 
 * m1() , m2 () 처럼 중간호출자도 메서드 선언부에 throws문장을 선언하여야 한다.
 * 명확해서 좋지만 ,  호출 단계가 많을 경우 매우 불편하다.
 * 해결책 : RuntimeException을 사용
 * RuntimeException을 사용하는 경우
 *  - 최상위 호출자에게 오류를 쉽게  던지고 싶을떄
 *  - 중간 호출자에게 불편함을 주는 것을 줄이기 위하여*/
public class Test2 {

  static void m1() throws Exception {
    m2();
  }

  static void m2() throws Exception {
    // m3에서 발생한 예외를 main에서 처리하고 싶다면
    // 다음과 같이 try catch를 쓰지마라
    /*
     * try { m3(); } catch (Exception e) { }
     */
    m3();
  }

  /*
   * m3에서 예외를 던진다면 , m2에서 처리해야함 m3에서 예외를 던지지 않는 왜 m2에서?
   *  예외를 처리하여야 하는가 m3 메서드
   * 선언부에 Exception을 던진다고 되어 있기 때문이다. -> 
   * 진짜 예외를 던지고 안던지고 중요하지 않다. 메서드 선언부에 예외를
   * 던진다고 선언했으면 , 호출자는 예외를 처리해야 한다.
   */
  static void m3() throws Exception {
    System.out.println("화이팅 m3()");
  }
  public static void main(String[] args) {
    /**
     * Exception을 사용할 때 불편한 점 실습 m3()에서 발생된 예외를 main()
     */
    try {
      m3();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}
