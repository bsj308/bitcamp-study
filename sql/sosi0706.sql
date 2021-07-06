SQL> select * from sosi;
select * from sosi
              *
ERROR at line 1:
ORA-00942: table or view does not exist 


SQL> drop table sosi;
drop table sosi
           *
ERROR at line 1:
ORA-00942: table or view does not exist 


SQL> edit c:\mtest\sosi.sql

SQL> @ c:\mtest\sosi.sql
drop table sosi
           *
ERROR at line 1:
ORA-00942: table or view does not exist 



Table created.


Commit complete.

SQL> clear screen

SQL> desc sosi
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 ID                                        NOT NULL NUMBER(4)
 NAME                                               VARCHAR2(20)
 SALARY                                             NUMBER
 BIRTH                                              DATE
 EMAIL                                              VARCHAR2(20)
 GRADE                                              VARCHAR2(4)

SQL> insert into sosi(id, name, salary, birth, email, grade)
  2  values(7789, 'hong', 79, sysdate, 'bc@sk.com', 'F');

1 row created.

SQL> insert into sosi(id, name, salary, birth, email, grade)
  2  values(7790, 'lee', 23, sysdate, 'bb@sk.com', '');

1 row created.

SQL> insert into sosi(id, name, salary, birth, email, grade)
  2  values(7754, 'kim', 57, sysdate, 'aa@sk.com', 'A');

1 row created.

SQL> select * from sosi;

        ID NAME                                         SALARY BIRTH            
---------- ---------------------------------------- ---------- --------         
EMAIL                                    GRADE                                  
---------------------------------------- --------                               
      7789 hong                                             79 21/07/06         
bc@sk.com                                F                                      
                                                                                
      7790 lee                                              23 21/07/06         
bb@sk.com                                                                       
                                                                                
      7754 kim                                              57 21/07/06         
aa@sk.com                                A                                      
                                                                                

SQL> column name format a10;
SQL> col email for a10;
SQL> select * from sosi;

        ID NAME           SALARY BIRTH    EMAIL      GRADE                      
---------- ---------- ---------- -------- ---------- --------                   
      7789 hong               79 21/07/06 bc@sk.com  F                          
      7790 lee                23 21/07/06 bb@sk.com                             
      7754 kim                57 21/07/06 aa@sk.com  A                          

SQL> col id for 999;
SQL> select * from sosi;

  ID NAME           SALARY BIRTH    EMAIL      GRADE                            
---- ---------- ---------- -------- ---------- --------                         
#### hong               79 21/07/06 bc@sk.com  F                                
#### lee                23 21/07/06 bb@sk.com                                   
#### kim                57 21/07/06 aa@sk.com  A                                

SQL> col id for 9999;
SQL> select * from sosi;

   ID NAME           SALARY BIRTH    EMAIL      GRADE                           
----- ---------- ---------- -------- ---------- --------                        
 7789 hong               79 21/07/06 bc@sk.com  F                               
 7790 lee                23 21/07/06 bb@sk.com                                  
 7754 kim                57 21/07/06 aa@sk.com  A                               

SQL> col grade for a3;
SQL> select * from sosi;

   ID NAME           SALARY BIRTH    EMAIL      GRA                             
----- ---------- ---------- -------- ---------- ---                             
 7789 hong               79 21/07/06 bc@sk.com  F                               
 7790 lee                23 21/07/06 bb@sk.com                                  
 7754 kim                57 21/07/06 aa@sk.com  A                               

SQL> insert into sosi valuses(7,'김고은', 100, to_date('17/12/12'),'aa@girl.com','A');
insert into sosi valuses(7,'김고은', 100, to_date('17/12/12'),'aa@girl.com','A')
                         *
ERROR at line 1:
ORA-00928: missing SELECT keyword 


SQL> insert into sosi values(7,'김고은', 100, to_date('17/12/12'),'aa@girl.com','A');

1 row created.

SQL> insert into sosi values(6,'태연', 100, to_date('19/12/12'),'aa@girl.com','A');

1 row created.

SQL> insert into sosi values(2,'티파니', 90, to_date('17/11/13'),'bb@girl.com','B');

1 row created.

SQL> insert into sosi values(3,'제니', 120, to_date('17/10/25'),'cc@girl.com','C');

