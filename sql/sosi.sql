drop table sosi;

create table sosi(
  id number(4) not null primary key,
  name varchar2(20),
  salary number,
  birth date,
  email varchar(20),
  grade varchar(4)
);
commit;