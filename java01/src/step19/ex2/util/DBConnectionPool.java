package step19.ex2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/*
FlyWeight 디자인패턴 적용
 1) 객체를 생성하는데 시간이 오래걸린다.
 2) 객체 생성 개수에 제한이 있다.
 =>> 생성한 객체를 공유하여 사용하는 기법! (Fly Weight 디자인패턴 기법)
       Pooling 기법으로 잘려져 있다.

 * */
public class DBConnectionPool {
  
  
  ArrayList<Connection> list = new ArrayList<Connection>();
  
  public DBConnectionPool(){
    try {
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
    } catch (Exception e) {throw new RuntimeException(e);}
  }
  
  public Connection getConnection(){
    //리스트에 con객체가 담겨져 있다면 그것을 지움과동시에 그 객체를 반환
    if (list.size()>0) {
      return list.remove(0);
    }
    else {
      try {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java67db?useUnicode=true&characterEncoding=utf8",
                "java67", "java67");
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
    
  }
  
  public void returnConnection(Connection con){
    try {
      if (!con.isClosed()) {
        list.add(con);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  public void clossAll(){
    for (Connection con : list) {
      try {con.close();} catch (Exception e) {}
    }
  }
  

}
