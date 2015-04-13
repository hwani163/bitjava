package step19.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 실습목표 : SQL실행하기
 * =>java.sql.Statement 구현체 얻기
 * 
 * 방법 : 5) Connection 구현체에게 Statement 구현체를 요청한다.
 * 6) Connection 구현체는 Statement 구현체를 Return한다.
 * 7) Statement 구현체에게 SQL문을 Server에 보낼것을 요청한다.
 * 8) Statement 구현체는 SQL문을 DBMS에 보내고 실행 결과를 리턴한다.
 * 9) Insert , Update , Delete의 실행결과는 Insert된  Record 개수이다.  Delete된  Record 개수이다.  Update된  Record 개수이다.
 *
 *  */

public class T06_Statement_excuteUpdate {

  public static void main(String[] args) {
    try {
      //1. 드라이버 구현체를 등록한다.
      //   => java.sql.Driver 인터페이스를 구현한 클래스의 인스턴스 주소를 등록한다.
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      System.out.println("MySQL Driver 구현체 등록 완료!");
      
      //2. DB 연결자 얻기
      //DriverManager.getConnection()
      // 첫 번째 파라미터: JDBC URL(DBMS 마다 형식이 약간 다르다)
      // 두 번째 파라미터: DBMS 사용자 아이디
      // 세 번째 파라미터: 암호
      // 리턴 값: java.sql.Connection 구현체 
      Connection con = DriverManager.getConnection(
          //한글 깨지는 경우 다음과 같이 JDBC URL 뒤에 문자 집합에 대한 옵션을 추가한다.
          //"jdbc:mysql://localhost:3306/java67db?useUnicode=true&characterEncoding=utf8", 
          "jdbc:mysql://localhost:3306/java67db", /* DBMS 서버의 주소 및 데이터베이스 연결 정보 */
          "java67", /* 로그인 아이디 */
          "java67"); /* 암호 */
      System.out.println("DBMS 접속 완료!");
      
      //3. SQL 실행자 얻기 
      Statement stmt = con.createStatement();
      System.out.println("SQL 실행자 준비 완료!");
      
      //5. SQL 실행하기
      //classrooms 테이블에 대전-201 교실 정보를 추가한다.
      int count = stmt.executeUpdate(
          "INSERT INTO CLASSROOMS(LOC,ROOM) VALUES('대전','201')");
      
      if (count == 1) {
        System.out.println("교실 정보를 추가하였습니다.");
      }
    } catch (SQLException e) {
      e.printStackTrace(); // 오류에 대한 상세 정보를 콘솔 창에 출력한다.
    }

  }

}
