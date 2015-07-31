// 실습전에 준비해야할 테이블
-------------------------------------------------------------------------------------
CREATE TABLE USERS(
  UNO INT NOT NULL,
  NAME VARCHAR(50) NOT NULL,
  EMAIL VARCHAR(100) NOT NULL,
  TEL VARCHAR(20) NOT NULL,
  HP VARCHAR(255) NULL,
  TWIT VARCHAR(20) NULL
);

ALTER TABLE USERS
  ADD CONSTRAINT USERS_PK PRIMARY KEY (UNO);

ALTER TABLE USERS
  MODIFY COLUMN UNO INT NOT NULL AUTO_INCREMENT;
  
  
2. 실습단계 
1) 1단계 : 1개의 method 당 1개의 커넥션
			  MemberDao01 , MemberControl02
2) 2단계 : 1개의 Dao당 1개의 Connection
			  MemberDao02 , MemberControl02
3) 3단계 : DBconnection Pool 도입!!
			 util.DBConnectionPool , MemberDao03 , MemberControl
  