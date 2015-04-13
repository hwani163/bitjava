insert 문

예1) 입력할 컬럼을 지정하지 않을 경우,
==> 테이블을 생성할 때 컬럼을 선언한 순서대로 컬럼값을 values() 에 나열하여야 한다.

INSERT INTO board
VALUES (5 , 'eeeee' , 'okokok', now() , 0 , NULL);

예 ) 컬럼 순서를 바꾸어도 상관없다. 대신!
	  VALUES ()는 그 컬럼 순서로 값을 나열 하여야한다.
	  
INSERT INTO board(content , cre_date , bno , title)
VALUES('OKOKOKOKOK',now(),6,'fffff');

예3) 날짜 컬럼에 값 입력하기(따옴표를 사용하여 날짜 값을 표현한다.)
INSERT INTO board(bno , title , content , cre_date)
VALUES(7,'ggggg','okokok','2015-03-31');

