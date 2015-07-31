/*
 *  1. Primary Key(주키)
 * => 테이블에 저장된 데이터( Record , Entity , Row)
 * 		를 구분할 때 사용할 컬럼 집합.
 * 
 * 실습1. 데이터 중복 Test
 * PrimaryKey 가 없을때의 문제점 : 데이터의 중복을 막을 수가 없다.
 * => 준비해야할 사항 : test2 Table의생성 및 데이터 삽입.
 * => 새 데이터 입력 : 번호가 중복되어도 오류가 발생하지 않는다.
 */
INSERT INTO test2(tno , title , writer) Values(3,'ddd','hong');
--일부러 똑같은 번호를 넣었다.


/*
 * 실습 2  : 삭제할 때 Record를 구분할 수 없다. ::::Primary Key가 없으면
 * => 준비 : 다음 새 Data를 입력하라.
 */
INSERT INTO test2(tno , title , writer) Values(3,'ddd','hong');

--현재 3 , ddd , hong 데이터가 두개 등록 되어 있따. 둘중 하나를 삭제하라

DELETE FROM test2 where tno =3 AND title ='ddd' AND writer='hong';
--두개 모두다 지워진다!!!
--둘중 하나만 지울수가 없다. 둘 중 모두가 삭제된다.

--해결책!!!
--PrimaryKey 를지정하면된다.
--실습 1과 실습 2의 문제점? Primary Key가 없기 때문에 
--모든 컬럼의 값이 동일 할 때, 특정 레코드만 지정하여 삭제 할 수 없다.
--Table에 반드시!!!!!!!!!!!!!!!!!!!!! PRIMARY KEY 컬럼을 지정하자!!!!!!!!!!!!!!!!!

--Primary Key 지정하기
--방법1 : Table생성문에서 컬럼명 뒤에 PRIMARY KEY 명령얼 추가한다.
CREATE TABLE test3 (
tno INT PRIMARY KEY NOT NULL,
title VARCHAR(200) NOT NULL,
writer VARCHAR(20)
);

--PRIMARY KEY 적용 Test
--test2의 경우처럼 중복 데이터를 입력하여 보자!



--실습1.데이터 중복 Test
--예) =>일단 기본 데이터 3개를 입력한다.
INSERT INTO test3(tno , title , writer) Values(1,'aaa','hong');
INSERT INTO test3(tno , title , writer) Values(2,'bbb','hong');
INSERT INTO test3(tno , title , writer) Values(3,'ccc','hong');
--tno컬럼 값이 같은 데이터를 입력한다. => Primary key데이터 중복 오류 발생
INSERT INTO test3(tno , title , writer) Values(1,'ddd','hong');
--PRIMARY KEY는 데이터 중복을 허용하지 않는다.



--실습2 : 중복 데이터 삭제 테스트
--예 title이'ccc' , writer가 'hong'인 데이터를 입력한다.
--단 tno 값은 달라야 한다.
INSERT INTO test3(tno , title , writer) Values(4,'ccc','hong');

--같은 제목을 갖는 두개의 중복 레코드 중에서 하나를 삭제해 보자
--중복 레코드가 있으면 PK 컬럼으로 특정 레코드를 삭제할 수 있다.
DELETE FROM test3 WHERE tno =3;


--2.Primary Key 지정하기(계속)
방법2 : 테이블을 이미 생성한후 테이블 변겨문에서 primary key를  지정한다.

--예) 
--ALTER TABLE 테이블명(
--ADD CONSTRAINT 제약조건 PRIMARY KEY (컬럼명 , 컬럼명 , ......)
--);
CREATE TABLE test4 (
tno INT  NOT NULL,
title VARCHAR(200) NOT NULL,
writer VARCHAR(20)
);

ALTER TABLE test4 ADD CONSTRAINT test4_pk PRIMARY KEY(tno);
--test4_pk란 라벨이름이다!! Tag이름이다

INSERT INTO test4(tno , title , writer) Values(1,'aaa','hong');
INSERT INTO test4(tno , title , writer) Values(2,'bbb','hong');
--다음과 같이 존재하는 tno 값으로 데이터를 INSERT하면 오류가 발생한다.
--PK가 정상적으로 지정되었음을 확인해 볼 수 있따.
INSERT INTO test4(tno , title , writer) Values(2,'bbb','hong');


--PRIMARY KEY 지정하기
--테이블 생성문 안에 제약 조건을 기술한다.
--CREATE 테이블(
--컬럼명 타입 , 
--컬럼명 타입 , 
--....
--CONSTRAINT 심벌명 PRIMARY KEY (tno)
--);
CREATE TABLE test5 (
tno INT  NOT NULL,
title VARCHAR(200) NOT NULL,
writer VARCHAR(20),
CONSTRAINT tno_pk PRIMARY KEY (tno)
);






