/*
  条件判断语句 if
  
  if 条件1 then
    语句块;
  elsif 条件2 then
    语句块;
  else
    语句块;
  end if;
  
*/
declare
  v_salary number(8, 2) := 20000;
begin
  if v_salary < 5000 then
    dbms_output.put_line('你还活的下去吗？');
  elsif v_salary between 5000 and 10000 then
    dbms_output.put_line('交完税还剩多少？');
  elsif v_salary between 10001 and 20000 then
    dbms_output.put_line('可以买车了');
  else
    dbms_output.put_line('你可以存钱买房了！');
  end if;
end;



