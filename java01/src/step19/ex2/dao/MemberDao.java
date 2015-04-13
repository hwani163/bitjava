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
import step19.ex2.util.DBConnectionPool;

//Connection 관리기법
/*
 * 2단계  : DBConnectionPool 도입!
 *            SQL 작업을 수행할 때 마다. DBConnectionPool에서 Connection객체를 빌린다.
 *            =>사용후 반납한다.
 * 
 *       
 */
public class MemberDao {
  DBConnectionPool dbPool;
  Connection con;

  public MemberDao(DBConnectionPool dbPool) {
    this.dbPool = dbPool;
  }


  public void destroy() {
    try {con.close();} catch (SQLException e) {}

  }

  public void insert(final User user) {
    Connection con = null;
    PreparedStatement stmt = null;

    try {
      con = dbPool.getConnection(); //DB Connection Pool 에서 Connection객체를 빌린다.
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
      dbPool.returnConnection(con); //다른 sql작업에서 사용할 수 있도록 반납한다,
      try {stmt.close();} catch (Exception e) {}
    }
  }

  public ArrayList<User> selectList() {
    Connection con = null;

    ArrayList<User> list = new ArrayList<User>();
    Statement stmt = null;
    ResultSet rs = null;

    try {
      con = dbPool.getConnection();
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
   
    catch (SQLException e) {throw new DaoException(e);} 
    finally {
      dbPool.returnConnection(con);
      try {rs.close();} catch (Exception e) {}
      try {stmt.close();} catch (Exception e) {}
    }

  }

  public User select(int no) {
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
      con = dbPool.getConnection();
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
      dbPool.returnConnection(con);
      try {rs.close();} catch (Exception e) {}
      try {stmt.close();} catch (Exception e) {}
    }
  }

  public int delete(int no) {
    Connection con = null;
    PreparedStatement stmt = null;

    try {
      con = dbPool.getConnection();
      stmt = con.prepareStatement("DELETE FROM USERS WHERE UNO = ?");
      stmt.setInt(1, no);
      return stmt.executeUpdate();

    } catch (SQLException e) {
      throw new DaoException(e);

    } finally {
      dbPool.returnConnection(con);
      try {stmt.close();} catch (Exception e) {}
    }
  }

  public int update(User user) {
    Connection con = null;
    PreparedStatement stmt = null;

    try {
      con = dbPool.getConnection();
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
      dbPool.returnConnection(con);
      try {stmt.close();} catch (Exception e) {}
    }

  }

}
