-- 교실사진
DROP TABLE IF EXISTS CR_PHOTO RESTRICT;

-- 강의장
DROP TABLE IF EXISTS CLASSROOMS RESTRICT;

-- 강의
DROP TABLE IF EXISTS LECTURES RESTRICT;

-- 수강신청
DROP TABLE IF EXISTS LEC_APPL RESTRICT;

-- 강사
DROP TABLE IF EXISTS TRAINERS RESTRICT;

-- 매니저
DROP TABLE IF EXISTS MANAGERS RESTRICT;

-- 학생
DROP TABLE IF EXISTS STUDENTS RESTRICT;

-- 강사배정
DROP TABLE IF EXISTS LEC_TRAI RESTRICT;

-- 강의과목
DROP TABLE IF EXISTS SUBJECTS RESTRICT;

-- 강사강의과목
DROP TABLE IF EXISTS SUB_TRAI RESTRICT;

-- 교실사진
CREATE TABLE CR_PHOTO (
	CPNO  INTEGER      NOT NULL COMMENT '교실사진번호', -- 교실사진번호
	PHOTO VARCHAR(255) NOT NULL COMMENT '교실사진', -- 교실사진
	cno   INTEGER      NOT NULL COMMENT '강의장번호' -- 강의장번호
)
COMMENT '교실사진';

-- 교실사진
ALTER TABLE CR_PHOTO
	ADD CONSTRAINT PK_CR_PHOTO -- 교실사진 기본키
		PRIMARY KEY (
			CPNO -- 교실사진번호
		);

ALTER TABLE CR_PHOTO
	MODIFY COLUMN CPNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '교실사진번호';

-- 강의장
CREATE TABLE CLASSROOMS (
	cno  INTEGER     NOT NULL COMMENT '강의장번호', -- 강의장번호
	loc  VARCHAR(10) NOT NULL COMMENT '장소', -- 장소
	room VARCHAR(10) NOT NULL COMMENT '교실' -- 교실
)
COMMENT '강의장';

-- 강의장
ALTER TABLE CLASSROOMS
	ADD CONSTRAINT PK_CLASSROOMS -- 강의장 기본키
		PRIMARY KEY (
			cno -- 강의장번호
		);

-- 강의장 유니크 인덱스
CREATE UNIQUE INDEX UIX_CLASSROOMS
	ON CLASSROOMS ( -- 강의장
		loc ASC,  -- 장소
		room ASC  -- 교실
	);

ALTER TABLE CLASSROOMS
	MODIFY COLUMN cno INTEGER NOT NULL AUTO_INCREMENT COMMENT '강의장번호';

-- 강의
CREATE TABLE LECTURES (
	lno     INTEGER      NOT NULL COMMENT '강의번호', -- 강의번호
	title   VARCHAR(255) NOT NULL COMMENT '강의명', -- 강의명
	intro   TEXT         NULL     COMMENT '강의소개', -- 강의소개
	capa    INTEGER      NULL     COMMENT '확정인원', -- 확정인원
	st_date DATE         NOT NULL COMMENT '최대인원', -- 최대인원
	ed_date DATE         NOT NULL COMMENT '강의시작일', -- 강의시작일
	hours   INTEGER      NOT NULL COMMENT '강의종료일', -- 강의종료일
	days    INTEGER      NOT NULL COMMENT '총강의시간', -- 총강의시간
	cnt     INTEGER      NULL     COMMENT '총강의일수', -- 총강의일수
	mno     INTEGER      NULL     COMMENT '매니저번호', -- 매니저번호
	cno     INTEGER      NULL     COMMENT '강의장번호' -- 강의장번호
)
COMMENT '강의';

-- 강의
ALTER TABLE LECTURES
	ADD CONSTRAINT PK_LECTURES -- 강의 기본키
		PRIMARY KEY (
			lno -- 강의번호
		);

ALTER TABLE LECTURES
	MODIFY COLUMN lno INTEGER NOT NULL AUTO_INCREMENT COMMENT '강의번호';

-- 수강신청
CREATE TABLE LEC_APPL (
	lno     INTEGER NOT NULL COMMENT '강의번호', -- 강의번호
	sno     INTEGER NOT NULL COMMENT '학생번호', -- 학생번호
	AP_DATE DATE    NULL     COMMENT '신청일', -- 신청일
	state   INTEGER NULL     COMMENT '신청결과' -- 신청결과
)
COMMENT '수강신청';

-- 수강신청
ALTER TABLE LEC_APPL
	ADD CONSTRAINT PK_LEC_APPL -- 수강신청 기본키
		PRIMARY KEY (
			lno, -- 강의번호
			sno  -- 학생번호
		);

