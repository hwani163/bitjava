package step19.ex1;

import java.sql.SQLException;


public class T02_DriverLoading {
// 드라이버를 로딩하는 또다른 방법!!!!
//예) Class.forName(args[0]);
//지정된 패키지의 클래스를 단순히 로딩한다. 
  public static void main(String[] args) {
    try{

    
      
//      JDBC 드라이버 클래스를 문자열을 사용하여 로딩한다.
//      장점 : 자바코드에서 특정 패키지의 클래스를 사용하지 않는다. =>DBMS 비종속
/*      기존방식문제점(T01) : 
        =>명시적으로 JDBC 드라이버 객체를 생성한다.
        =>자바 코드에서 해당 패키지를 언급핟나. => DBMS에 종속된다.
        이점 : 
          자바코드에서 특정 패키지의 클래스를 사용하지 않는다. => 비종속
          =>엥? 거짓말! 문자열에 mysql클래스라고 되어있네
              하하... 이건그냥 Class.forName()을 사용할 수 있다는 것을 보여주기 위해
              간단히 만든 것임.
              => 그럼 제대로 만든다면?
                  => 프로그램 실행 할 때 프로그램 아규먼트로 받는다.
                  
                  예) Class.forName(args[0]);
                 지정된 패키지의 클래스를 단순히 로딩한다. 
                 
                  =>막연하다 직접 보여달라!
                  T03_DriverLoading.java로 오ㅔㅅ요
                  */
      Class.forName("com.mysql.jdbc.Driver");
    System.out.println("MySQL Driver 구현체 등록완료...");
    
    }catch(Exception e){
      e.printStackTrace(); //오류에 대한 상세 정보를 consol창에 출력한다.
    }
    
  }

}
