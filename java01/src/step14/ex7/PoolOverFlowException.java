package step14.ex7;

// Exception에 기능을 추가하거나 인스턴스 변수를 추가하지는 않았지만 , 
// 다음과 같이 자식 Exception클래스를 만들어 사용한다.
// => 클래스 이름자체가 예외 상황을 직관적으로 표현한다.
//=> 예외를 자식 클래스로 정의하면 , 캐치할 때 구분할 수 있다.
public class PoolOverFlowException extends Exception {
//  생성자를 선언하지 않으면
//  다음과 같이 기본 생성자가 자동으로 만들어진다.
//  자동으로 생성된 생성자는 오직 상위 클래스의 기본 생성자만 호출하기 때문이다
  /**
   *   public PoolOverFlowException(){
   *   super();
   *   }
   */

  
  
//  constructor
  public PoolOverFlowException() {
    super();
  }

  public PoolOverFlowException(String message, Throwable cause) {
    super(message, cause);
  }

  public PoolOverFlowException(String message) {
    super(message);
  }
  
//  
}
