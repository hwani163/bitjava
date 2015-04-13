package step19.ex1;

import java.sql.DriverManager;
import java.sql.SQLException;

import step10.ex1.E;

/*
 * jdbc프로그래밍
 * 
 * 1.) 프로그래밍 준비
 * 2) JDBC 드라이버 다운로드
 * 3) 프로젝트에 JDBC 드라이버 파일의 위치 등록
 * 패키지 익스플로어의 해당 프로젝트 컨텍스트메뉴 -> 프로퍼티스->자바빌드패스 ->라이브러리스에서 jar파일 추가해주자요
 *  => 컴파일 하고 실행 할 때 사용하기 위해 라이브러리 등록
 *  
 *  2.JDBC 드라이버 사용 준비
 *  => java.sql.Driver 객체를 드라이버 관리자에 등록한다.
 *  드라이버 관리자 : java.sql.DriverManager 클래스
 *  */

public class T01_DriverLoading {

  public static void main(String[] args) {
    try{
    //1. 드라이버 구현체를 등록한다.
//    java.sql.Driver Interface를 구현한 클래스의 Instance 주소를 등록한다
//    =>MySql 드라이버 파일에서 java.sql.Driver인터페이스를 구현한 클래스는 com.mysql.jdbc.Driver
//    =>Oracle 드라이버 파일에서 java.sql.Driver인터페이스를 구현한 클래스는 oracle.jdbc.driver.OracleDriver
//    => MS-Sql 드라이버 파일에서 java.sql.Driver인터페이스를 구현한 클래스는 com.microshoft.sqlserver.jdbc.SqlSererDriver
    
    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
    System.out.println("MySQL Driver 구현체 등록완료...");
    
    }catch(SQLException e){
      e.printStackTrace(); //오류에 대한 상세 정보를 consol창에 출력한다.
    }
    
  }

}
