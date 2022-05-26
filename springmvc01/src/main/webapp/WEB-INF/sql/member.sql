create user c##spring01 identified by 1234;

grant connect, resource to c##spring01;

alter user c##spring01 default tablespace users quota unlimited on users;


-- spring01 접속
create table tbl_member(
    userid varchar2(50) primary key,
    userpw varchar2(50) not null,
    username varchar2(50) not null,
    email varchar2(100),
    regdate date default sysdate,
    updatedate date default sysdate
);


-- 데이터 전체 삭제
truncate table tbl_board;

-- 시퀀스 새로 생성
drop SEQUENCE seq_board_bno;
create sequence seq_board_bno;

-- c##spring01

create table tbl_board(
    bno number primary key, -- 글번호(pk)
    title varchar2(200) not null, -- 글내용
    content varchar2(4000), -- 글내용 (냉무허용)
    writer varchar2(50) not null, -- 작성자
    regdate date default sysdate, -- 작성일
    viewcnt number default 0 -- 조회수
);


-- 글번호용 시퀀스 생성
create sequence seq_board_bno;


-- 포인트 컬럼 추가
alter table tbl_member
add m_point number default 0;

-- 사진 컬럼 푸가
alter table tbl_member
add m_pic varchar2(100);