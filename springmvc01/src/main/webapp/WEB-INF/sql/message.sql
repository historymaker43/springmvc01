--  메지시(쪽지) 테이블
create table tbl_message(
	mid number primary key, -- 메시지 번호
	sender varchar2(50) references tbl_member(userid), -- 보낸사람
	receiver varchar2(50) references tbl_member(userid), -- 받는 사람
	message varchar2(500) not null, -- 메시지 내용
	senddate date default sysdate, -- 보낸 날짜
	opendate date -- 열람 날짜
);

create sequence seq_message_mid;

TRUNCATE table tbl_message;