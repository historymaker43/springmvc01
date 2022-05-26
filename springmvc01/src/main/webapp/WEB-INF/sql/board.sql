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