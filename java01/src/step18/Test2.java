package step18;


/*
 * 실습목표 : table 생성
 * 
 * 데이터베이스 => 데이터를 저장하고 조회하는데 필요한 데이터 파일.
 *                                예) 엑셀의 파일.
 *  테이블 : data를 저장하기위한 형식을 갖춘 틀을 이야기 한다. (예 : 엑셀의 sheet라고 생각하면 쉽다.)
 *  
 *  1.테이블 생성
 *  CREATE  TABLE 테이블명(
 *  컬럼명 타입 [NULL or NOT NULL] , 
 *  컬럼명 타입 [NULL or NOT NULL] , 
 *  컬럼명 타입 [NULL or NOT NULL] , 
 *  컬럼명 타입 [NULL or NOT NULL] , 
 *  );
 *  
 *  
 *  =>  테이블명이나 데이터베이스는 보통
 *        대소문자를 구분하지 않는다.
 *        테이블 이름이나. 컬럼이름을 작성할 때  , CamelCase를 사용하지 않는다.
 *        
 * => DB에서는 firstname = FirstName 같다
 * => 그래서  테이블 이름이나 컬럼이름을 fist_name , last_name
 *        Ex : km_per_hour , cnt_stdu;
 *        
 *        
 * 예1) 간단한 test2 테이블 생성
 *  CREATE TABLE test2(
 * tno INT NOT NULL,
 * title VARCHAR(200) NOT NULL,
 * writer VARCHAR(20));
 * 
 * 
 * 
 * 2. 테이블에 데이터 입력하기 * 
 * INSERT INTO 테이블명(컬럼명 , 컬럼명  , ...) VALUES(값 , 값 , 값...); * 
 * 예)  INSERT INTO test2(tno , title , writer) Values(1,'aaa','hong');
 * 
 * 3. 데이터 조회하기 * 
 * SELECT 컬럼명 fROM 테이블명;
 * 예) SELECT tno,title,writer FROM test2;
 * 
 *  
 * 4. 데이터 변경하기 
 * UPDATE 테이블명 SET (컬럼명)= (변경할값) , (컬럼명) = (변경할 값)
 * WHERE 컬럼명 = 조건;
 * 예) UPDATE  test2 SET writer = 'bbb@test.com' WHERE tno=1;
 * 
 * 5. 데이터 삭제하기
 * DELETE FROM 테이블명 WHERE 컬럼명 = 조건;
 * 예) DELETE FROM test2 WHERE tno=2;
 * 
 * 6. 테이블 삭제하기
 * DROP TABLES 테이블명;
 * 예) DROP TABLES test2;

 * */
public class Test2 {
  

}