1 row created.

SQL> insert into sosi values(4,'수영', 90, sysdate,'dd@girl.com','A');

1 row created.

SQL> update insa set grade = 'C' where id=7790;
update insa set grade = 'C' where id=7790
                                  *
ERROR at line 1:
ORA-00904: "ID": invalid identifier 


SQL> update sosi set grade = 'C' where id=7790;

1 row updated.

SQL> commit;

Commit complete.

SQL> select * from sosi;

   ID NAME           SALARY BIRTH    EMAIL      GRA                             
----- ---------- ---------- -------- ---------- ---                             
 7789 hong               79 21/07/06 bc@sk.com  F                               
 7790 lee                23 21/07/06 bb@sk.com  C                               
 7754 kim                57 21/07/06 aa@sk.com  A                               
    7 김고은            100 17/12/12 aa@girl.co A                               
                                     m                                          
                                                                                
    6 태연              100 19/12/12 aa@girl.co A                               
                                     m                                          
                                                                                
    2 티파니             90 17/11/13 bb@girl.co B                               
                                     m                                          

   ID NAME           SALARY BIRTH    EMAIL      GRA                             
----- ---------- ---------- -------- ---------- ---                             
                                                                                
    3 제니              120 17/10/25 cc@girl.co C                               
                                     m                                          
                                                                                
    4 수영               90 21/07/06 dd@girl.co A                               
                                     m                                          
                                                                                

8 rows selected.

SQL> col eamil for a14;
SQL> select * from sosi;

   ID NAME           SALARY BIRTH    EMAIL      GRA                             
----- ---------- ---------- -------- ---------- ---                             
 7789 hong               79 21/07/06 bc@sk.com  F                               
 7790 lee                23 21/07/06 bb@sk.com  C                               
 7754 kim                57 21/07/06 aa@sk.com  A                               
    7 김고은            100 17/12/12 aa@girl.co A                               
                                     m                                          
                                                                                
    6 태연              100 19/12/12 aa@girl.co A                               
                                     m                                          
                                                                                
    2 티파니             90 17/11/13 bb@girl.co B                               
                                     m                                          

   ID NAME           SALARY BIRTH    EMAIL      GRA                             
----- ---------- ---------- -------- ---------- ---                             
                                                                                
    3 제니              120 17/10/25 cc@girl.co C                               
                                     m                                          
                                                                                
    4 수영               90 21/07/06 dd@girl.co A                               
                                     m                                          
                                                                                

8 rows selected.

SQL> col email for a14;
SQL> select * from sosi;

   ID NAME           SALARY BIRTH    EMAIL          GRA                         
----- ---------- ---------- -------- -------------- ---                         
 7789 hong               79 21/07/06 bc@sk.com      F                           
 7790 lee                23 21/07/06 bb@sk.com      C                           
 7754 kim                57 21/07/06 aa@sk.com      A                           
    7 김고은            100 17/12/12 aa@girl.com    A                           
    6 태연              100 19/12/12 aa@girl.com    A                           
    2 티파니             90 17/11/13 bb@girl.com    B                           
    3 제니              120 17/10/25 cc@girl.com    C                           
    4 수영               90 21/07/06 dd@girl.com    A                           

8 rows selected.

SQL> select name,salary, grade from sosi;

NAME           SALARY GRA                                                       
---------- ---------- ---                                                       
hong               79 F                                                         
lee                23 C                                                         
kim                57 A                                                         
김고은            100 A                                                         
태연              100 A                                                         
티파니             90 B                                                         
제니              120 C                                                         
수영               90 A                                                         

8 rows selected.

SQL> select name, salarya grade from sosi where id = 2;
select name, salarya grade from sosi where id = 2
             *
ERROR at line 1:
ORA-00904: "SALARYA": invalid identifier 


SQL> select name, salary grade from sosi where id = 2;

NAME            GRADE                                                           
---------- ----------                                                           
티파니     ##########                                                           

SQL> select id, name, salary grade from sosi where id = 2;

   ID NAME            GRADE                                                     
----- ---------- ----------                                                     
    2 티파니     ##########                                                     

SQL> select id, name, salary, grade from sosi where id = 2;

   ID NAME           SALARY GRA                                                 
