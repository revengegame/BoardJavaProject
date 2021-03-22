create table content_table(
content_idx number constraint content_pk primary key,
content_subject varchar2(500) not null,
content_text long not null,
content_file varchar2(500) not null,
content_writer_idx number not null
constraint content_fk1 references user_table(user_idx),
content_board_idx number not null
constraint content_fk2 references board_info_table(board_info_idx),
content_date date not null
);



alter table content_table add constraint fk_content_writer_idx
foreign key(content_writer_idx) references user_table(user_idx)

alter table content_table add constraint fk_content_board_idx
foreign key(content_board_idx) references board_info_table(board_info_idx)

create sequence content_seq
start with 1
increment by 1
minvalue 1
maxvalue 1000;


select * from CONTENT_TABLE
drop table content_table

create table user_table(
user_idx number constraint user_pk primary key,
user_name varchar2(50) not null,
user_id varchar2(100) not null,
user_pw varchar2(100) not null
);

create sequence user_seq
start with 1
increment by 1
minvalue 1
maxvalue 1000;

select * from user_table
drop table user_table

select * from user_table
where user_id='messi' and user_pw='1234';

select user_idx,user_name
from USER_TABLE
where user_id='messi' and user_pw='1234';

select user_id,user_name
from USER_TABLE
where user_idx='5'

update USER_TABLE
set user_pw='5678'
where user_idx='5'



create table board_info_table(
board_info_idx number constraint board_info_pk primary key,
board_info_name varchar2(500) not null
);

insert into board_info_table(board_info_idx,board_info_name)
values(1,'자바게시판');
insert into board_info_table(board_info_idx,board_info_name)
values(2,'JSP게시판');
insert into board_info_table(board_info_idx,board_info_name)
values(3,'Spring게시판');
insert into board_info_table(board_info_idx,board_info_name)
values(4,'DB게시판');




select * from board_info_table
drop table board_info_table