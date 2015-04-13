package step19.ex1;
/*
 * 실습목표 : 프로그램 아규먼트를 통해 JDBC 드라이버 이름 지정하기
 * 예) java -classpath ....T03_DriverLoading com.mysql.jdbc.Driver(엔터)*/
import java.sql.SQLException;


public class T03_DriverLoading {
// 드라이버를 로딩하는 또다른 방법!!!!
  public static void main(String[] args) {
    try{
      Class.forName(args[0]);
    System.out.println("MySQL Driver 구현체 등록완료...");
    System.out.println(args[0]);
    
//    이렇게 프로그램을 실행할 때 외부에서 JDBC 드라이버 클래스 이름을 받아서
//    로딩한다면 , 애플리케이션은 특정 DBMS에 종속 되지 않는다.
    }catch(Exception e){
      e.printStackTrace(); //오류에 대한 상세 정보를 consol창에 출력한다.
    }
    
  }

}
