컬럼의 값을 자동으로 증가시키기
컬럼의 값을 입력하지 않아도 이전 값 보다 하나 증가된 값을 자동으로 입력하게 만든다.

AUTO_INCREMENT

CREATE TABLE board2 (
bno 				INT NOT NULL,
title				VARCHAR(255) NOT NULL,
content				TEXT NOT NULL,
views				INT DEFAULT 0,
cre_date datetime NOT NULL,
pwd				VARCHAR(20) NOT NULL

);

 board2 의 bno 컬럼을 primaryKEY로 선언한다.
ALTER TABLE board2
ADD CONSTRAINT board2_pk PRIMARY KEY(bno);
--bno 컬럼에 AUTO_INCREMENT 속성을 추가한다.
--AUTO_INCREMENT 속성은 KEY컬럼에 대해서만 적용 할 수 있다.
--그러므로 bno 컬럼을 먼저 primaryKEY로 만든 다음 이 속성을 지정해야 한다.
ALTER TABLE board2
MODIFY COLUMN bno INT NOT NULL AUTO_INCREMENT;


데이터 입력하기
INSERT INTO board2(title , content , cre_date)
values('aaaa','bbbb',now());

--다른 테이블의 값을 복사하기(입력하기)
--컬럼의 형식만 맞다면 , 값을 넣을수 있다면 다른 테이블의 값을 입력 할 수 있다.
--테이블 복제할 때 많이 쓴다.
INSERT INTO board2(title , content , cre_date)
SELECT title , content , cre_date FROM board;

--서브쿼리란?
--질의문 into 질의문
--innerClass와 유사하다.
위의 query에서 INSERT문 안에 SELECT문이 있다.
바로 SELECT문을 SubQuery 라고 부른다.
SubQuery는 어디에서든 사용 할 수 있다.
Ex)
Select 서브쿼리 , 컬럼 , .... from 테이블명
select 컬럼명 , 컬럼명 , from 서브쿼리;
select 컬럼명 , 컬럼명  , from 테이블명 where 컬럼=(서브쿼리)

