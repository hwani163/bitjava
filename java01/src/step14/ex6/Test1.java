package step14.ex6;


/*
 * 예외처리 문법이 필요한이유?
 * 1) 도입전
 * 예외상황을 리턴값으로 호출자에게 전달 하였다. -> 상세 예외 상황을 전달할 수 없다.
 * 작업코드와 예외 처리코드가 마구 섞여 있었다. -> 코드 가독성을 떨어 뜨린다.
 * 심각한 오류인 경우 즉시 프로그램을 멈췄다. ->서버 프로그램에 적합 하지 않다.
 * 도입후
 * 예외 상황을 인스턴스에 담아 리턴한다. -> 상세 정보전달 가능
 * Try ...catch로 작업코드와 예외 처리코드 분리한다. ->가독성이 좋다.
 * 시스템 예외를 잡을 수 있다. ->치명적인 예외가 발생하더라도 시스템을 멈출필요가 없다.
 * 
 * 
 * 예외 객체의 종류
 * Throwable
 *    -Error : JVM이 발생시키는 오류
 *              try catch를 사용하지 않아도 된다.
 *              왜냐하면 어차피 개발자가 처리할 문제가 아니기 때문이다.
 *              try catch 를 사용하여 예외를 처리하든 안하든 컴파일할 때 따지지 않는다.
 *              개발자가 Error예외에 대해서도 try catch를 사용한다면
 *              그것은 프로그램을 종료하기전 기록을 남기기 위함이다.
 *              또는 아주 가벼운 예외 이던가....
 *              개발자가 특별한 경우가 아니면 , Error계열의 예외를 던져서는 안된다.
 *              이것을 "System 예외라고 한다."
 *        -Exception
 *            -RuntimeException : Error의 경우처럼 try..catch를 사용하지 않아도 된다.
 *            왜? 실행중에 발생된 오류로서 예외 상황을 상위 호출자에게 직빵으로 전달하기위해.
 *        
 * 1) Error 계열
 * 2) Exception계열 : 프로그램이 발생 시키는 오류. 개발자가 발생시키는 오류. 
 *                      "Application Exception이라고 한다.
 *                      개발자가 오류의 특별한 상황을 호출자에게 알리기 위해 발생시킴
 *                      ㅎ출자는 반드시 try... catch....를 사용하여 처리해야한다.
 *                      왜? 오류발생했다고 시스템 멈추지 말라! 적절히 처리하고
 *                      계속 실행할 수 있도록 적절히 처리하라는 의미이다.*/
public class Test1 {

  //개발자가 명시적으로 예외 상황에 대해 호출자에게 알린다.
  static int divide(int a , int b) throws Throwable{
    if (b == 0) {
      throw new Throwable("0으로 못나눔");
    }
    return a/b;
  }

//  JVM에서 발생시키는 예외를 던지기
//  Error계열의 예외는 메서드 선언에 어떤 타입의 오류를 던지는지 선언할 필요가 없다.
//  프로그램에서 개발자가 Error를 던지는 경우는 거의 없다. 다음 예는 그냥 테스트를 위해 만든것이다.
  static int divide2(int a , int b) {
    if (b == 0) {
      throw new Error("0으로 못나눔");
    }
    return a/b;
  }
    
  
  public static void main(String[] args) {

      try {
        int result = divide(10, 0);
        
      } catch (Throwable ex) {
        System.out.println(ex.getMessage());
        
      }finally{   //선택블럭입니다. 
//        오류가 나던 안나던 반드시 실행한다.
//        try블록이냐 catch블록을 나가기 전에 반드시 실행
      System.out.println("마무리작업");
    }
      
//      int result = divide2(10,0);
      
//      다음과 같이 명시적으로 try catch를 사용하여 예외를 처리할 수도 있다.
//      =>예외 상황을 기록하고 , 프로그램을 종료하기전에 사용했던 자원을 해제 하기 위하여!
      
      try {
        int r = divide2(10,0);
      } catch (Error e) {
        System.out.println("예외상황기록함....");
      }finally{
        System.out.println("db연결을 해제하거나 네트워크연결을 해제 , File 종료");
      }
  }
}
