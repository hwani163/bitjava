package step14.ex7;

/**특별한 기능은 없다.
 * 오류상황을 직관적으로 파악 할 수 있도록 SubClass를 만든 것이다.*/
public class InvalidIndexException extends Exception {

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
