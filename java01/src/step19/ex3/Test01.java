package step19.ex3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 목표 : Commit 과 Rollback
 * 1) commit
 *    commit은 임시 데이터 베이스에 저장한 작업결과를 본래의 데이터 베이스에 반영하는것
 *    실습목표 : Commit을 수동으로 Setting한 다음 Insert하기!
 *    => Insert가 되지 않을 것이다. : commit을 하지 않았기 때문이다.
 *    
 *    Commit을 수동으로 Setting하면 어떤일이 일어나는가
 *    -> 데이터를 변경하는 모든작업(Insert , Update  , Delete)는 임시데이터 베이스에 보관된다.
 *    ->개발자가 명시적으로 Commit을 요청해야만 본래 데이터 베이스에 실행 결과를 적용한다.*/
public class Test01 {
  
  
  public static void main(String[] args) {
    try {
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());      
      Connection con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/java67db", 
          "java67", /* 로그인 아이디 */
          "java67"); /* 암호 */
      
      
      con.setAutoCommit(false);
      
      
      Statement stmt = con.createStatement();
      
      int count = stmt.executeUpdate(
          "INSERT INTO CLASSROOMS(LOC,ROOM) VALUES('부산','101')");
      
      if (count == 1) {
        System.out.println("교실 정보를 추가하였습니다.");
      }
    } catch (SQLException e) {
      e.printStackTrace(); // 오류에 대한 상세 정보를 콘솔 창에 출력한다.
    }

  }

}