-- 강사
CREATE TABLE TRAINERS (
	tno   INTEGER      NOT NULL COMMENT '강사번호', -- 강사번호
	name  VARCHAR(50)  NOT NULL COMMENT '강사명', -- 강사명
	photo VARCHAR(255) NOT NULL COMMENT '강사사진', -- 강사사진
	tel   VARCHAR(30)  NOT NULL COMMENT '강사전화', -- 강사전화
	email VARCHAR(40)  NOT NULL COMMENT '강사이메일', -- 강사이메일
	wage  INTEGER      NULL     COMMENT '강사시급', -- 강사시급
	pwd   VARCHAR(20)  NOT NULL COMMENT '암호', -- 암호
	addr  VARCHAR(255) NULL     COMMENT '강사주소' -- 강사주소
)
COMMENT '강사';

-- 강사
ALTER TABLE TRAINERS
	ADD CONSTRAINT PK_TRAINERS -- 강사 기본키
		PRIMARY KEY (
			tno -- 강사번호
		);

-- 강사 유니크 인덱스
CREATE UNIQUE INDEX UIX_TRAINERS
	ON TRAINERS ( -- 강사
		email ASC -- 강사이메일
	);

-- 강사 인덱스
CREATE INDEX IX_TRAINERS
	ON TRAINERS( -- 강사
		name ASC -- 강사명
	);

ALTER TABLE TRAINERS
	MODIFY COLUMN tno INTEGER NOT NULL AUTO_INCREMENT COMMENT '강사번호';

-- 매니저
CREATE TABLE MANAGERS (
	mno   INTEGER      NOT NULL COMMENT '매니저번호', -- 매니저번호
	name  VARCHAR(50)  NOT NULL COMMENT '매니저명', -- 매니저명
	email VARCHAR(255) NOT NULL COMMENT '매니저사진', -- 매니저사진
	tel   VARCHAR(30)  NOT NULL COMMENT '매니저전화번호', -- 매니저전화번호
	COL2  VARCHAR(40)  NOT NULL COMMENT '매니저이메일', -- 매니저이메일
	pwd   VARCHAR(20)  NOT NULL COMMENT '암호' -- 암호
)
COMMENT '매니저';

-- 매니저
ALTER TABLE MANAGERS
	ADD CONSTRAINT PK_MANAGERS -- 매니저 기본키
		PRIMARY KEY (
			mno -- 매니저번호
		);

-- 매니저 유니크 인덱스
CREATE UNIQUE INDEX UIX_MANAGERS
	ON MANAGERS ( -- 매니저
		COL2 ASC -- 매니저이메일
	);

-- 매니저 인덱스
CREATE INDEX IX_MANAGERS
	ON MANAGERS( -- 매니저
		name ASC -- 매니저명
	);

ALTER TABLE MANAGERS
	MODIFY COLUMN mno INTEGER NOT NULL AUTO_INCREMENT COMMENT '매니저번호';

-- 학생
CREATE TABLE STUDENTS (
	sno   INTEGER      NOT NULL COMMENT '학생번호', -- 학생번호
	name  VARCHAR(50)  NOT NULL COMMENT '학생명', -- 학생명
	photo VARCHAR(255) NULL     COMMENT '학생사진', -- 학생사진
	tel   VARCHAR(30)  NOT NULL COMMENT '학생전화', -- 학생전화
	email VARCHAR(40)  NOT NULL COMMENT '학생이메일', -- 학생이메일
	pwd   VARCHAR(20)  NOT NULL COMMENT '암호', -- 암호
	addr  VARCHAR(255) NOT NULL COMMENT '학생주소', -- 학생주소
	degee INTEGER      NOT NULL COMMENT '학생학력', -- 학생학력
	work  CHAR(1)      NOT NULL COMMENT '직장인여부' -- 직장인여부
)
COMMENT '학생';

-- 학생
ALTER TABLE STUDENTS
	ADD CONSTRAINT PK_STUDENTS -- 학생 기본키
		PRIMARY KEY (
			sno -- 학생번호
		);

-- 학생 유니크 인덱스
CREATE UNIQUE INDEX UIX_STUDENTS
	ON STUDENTS ( -- 학생
		email ASC -- 학생이메일
	);

ALTER TABLE STUDENTS
	MODIFY COLUMN sno INTEGER NOT NULL AUTO_INCREMENT COMMENT '학생번호';

-- 강사배정
CREATE TABLE LEC_TRAI (
	lno     INTEGER NOT NULL COMMENT '강의번호', -- 강의번호
	tno     INTEGER NOT NULL COMMENT '강사번호', -- 강사번호
	ST_DATE DATE    NULL     COMMENT '강사투입일시', -- 강사투입일시
	EN_DATE DATE    NULL     COMMENT '강사철수일시' -- 강사철수일시
)
COMMENT '강사배정';

