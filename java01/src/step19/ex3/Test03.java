package step19.ex3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 목표 : RollBack하기
 * rollBack()호출! => 임시 데이터 베이스에 보관된 작업을 취소한다.*/
public class Test03 {
  
  
  public static void main(String[] args) {
    try {
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());      
      Connection con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/java67db", 
          "java67", /* 로그인 아이디 */
          "java67"); /* 암호 */
      
      
      con.setAutoCommit(false);
      
      
      Statement stmt = con.createStatement();
      
      stmt.executeUpdate(
          "INSERT INTO CLASSROOMS(LOC,ROOM) VALUES('부산','201')");
      stmt.executeUpdate(
          "INSERT INTO CLASSROOMS(LOC,ROOM) VALUES('부산','202')");
      stmt.executeUpdate(
          "INSERT INTO CLASSROOMS(LOC,ROOM) VALUES('부산','203')");
      
     
      con.rollback();     //임시 데이터 베이스에 보관된 작업 결과를 취소한다.
      
      stmt.executeUpdate(
          "INSERT INTO CLASSROOMS(LOC,ROOM) VALUES('부산','301')");
      stmt.executeUpdate(
          "INSERT INTO CLASSROOMS(LOC,ROOM) VALUES('부산','302')");
      stmt.executeUpdate(
          "INSERT INTO CLASSROOMS(LOC,ROOM) VALUES('부산','303')");
      
      con.commit();   //임시 데이터 베이스에 보관된 작업결과를 본래의 데이터 베이스에 적용한다.
      
//      용어!
//        트랜잭션!!!
//      여러개의 작업을 묶어서 한 작업으로 다루고 싶을 때!! , 
//      => 여러개의 작업을 묶은 것을 말한다.
      

    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

}
