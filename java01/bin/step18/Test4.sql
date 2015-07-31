--MySql의 컬럼 데이터 타입
--=> 표준Type + DBMS 고유 타입 => DBMS 메뉴얼을 참고하여야 한다.


INT , INTEGER  => 4byte 크기의 정수값을 담을때 사용한다.
DECIMAL(M,D) m자리 크기의 d소수점을 표현한다.
NUMERIC(M,D)

mySql에서는 날짜와 시간을 따로 사용하고 있다 두개를 동시에 사용하고 싶다면
DATETIME을 사용하면된다.
DATE => 날짜
TIME => 시간
오라클에서는 DATE에 날자과 시간을 둘다 포함 하고 있다.

CHAR(m)  m자리의 문자를 저장할 수 있다(고정 크기 이다. 값이 크기보다 작은 문자를 저장해도 m 크기를 갖는다.)
M은 최대 255까지 가능하다.( 메모리를 Save하기 힘들지만 검색속도가 빠르다!)

VARCHAR(m) 최대 m 자리 문자를 저장한다.(가변 크기를 갖는다. 저장한 문자열 갯수만큼 크기를 갖는다.
=> 메모리를 Save 할 수 있다.
=>크기가 변하기 때문에 검색 속도가 느리다.)
m자리는 255 자리까지 문자를 저장가능하다.

TEXT , BLOB => 6만자정도를 저장할 수 있다.
MEDIUMBLOB , MEDIUMTEXT => 약 16M정도의 문자를 저장 할 수 있다.

=>사진 파일이나 음악 파일 같은 이진 데이터의 저장!!
		가능한 file을 DBMS에 저장하지 말아라!!
		외부 파일 시스템 (HDD)에 저장한 후
		그 File의 경로를 DBMS에서 관리하라!
		
	Reserved keyword : 시스템에서 명령어로 사용하기 위해 미리 등록한 이름.
		
	예 :  게시판 테이블 만들기
	
	CREATE TABLE board(
	bno int NOT NULL,
	title varchar(255) NOT NULL,
	content TEXT NOT NULL,
	cre_date datetime NOT NULL,
	views int default 0,
	pwd varchar(20)
	);
	
	ALTER TABLE board
	ADD CONSTRAINT board_pk PRIMARY KEY (bno);
	
	Mysql 서버에서 제공하는 함수
	CURTIME() =>현재 시간
	CURDATE() => 현재 날짜
	NOW() => 현재 시간 + 날짜
	INSERT INTO board(bno , title , content , cre_date)
	VALUES(1,'aaaaa','bbbbbbbb',now());
	INSERT INTO board(bno , title , content , cre_date)
	VALUES(2,'bbbbb','bbbbbbbb',now());
	INSERT INTO board(bno , title , content , cre_date)
	VALUES(3,'ccccc','bbbbbbbb',now());
	INSERT INTO board(bno , title , content , cre_date)
	VALUES(4,'ddddd','bbbbbbbb',now());
	
	
		
		
