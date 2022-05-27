-- 답글 관련

alter table tbl_board
add re_group number default 0;

alter table tbl_board
add re_level number default 0;

alter table tbl_board
add re_seq number default 0;

update tbl_board set
re_group = bno;

commit;

-- 첨부파일 테이블
create table tbl_attach(
    filename varchar2(50) primary key,
    bno number references tbl_board(bno)
);