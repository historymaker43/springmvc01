-- comment.sql

-- 댓글 테이블
-- 댓글 번호(PK)
-- 글번호(bno) - FK
-- 글내용
-- 작성자
-- 날짜

create table tbl_comment(
	cno number primary key,
	bno number references tbl_board(bno),
	content varchar2(200) not null,
	userid varchar2(50) references tbl_member(userid),
	regdate date default sysdate
);

create sequence seq_commemt_cno;