----- ---------- ---------- ---                                                 
    2 티파니             90 B                                                   

SQL> select name, salary, grade from sosi where id = 2;

NAME           SALARY GRA                                                       
---------- ---------- ---                                                       
티파니             90 B                                                         

SQL> select rownum, id, name, salaray, birth, email, grade from sosi;
select rownum, id, name, salaray, birth, email, grade from sosi
                         *
ERROR at line 1:
ORA-00904: "SALARAY": invalid identifier 


SQL> select rownum, id, name, salary, birth, email, grade from sosi;

    ROWNUM    ID NAME           SALARY BIRTH    EMAIL          GRA              
---------- ----- ---------- ---------- -------- -------------- ---              
         1  7789 hong               79 21/07/06 bc@sk.com      F                
         2  7790 lee                23 21/07/06 bb@sk.com      C                
         3  7754 kim                57 21/07/06 aa@sk.com      A                
         4     7 김고은            100 17/12/12 aa@girl.com    A                
         5     6 태연              100 19/12/12 aa@girl.com    A                
         6     2 티파니             90 17/11/13 bb@girl.com    B                
         7     3 제니              120 17/10/25 cc@girl.com    C                
         8     4 수영               90 21/07/06 dd@girl.com    A                

8 rows selected.

SQL> col grade for a5;
SQL> select rownum, id, name, salary, birth, email, grade from sosi;

    ROWNUM    ID NAME           SALARY BIRTH    EMAIL          GRADE            
---------- ----- ---------- ---------- -------- -------------- -----            
         1  7789 hong               79 21/07/06 bc@sk.com      F                
         2  7790 lee                23 21/07/06 bb@sk.com      C                
         3  7754 kim                57 21/07/06 aa@sk.com      A                
         4     7 김고은            100 17/12/12 aa@girl.com    A                
         5     6 태연              100 19/12/12 aa@girl.com    A                
         6     2 티파니             90 17/11/13 bb@girl.com    B                
         7     3 제니              120 17/10/25 cc@girl.com    C                
         8     4 수영               90 21/07/06 dd@girl.com    A                

8 rows selected.

SQL> select rownum, * from sosi;
select rownum, * from sosi
               *
ERROR at line 1:
ORA-00936: missing expression 


SQL> select rownum, s.* from sosi s;

    ROWNUM    ID NAME           SALARY BIRTH    EMAIL          GRADE            
---------- ----- ---------- ---------- -------- -------------- -----            
         1  7789 hong               79 21/07/06 bc@sk.com      F                
         2  7790 lee                23 21/07/06 bb@sk.com      C                
         3  7754 kim                57 21/07/06 aa@sk.com      A                
         4     7 김고은            100 17/12/12 aa@girl.com    A                
         5     6 태연              100 19/12/12 aa@girl.com    A                
         6     2 티파니             90 17/11/13 bb@girl.com    B                
         7     3 제니              120 17/10/25 cc@girl.com    C                
         8     4 수영               90 21/07/06 dd@girl.com    A                

8 rows selected.

SQL> select rownum, s.* from sosi s where id = 2;

    ROWNUM    ID NAME           SALARY BIRTH    EMAIL          GRADE            
---------- ----- ---------- ---------- -------- -------------- -----            
         1     2 티파니             90 17/11/13 bb@girl.com    B                

SQL> select rownum, s.* from sosi s where id = 3;

    ROWNUM    ID NAME           SALARY BIRTH    EMAIL          GRADE            
---------- ----- ---------- ---------- -------- -------------- -----            
         1     3 제니              120 17/10/25 cc@girl.com    C                

SQL> select rownum, s.* from sosi s where grade = 'b';

no rows selected

SQL> select rownum, s.* from sosi s where grade = 'B';

    ROWNUM    ID NAME           SALARY BIRTH    EMAIL          GRADE            
---------- ----- ---------- ---------- -------- -------------- -----            
         1     2 티파니             90 17/11/13 bb@girl.com    B                

SQL> select * from sosi where grade = 'a';

no rows selected

SQL> select * from sosi where grade = 'A';

   ID NAME           SALARY BIRTH    EMAIL          GRADE                       
