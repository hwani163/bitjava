package step14.ex8;

/**특별한 기능은 없다.
 * 오류상황을 직관적으로 파악 할 수 있도록 SubClass를 만든 것이다.
 * InvalidIndexException은 Exception을 상속 받는순간 무조건 try catch해줘야 하는데
 * RuntimeException을 상속 받는 순간
 * 예외처리코드를 어디에 둘 것인지 개발자가 선택할 수 있따.
 * 예외처리의 빡빡함을 좀 더 유연하게 할 수 있다.*/
public class InvalidIndexException extends RuntimeException {

  public InvalidIndexException() {
    super();
  }

  public InvalidIndexException(String message, Throwable cause,
      boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public InvalidIndexException(String message, Throwable cause) {
    super(message, cause);
  }

  public InvalidIndexException(String message) {
    super(message);
  }

  public InvalidIndexException(Throwable cause) {
    super(cause);
  }

}
