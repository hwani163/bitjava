package step19.ex2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import step19.ex2.DaoException;
import step19.ex2.domain.User;

//Connection 관리기법
/*
 * 1단계  : instance당 한개의 커넥션
 * ==> (1) DAO당 한개의 Connection을 보유한다.
 *            DAO 갯수가 늘수록 Connection 갯수가 증가한다.
 *       (2) 자주사용하지 않는 DAO의 경우 Connection을 낭비하는 문제가 발생한다.
 *       (3) 단일 APP경우 순차적으로 메서드가 호출 되기 때문에
 *             method들 끼리 Connection을 공유하더라도 문제가 되지 않는다.
 *       (4) Server System인 경우 동시에 여러사용자가 Service를 요청하게 되고 
 *            같은 method를 동시에 호출할 수 있다. 
 *            => SQL 작업을 수행중 오류발생하면
 *            같은 Connection을 이용하는 다른 Method에도 영향을 끼친다.
 *            
 * ==>1단계 해결책 : 
 *                          DAO당 1개의 Connection을 갖는것이 아니라 
 *                          SQL작업당 1개의 Connection을 보유하여야 한다.
 *                          => 수만개의 Connection객체?? => no...no... that's no....no....
 *                              -> 대여방식을 통해 커넥션을 공유하기! (Pooling기법!)
 *                          
 *       
 */
public class MemberDao02 {

  Connection con;

  public MemberDao02() {
    try {
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      con = DriverManager
          .getConnection(
              "jdbc:mysql://localhost:3306/java67db?useUnicode=true&characterEncoding=utf8",
              "java67", "java67");

    } catch (SQLException e) {
      throw new DaoException();
    }
  }

  public void destroy() {
    try {con.close();} catch (SQLException e) {}

  }

  public void insert(final User user) {
    PreparedStatement stmt = null;

    try {
      stmt = con
          .prepareStatement("INSERT INTO USERS (NAME,EMAIL,TEL,HP,TWIT) VALUES (?,?,?,?,?)");

      stmt.setString(1, user.getName());
      stmt.setString(2, user.getEmail());
      stmt.setString(3, user.getTel());
      stmt.setString(4, user.getHomepage());
      stmt.setString(5, user.getTwitter());

      stmt.executeUpdate();

    } catch (SQLException e) {
      // RuntimeException 객체에 담아서 예외를 던진다. 이유?
      // - 예외가 발생했다. 근데 너 편한 곳에서 처리해. 너 필요할 때 처리해.
      // 당장 이 메서드를 호출한 곳에서 처리할 필요는 없어.
      throw new DaoException(e); // main쪽에서 처리하기위해 Runtime Exception을 상속받는 새로운
                                 // Exception클래스를 만들었다.

    } finally {
      try {stmt.close();} catch (Exception e) {}
    }
  }

  public ArrayList<User> selectList() {
    ArrayList<User> list = new ArrayList<User>();
    Statement stmt = null;
    ResultSet rs = null;

    try {
      stmt = con.createStatement();

      rs = stmt.executeQuery("SELECT uno,name,email,tel FROM users");

      while (rs.next()) {
        User user = new User();
        user.setNo(rs.getInt("uno"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        user.setTel(rs.getString("tel"));

        list.add(null);
      }

      return list;

    } 
    catch (SQLException e) {throw new DaoException(e);} finally {
      try {rs.close();} catch (Exception e) {}
      try {stmt.close();} catch (Exception e) {}
    }

  }

  public User select(int no) {
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
      stmt = con
          .prepareStatement("SELECT uno,name,email,tel,hp,twit FROM users WHERE uno = ?");
      stmt.setInt(1, no);
      rs = stmt.executeQuery();

      if (rs.next()) {
        User user = new User();
        user.setNo(rs.getInt("uno"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        user.setTel(rs.getString("tel"));
        user.setHomepage(rs.getString("hp"));
        user.setTwitter(rs.getString("twit"));
        return user;

      } else {
        return null;
      }

    } catch (SQLException e) {
      throw new DaoException(e);

    } finally {
      try {
        rs.close();
      } catch (Exception e) {
      }
      try {
        stmt.close();
      } catch (Exception e) {
      }
    }
  }

  public int delete(int no) {
    PreparedStatement stmt = null;

    try {
      stmt = con.prepareStatement("DELETE FROM USERS WHERE UNO = ?");
      stmt.setInt(1, no);
      return stmt.executeUpdate();

    } catch (SQLException e) {
      throw new DaoException(e);

    } finally {
      try {
        stmt.close();
      } catch (Exception e) {
      }
    }
  }

  public int update(User user) {
    PreparedStatement stmt = null;

    try {
      stmt = con
          .prepareStatement("UPDATE USERS SET NAME = ?, EMAIL = ?, TEL = ?, HP = ?, TWIT = ?"
              + " WHERE UNO = ?");
      stmt.setString(1, user.getName());
      stmt.setString(2, user.getEmail());
      stmt.setString(3, user.getTel());
      stmt.setString(4, user.getHomepage());
      stmt.setString(5, user.getTwitter());
      stmt.setInt(6, user.getNo());

      return stmt.executeUpdate();

    } catch (SQLException e) {
      throw new DaoException(e);

    } finally {
      try {
        stmt.close();
      } catch (Exception e) {
      }
    }

  }

}