----- ---------- ---------- -------- -------------- -----                       
 7754 kim                57 21/07/06 aa@sk.com      A                           
    7 김고은            100 17/12/12 aa@girl.com    A                           
    6 태연              100 19/12/12 aa@girl.com    A                           
    4 수영               90 21/07/06 dd@girl.com    A                           

SQL> select * from sosi where salary >120 ;

no rows selected

SQL> select * from sosi where salary > 90 ;

   ID NAME           SALARY BIRTH    EMAIL          GRADE                       
----- ---------- ---------- -------- -------------- -----                       
    7 김고은            100 17/12/12 aa@girl.com    A                           
    6 태연              100 19/12/12 aa@girl.com    A                           
    3 제니              120 17/10/25 cc@girl.com    C                           

SQL> select * from sosi where salary <= 90 ;

   ID NAME           SALARY BIRTH    EMAIL          GRADE                       
----- ---------- ---------- -------- -------------- -----                       
 7789 hong               79 21/07/06 bc@sk.com      F                           
 7790 lee                23 21/07/06 bb@sk.com      C                           
 7754 kim                57 21/07/06 aa@sk.com      A                           
    2 티파니             90 17/11/13 bb@girl.com    B                           
    4 수영               90 21/07/06 dd@girl.com    A                           

SQL> select * from sosi;

   ID NAME           SALARY BIRTH    EMAIL          GRADE                       
----- ---------- ---------- -------- -------------- -----                       
 7789 hong               79 21/07/06 bc@sk.com      F                           
 7790 lee                23 21/07/06 bb@sk.com      C                           
 7754 kim                57 21/07/06 aa@sk.com      A                           
    7 김고은            100 17/12/12 aa@girl.com    A                           
    6 태연              100 19/12/12 aa@girl.com    A                           
    2 티파니             90 17/11/13 bb@girl.com    B                           
    3 제니              120 17/10/25 cc@girl.com    C                           
    4 수영               90 21/07/06 dd@girl.com    A                           

8 rows selected.

SQL> update sosi set id = 2100 where id =2;

1 row updated.

SQL> update sosi set id = 3000 where id = 3;

1 row updated.

SQL> commit;

Commit complete.

SQL> select * from sosi;

   ID NAME           SALARY BIRTH    EMAIL          GRADE                       
----- ---------- ---------- -------- -------------- -----                       
 7789 hong               79 21/07/06 bc@sk.com      F                           
 7790 lee                23 21/07/06 bb@sk.com      C                           
 7754 kim                57 21/07/06 aa@sk.com      A                           
    7 김고은            100 17/12/12 aa@girl.com    A                           
    6 태연              100 19/12/12 aa@girl.com    A                           
 2100 티파니             90 17/11/13 bb@girl.com    B                           
 3000 제니              120 17/10/25 cc@girl.com    C                           
    4 수영               90 21/07/06 dd@girl.com    A                           

8 rows selected.

SQL> update sosi set name= bit;
update sosi set name= bit
                      *
ERROR at line 1:
ORA-00904: "BIT": invalid identifier 


SQL> select * from sosi;

   ID NAME           SALARY BIRTH    EMAIL          GRADE                       
----- ---------- ---------- -------- -------------- -----                       
 7789 hong               79 21/07/06 bc@sk.com      F                           
 7790 lee                23 21/07/06 bb@sk.com      C                           
 7754 kim                57 21/07/06 aa@sk.com      A                           
    7 김고은            100 17/12/12 aa@girl.com    A                           
    6 태연              100 19/12/12 aa@girl.com    A                           
 2100 티파니             90 17/11/13 bb@girl.com    B                           
 3000 제니              120 17/10/25 cc@girl.com    C                           
    4 수영               90 21/07/06 dd@girl.com    A                           

8 rows selected.

SQL> update sosi set name= 'bit';

8 rows updated.

SQL> select * from sosi;

   ID NAME           SALARY BIRTH    EMAIL          GRADE                       
----- ---------- ---------- -------- -------------- -----                       
 7789 bit                79 21/07/06 bc@sk.com      F                           
 7790 bit                23 21/07/06 bb@sk.com      C                           
 7754 bit                57 21/07/06 aa@sk.com      A                           
    7 bit               100 17/12/12 aa@girl.com    A                           
    6 bit               100 19/12/12 aa@girl.com    A                           
 2100 bit                90 17/11/13 bb@girl.com    B                           
 3000 bit               120 17/10/25 cc@girl.com    C                           
    4 bit                90 21/07/06 dd@girl.com    A                           

