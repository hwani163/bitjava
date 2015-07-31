/*
 * 테이블 추가 , 데이터 삽입  , 데이터 조회 , 데이터 수정 , 데이터 삭제 , 테이블 삭제*/

CREATE TABLE test2(
tno INT NOT NULL,
title VARCHAR(200) NOT NULL,
writer VARCHAR(20));

INSERT INTO test2(tno , title , writer) Values(1,'aaa','hong');
INSERT INTO test2(tno , title , writer) Values(2,'bbb','hong');
INSERT INTO test2(tno , title , writer) Values(3,'ccc','hong');



SELECT tno , title , writer FROM test2;

UPDATE  test2 SET writer = 'bbb@test.com' WHERE tno=1;
UPDATE  test2 SET writer = 'ccc@test.com' WHERE tno=3;

DELETE FROM test2 where tno=2;

DROP TABLES test2;