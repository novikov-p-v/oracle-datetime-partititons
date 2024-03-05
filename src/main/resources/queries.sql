select * from app_user.event_table where event_date between
                                             to_date('01.07.2023', 'dd.MM.yyyy') and to_date('02.07.2023', 'dd.MM.yyyy');

select SQL_ID, SQL_TEXT from V_$SQL where sql_fulltext like 'select %event_table%';

-- 5r4qrga3tv96u,"select * from app_user.event_table where event_date between  to_date('01.07.2023', 'dd.MM.yyyy') and to_date('02.07.2023', 'dd.MM.yyyy')"
-- 3t6nyn29an5p2,"select ei1_0.id,ei1_0.event_date from event_table ei1_0 where ei1_0.event_date between :1  and :2 "
-- 19hdskd1v4rg7,"select eodt1_0.id,eodt1_0.event_date from event_table eodt1_0 where eodt1_0.event_date between :1  and :2 "
-- 83dvhkbagj64q,"select et1_0.id,et1_0.event_date from event_table et1_0 where et1_0.event_date between :1  and :2 "
-- g0dvsfjwvya4s,"select eldt1_0.id,eldt1_0.event_date from event_table eldt1_0 where eldt1_0.event_date between :1  and :2 "
-- by7b59qr6zyq7,"select ezdt1_0.id,ezdt1_0.event_date from event_table ezdt1_0 where ezdt1_0.event_date between :1  and :2 "

SELECT * FROM table (DBMS_XPLAN.DISPLAY_CURSOR('5r4qrga3tv96u'));
SELECT * FROM table (DBMS_XPLAN.DISPLAY_CURSOR('3t6nyn29an5p2'));
SELECT * FROM table (DBMS_XPLAN.DISPLAY_CURSOR('19hdskd1v4rg7'));
SELECT * FROM table (DBMS_XPLAN.DISPLAY_CURSOR('83dvhkbagj64q'));
SELECT * FROM table (DBMS_XPLAN.DISPLAY_CURSOR('g0dvsfjwvya4s'));
SELECT * FROM table (DBMS_XPLAN.DISPLAY_CURSOR('by7b59qr6zyq7'));
