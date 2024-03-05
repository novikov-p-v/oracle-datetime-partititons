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
    for i in 1..36500
    loop
        insert into app_user.event_table (id, event_date) values (i, to_date('01.01.2024', 'dd.MM.yyyy') - i/ 100);
    end loop;
end;

commit;