8 rows selected.

SQL> rollback;

Rollback complete.

SQL> select * from sosi;

   ID NAME           SALARY BIRTH    EMAIL          GRADE                       
----- ---------- ---------- -------- -------------- -----                       
 7789 hong               79 21/07/06 bc@sk.com      F                           
 7790 lee                23 21/07/06 bb@sk.com      C                           
 7754 kim                57 21/07/06 aa@sk.com      A                           
    7 김고은            100 17/12/12 aa@girl.com    A                           
    6 태연              100 19/12/12 aa@girl.com    A                           
 2100 티파니             90 17/11/13 bb@girl.com    B                           
 3000 제니              120 17/10/25 cc@girl.com    C                           
    4 수영               90 21/07/06 dd@girl.com    A                           

8 rows selected.

SQL> update sosi set name='고길동', salary = 100, birth = to_char('20/07/05'), email = 'bt@ko.com', grade = 'A', where id= 2100;
update sosi set name='고길동', salary = 100, birth = to_char('20/07/05'), email = 'bt@ko.com', grade = 'A', where id= 2100
                                                                                                               *
ERROR at line 1:
ORA-01747: invalid user.table.column, table.column, or column specification 


SQL> update sosi set name='고길동', salary = 100, birth = to_char('20/07/05'), email = 'bt@ko.com', grade = 'A' where id= 2100;

1 row updated.

SQL> update sosi set name= 'cake', salary=21 where id = 3000;

1 row updated.

SQL> select * from sosi;

   ID NAME           SALARY BIRTH    EMAIL          GRADE                       
----- ---------- ---------- -------- -------------- -----                       
 7789 hong               79 21/07/06 bc@sk.com      F                           
 7790 lee                23 21/07/06 bb@sk.com      C                           
 7754 kim                57 21/07/06 aa@sk.com      A                           
    7 김고은            100 17/12/12 aa@girl.com    A                           
    6 태연              100 19/12/12 aa@girl.com    A                           
 2100 고길동            100 20/07/05 bt@ko.com      A                           
 3000 cake               21 17/10/25 cc@girl.com    C                           
    4 수영               90 21/07/06 dd@girl.com    A                           

8 rows selected.

SQL> rollback
  2  ;

Rollback complete.

SQL> select * from sosi;

   ID NAME           SALARY BIRTH    EMAIL          GRADE                       
----- ---------- ---------- -------- -------------- -----                       
 7789 hong               79 21/07/06 bc@sk.com      F                           
 7790 lee                23 21/07/06 bb@sk.com      C                           
 7754 kim                57 21/07/06 aa@sk.com      A                           
    7 김고은            100 17/12/12 aa@girl.com    A                           
    6 태연              100 19/12/12 aa@girl.com    A                           
 2100 티파니             90 17/11/13 bb@girl.com    B                           
 3000 제니              120 17/10/25 cc@girl.com    C                           
    4 수영               90 21/07/06 dd@girl.com    A                           

8 rows selected.

SQL> update sosi set name = '고길동', salary = 41, birth = to_char('20/07/05'), email='bt@ko.com', grade = 'D' where id= 2100;

1 row updated.

SQL> update sosi set name = 'cake', salary = 21 where id =3000;

1 row updated.

SQL> select * from sosi;

   ID NAME           SALARY BIRTH    EMAIL          GRADE                       
----- ---------- ---------- -------- -------------- -----                       
 7789 hong               79 21/07/06 bc@sk.com      F                           
 7790 lee                23 21/07/06 bb@sk.com      C                           
 7754 kim                57 21/07/06 aa@sk.com      A                           
    7 김고은            100 17/12/12 aa@girl.com    A                           
    6 태연              100 19/12/12 aa@girl.com    A                           
 2100 고길동             41 20/07/05 bt@ko.com      D                           
 3000 cake               21 17/10/25 cc@girl.com    C                           
    4 수영               90 21/07/06 dd@girl.com    A                           

8 rows selected.

SQL> insert into sosi values(6625, 'LA', 55, sysdate, 'ca@girl.com', 'F');

1 row created.