-- 강사배정
ALTER TABLE LEC_TRAI
	ADD CONSTRAINT PK_LEC_TRAI -- 강사배정 기본키
		PRIMARY KEY (
			lno, -- 강의번호
			tno  -- 강사번호
		);

-- 강의과목
CREATE TABLE SUBJECTS (
	sno   INTEGER     NOT NULL COMMENT '강의과목번호', -- 강의과목번호
	title VARCHAR(50) NOT NULL COMMENT '과목명' -- 과목명
)
COMMENT '강의과목';

-- 강의과목
ALTER TABLE SUBJECTS
	ADD CONSTRAINT PK_SUBJECTS -- 강의과목 기본키
		PRIMARY KEY (
			sno -- 강의과목번호
		);

ALTER TABLE SUBJECTS
	MODIFY COLUMN sno INTEGER NOT NULL AUTO_INCREMENT COMMENT '강의과목번호';

-- 강사강의과목
CREATE TABLE SUB_TRAI (
	tno INTEGER NOT NULL COMMENT '강사번호', -- 강사번호
	sno INTEGER NOT NULL COMMENT '강의과목번호' -- 강의과목번호
)
COMMENT '강사강의과목';

-- 강사강의과목
ALTER TABLE SUB_TRAI
	ADD CONSTRAINT PK_SUB_TRAI -- 강사강의과목 기본키
		PRIMARY KEY (
			tno, -- 강사번호
			sno  -- 강의과목번호
		);

-- 교실사진
ALTER TABLE CR_PHOTO
	ADD CONSTRAINT FK_CLASSROOMS_TO_CR_PHOTO -- 강의장 -> 교실사진
		FOREIGN KEY (
			cno -- 강의장번호
		)
		REFERENCES CLASSROOMS ( -- 강의장
			cno -- 강의장번호
		);

-- 강의
ALTER TABLE LECTURES
	ADD CONSTRAINT FK_MANAGERS_TO_LECTURES -- 매니저 -> 강의
		FOREIGN KEY (
			mno -- 매니저번호
		)
		REFERENCES MANAGERS ( -- 매니저
			mno -- 매니저번호
		);

-- 강의
ALTER TABLE LECTURES
	ADD CONSTRAINT FK_CLASSROOMS_TO_LECTURES -- 강의장 -> 강의
		FOREIGN KEY (
			cno -- 강의장번호
		)
		REFERENCES CLASSROOMS ( -- 강의장
			cno -- 강의장번호
		);

-- 수강신청
ALTER TABLE LEC_APPL
	ADD CONSTRAINT FK_LECTURES_TO_LEC_APPL -- 강의 -> 수강신청
		FOREIGN KEY (
			lno -- 강의번호
		)
		REFERENCES LECTURES ( -- 강의
			lno -- 강의번호
		);

-- 수강신청
ALTER TABLE LEC_APPL
	ADD CONSTRAINT FK_STUDENTS_TO_LEC_APPL -- 학생 -> 수강신청
		FOREIGN KEY (
			sno -- 학생번호
		)
		REFERENCES STUDENTS ( -- 학생
			sno -- 학생번호
		);

-- 강사배정
ALTER TABLE LEC_TRAI
	ADD CONSTRAINT FK_LECTURES_TO_LEC_TRAI -- 강의 -> 강사배정
		FOREIGN KEY (
			lno -- 강의번호
		)
		REFERENCES LECTURES ( -- 강의
			lno -- 강의번호
		);

-- 강사배정
ALTER TABLE LEC_TRAI
	ADD CONSTRAINT FK_TRAINERS_TO_LEC_TRAI -- 강사 -> 강사배정
		FOREIGN KEY (
			tno -- 강사번호
		)
		REFERENCES TRAINERS ( -- 강사
			tno -- 강사번호
		);

-- 강사강의과목
ALTER TABLE SUB_TRAI
	ADD CONSTRAINT FK_TRAINERS_TO_SUB_TRAI -- 강사 -> 강사강의과목
		FOREIGN KEY (
			tno -- 강사번호
		)
		REFERENCES TRAINERS ( -- 강사
			tno -- 강사번호
		);

-- 강사강의과목
ALTER TABLE SUB_TRAI
	ADD CONSTRAINT FK_SUBJECTS_TO_SUB_TRAI -- 강의과목 -> 강사강의과목
		FOREIGN KEY (
			sno -- 강의과목번호
		)
		REFERENCES SUBJECTS ( -- 강의과목
			sno -- 강의과목번호
		);