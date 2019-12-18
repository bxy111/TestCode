declare
    v_emp emp%rowtype;
begin
  
    -- dbms_output.put_line(1/0);
    select * into v_emp from emp;
    dbms_output.put_line('123');
exception
  
  when Zero_divide then
    dbms_output.put_line('³ıÊıÎª0');
  when others then
    dbms_output.put_line(sqlerrm);
    
end;