SQL> insert into sosi values(6623, 'LB', 33, to_date('19/12/12'), 'cb@girl.com', 'F');

1 row created.

SQL> insert into sosi values(6621, 'LC', 11, to_char('19/12/12'), 'cc@girl.com', 'F');

1 row created.

SQL> commit;

Commit complete.

SQL> select * from sosi;

   ID NAME           SALARY BIRTH    EMAIL          GRADE                       
----- ---------- ---------- -------- -------------- -----                       
 7789 hong               79 21/07/06 bc@sk.com      F                           
 7790 lee                23 21/07/06 bb@sk.com      C                           
 7754 kim                57 21/07/06 aa@sk.com      A                           
    7 김고은            100 17/12/12 aa@girl.com    A                           
    6 태연              100 19/12/12 aa@girl.com    A                           
 2100 고길동             41 20/07/05 bt@ko.com      D                           
 3000 cake               21 17/10/25 cc@girl.com    C                           
    4 수영               90 21/07/06 dd@girl.com    A                           
 6625 LA                 55 21/07/06 ca@girl.com    F                           
 6623 LB                 33 19/12/12 cb@girl.com    F                           
 6621 LC                 11 19/12/12 cc@girl.com    F                           

11 rows selected.

SQL> select max(salary) from sosi;

MAX(SALARY)                                                                     
-----------                                                                     
        100                                                                     

SQL> select min(salary) from sosi;

MIN(SALARY)                                                                     
-----------                                                                     
         11                                                                     

SQL> select avg(salary) from sosi;

AVG(SALARY)                                                                     
-----------                                                                     
 55.4545455                                                                     

SQL> select count(id) from sosi;

 COUNT(ID)                                                                      
----------                                                                      
        11                                                                      

SQL> select count(id) as "cnt" from sosi;

       cnt                                                                      
----------                                                                      
        11                                                                      

SQL> select count(id) as 'cnt' from sosi;
select count(id) as 'cnt' from sosi
                    *
ERROR at line 1:
ORA-00923: FROM keyword not found where expected 


SQL> select count(id) as cnt from sosi;

       CNT                                                                      
----------                                                                      
        11                                                                      

SQL> select rownum, s.* from sosi;
select rownum, s.* from sosi
                 *
ERROR at line 1:
ORA-00904: "S": invalid identifier 


SQL> select rownum, s.* from sosi s;

    ROWNUM    ID NAME           SALARY BIRTH    EMAIL          GRADE            
---------- ----- ---------- ---------- -------- -------------- -----            
         1  7789 hong               79 21/07/06 bc@sk.com      F                
         2  7790 lee                23 21/07/06 bb@sk.com      C                
         3  7754 kim                57 21/07/06 aa@sk.com      A                
         4     7 김고은            100 17/12/12 aa@girl.com    A                
         5     6 태연              100 19/12/12 aa@girl.com    A                
         6  2100 고길동             41 20/07/05 bt@ko.com      D                
         7  3000 cake               21 17/10/25 cc@girl.com    C                
         8     4 수영               90 21/07/06 dd@girl.com    A                
         9  6625 LA                 55 21/07/06 ca@girl.com    F                
        10  6623 LB                 33 19/12/12 cb@girl.com    F                
        11  6621 LC                 11 19/12/12 cc@girl.com    F                

11 rows selected.

SQL> select * from sosi;

   ID NAME           SALARY BIRTH    EMAIL          GRADE                       
----- ---------- ---------- -------- -------------- -----                       
 7789 hong               79 21/07/06 bc@sk.com      F                           
 7790 lee                23 21/07/06 bb@sk.com      C                           
 7754 kim                57 21/07/06 aa@sk.com      A                           
    7 김고은            100 17/12/12 aa@girl.com    A                           
    6 태연              100 19/12/12 aa@girl.com    A                           
 2100 고길동             41 20/07/05 bt@ko.com      D                           
 3000 cake               21 17/10/25 cc@girl.com    C                           
    4 수영               90 21/07/06 dd@girl.com    A                           
 6625 LA                 55 21/07/06 ca@girl.com    F                           
 6623 LB                 33 19/12/12 cb@girl.com    F                           
 6621 LC                 11 19/12/12 cc@girl.com    F                           

11 rows selected.

SQL> spool off
