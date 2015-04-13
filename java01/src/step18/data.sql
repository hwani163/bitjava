--과목데이터

insert into subjects(title) values('자바');
insert into subjects(title) values('c');
insert into subjects(title) values('c++');
insert into subjects(title) values('c#');
insert into subjects(title) values('android');
insert into subjects(title) values('html5');
insert into subjects(title) values('aduino');
insert into subjects(title) values('servlet/jsp');
insert into subjects(title) values('spring framework');

강사데이터

INSERT INTO trainers(name,photo,tel,email,pwd)
values ('홍길동','hong.gif','111-1111','hong@test.com','1111');
INSERT INTO trainers(name,photo,tel,email,pwd)
values ('임꺽정','leem.gif','2222-2222','leem@test.com','2222');
INSERT INTO trainers(name,photo,tel,email,pwd)
values ('유관순','yoo.gif','3333-3333','yoo@test.com','3333');
INSERT INTO trainers(name,photo,tel,email,pwd)
values ('안중근','ahn.gif','4444-4444','ahn@test.com','4444');
INSERT INTO trainers(name,photo,tel,email,pwd)
values ('윤봉길','yoon.jpg','5555-5555','yoon@test.com','5555');


insert into sub_trai(tno,sno) values(1,1);
insert into sub_trai(tno,sno) values(1,2);
insert into sub_trai(tno,sno) values(1,3);

insert into sub_trai(tno,sno) values(2,5);
insert into sub_trai(tno,sno) values(2,7);

insert into sub_trai(tno,sno) values(3,1);
insert into sub_trai(tno,sno) values(3,6);

insert into sub_trai(tno,sno) values(4,1);
insert into sub_trai(tno,sno) values(4,2);
insert into sub_trai(tno,sno) values(4,3);
insert into sub_trai(tno,sno) values(4,5);
insert into sub_trai(tno,sno) values(4,7);


insert into sub_trai(tno,sno) values(5,1);
insert into sub_trai(tno,sno) values(5,8);
insert into sub_trai(tno,sno) values(5,9);



--강의데이터
insert into lectures(title,capa,st_date,ed_date,hours,days)
values('[자바70]-자바 고급과정',30,'2015-01-02','2015-05-30',800,100);
insert into lectures(title,capa,st_date,ed_date,hours,days)
values('[자바71]-자바 고급과정',30,'2015-02-02','2015-06-30',800,100);
insert into lectures(title,capa,st_date,ed_date,hours,days)
values('[자바72]-자바 고급과정',30,'2015-03-02','2015-07-30',800,100);

insert into lectures(title,capa,st_date,ed_date,hours,days)
values('[Window50]-Windows Programming',30,'2015-01-02','2015-05-30',800,100);
insert into lectures(title,capa,st_date,ed_date,hours,days)
values('[Window51]-Windows Programming',30,'2015-02-02','2015-06-30',800,100);


insert into classrooms(loc,room) values('강남','301');
insert into cr_photo(photo,cno) values('k301.gif',1);
insert into classrooms(loc,room) values('강남','303');
insert into cr_photo(photo,cno) values('k303.gif',2);
insert into classrooms(loc,room) values('강남','401');
insert into cr_photo(photo,cno) values('k401.gif',3);
insert into classrooms(loc,room) values('강남','402');
insert into cr_photo(photo,cno) values('k402.gif',4);
insert into classrooms(loc,room) values('강남','403');
insert into cr_photo(photo,cno) values('k403.gif',5);
insert into classrooms(loc,room) values('강남','404');
insert into cr_photo(photo,cno) values('k404.gif',6);
insert into classrooms(loc,room) values('강남','501');
insert into cr_photo(photo,cno) values('k501.gif',7);
insert into classrooms(loc,room) values('강남','502');
insert into cr_photo(photo,cno) values('k502.gif',8);
insert into classrooms(loc,room) values('강남','503');
insert into cr_photo(photo,cno) values('k503.gif',9);
insert into classrooms(loc,room) values('강남','504');
insert into cr_photo(photo,cno) values('k504.gif',10);
insert into classrooms(loc,room) values('종로','1호');
insert into cr_photo(photo,cno) values('j001.gif',11);
insert into classrooms(loc,room) values('종로','2호');
insert into cr_photo(photo,cno) values('j002.gif',12);
insert into classrooms(loc,room) values('종로','3호');
insert into cr_photo(photo,cno) values('j003.gif',13);
insert into classrooms(loc,room) values('종로','4호');
insert into cr_photo(photo,cno) values('j004.gif',14);

--자바70강의 강남 301호
update lectures set cno=1 where lno=1;
--자바강의 강남 403호
update lectures set cno=5 where lno=2;
--윈도우강의 종로2호
update lectures set cno=12 where lno=4;


--매니저 데이터
insert into managers(name , email , pwd , photo)
values('이은주','lee@bit',1111,'leebit.gif');
insert into managers(name , email , pwd , photo)
values('김용','kim@bit',2222,'kimbit.gif');
insert into managers(name , email , pwd , photo)
values('장현진','jang@bit',1111,'jangbit.gif');
insert into managers(name , email , pwd , photo)
values('권도혁','kwon@bit',1111,'kwonbit.gif');
insert into managers(name , email , pwd , photo)
values('최종진','choi@bit',1111,'choibit.gif');

update lectures set mno = 1 where lno=1;
update lectures set mno = 2 where lno=2;
update lectures set mno = 1 where lno=4;







