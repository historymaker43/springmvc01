-- 포인트 코드
create table tbl_point_code(
	pcode number primary key,
	pdesc varchar2(100) not null
);

-- 포인트
create table tbl_point(
	pid number primary key,
	userid varchar2(50) references tbl_member(userid),
	point number default 0,
	pcode number references tbl_point_code(pcode),
	pointdate date default sysdate
);

create sequence seq_point_pid;

insert into tbl_point_code(pcode, pdesc)
values(1001, '쪽지보내기');
insert into tbl_point_code(pcode, pdesc)
values(1002, '쪽지읽기');

commit;

select pid, userid, point, c.pdesc, pointdate
from tbl_point p, tbl_point_code c
where p.pcode = c.pcode and userid = 'user01';