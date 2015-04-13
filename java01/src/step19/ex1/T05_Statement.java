package step19.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 실습목표 : DB 실행자 얻기
 * =>java.sql.Statement 구현체 얻기
 * 
 * 방법 : 5) Connection 구현체에게 Statement 구현체를 요청한다.
 * 6) Connection 구현체는 Statement 구현체를 Return한다.
 *
 *  */

public class T05_Statement {

  public static void main(String[] args) {
    try{
    //1. 드라이버 구현체를 등록한다.
    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
    System.out.println("MySQL Driver 구현체 등록완료...");
    
//    2.DB 연결자 얻기
//    첫번째 파라미터 : JDBC Url
//    두번째 파라미터 : DBMS사용자 아이디
//    세번째 파라미터 : DBMS사용자 비밀번호
    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/java67db",
        "java67",
        "java67");
    System.out.println("DBMS 접속 완료.....");
//    getConnection()의 리턴값 : java.sql.Connection를 구현한객체를 리턴한다.
    
    
//    3. SQL 실행자 얻기
    Statement stmt = con.createStatement();
    System.out.println("SQL실행자 준비완료...");
    
    }catch(SQLException e){
      e.printStackTrace(); 
    }
    
  }

}
