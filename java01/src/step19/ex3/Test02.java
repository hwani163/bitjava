package step19.ex3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 목표 : Commit 하기
 * COmmit()호출!*/
public class Test02 {
  
  
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
//      임시 데이터 베이스에 있는 결과를 본래 데이터 베이스에 적용 할 것을 요청한다.
      con.commit();
//      Connection객체에 대하여 Commit을 수행하기 때문에 같은 Connection에 연결된 Statement의 작업도 무조건 Commit된다.
//      $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//                                   그래서  한작업당 한개의 Connection을 사용 하여야 한다
//      $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
    } catch (SQLException e) {
      e.printStackTrace(); // 오류에 대한 상세 정보를 콘솔 창에 출력한다.
    }

  }

}
