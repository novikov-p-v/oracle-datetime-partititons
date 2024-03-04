create user app_user identified by app_user;
grant all privileges to app_user;

create table app_user.event_table(
      id number(38,0) primary key,
      event_date timestamp
);

alter table app_user.event_table modify partition by range (event_date)
(
    partition p1 values less than (to_date('01.02.2023', 'dd.MM.yyyy')),
    partition p2 values less than (to_date('01.03.2023', 'dd.MM.yyyy')),
    partition p3 values less than (to_date('01.04.2023', 'dd.MM.yyyy')),
    partition p4 values less than (to_date('01.05.2023', 'dd.MM.yyyy')),
    partition p5 values less than (to_date('01.06.2023', 'dd.MM.yyyy')),
    partition p6 values less than (to_date('01.07.2023', 'dd.MM.yyyy')),
    partition p7 values less than (to_date('01.08.2023', 'dd.MM.yyyy')),
    partition p8 values less than (to_date('01.09.2023', 'dd.MM.yyyy')),
    partition p9 values less than (to_date('01.10.2023', 'dd.MM.yyyy')),
    partition p10 values less than (to_date('01.11.2023', 'dd.MM.yyyy')),
    partition p11 values less than (to_date('01.12.2023', 'dd.MM.yyyy')),
    partition p12 values less than (to_date('01.01.2024', 'dd.MM.yyyy'))
    );

declare
begin
    for i in 1..100000
    loop
            insert into app_user.event_table (id, event_date) values (i, to_date('01.01.2024', 'dd.MM.yyyy') - i/ 100);
    end loop;
end;

commit;

select *from app_user.event_table where event_date between
    to_date('01.07.2023', 'dd.MM.yyyy') and to_date('02.07.2023', 'dd.MM.yyyy');

select * from V_$SQL where sql_fulltext like '%event_table%';

SELECT * FROM table (DBMS_XPLAN.DISPLAY_CURSOR('fx1bbf2170wwk'));

select * from V_$SQL_PLAN where SQL_ID = '64wcbdt68haxp'
order by id;

SELECT * FROM table (DBMS_XPLAN.DISPLAY_CURSOR);

