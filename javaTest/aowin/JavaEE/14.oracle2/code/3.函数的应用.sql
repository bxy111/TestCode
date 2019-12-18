declare
  v_sex number := 1;
  v_sex_str varchar2(3);
begin
  v_sex_str := case v_sex when 1 then 'ÄĞ' when 0 then 'Å®' else '±£ÃÜ' end;
  dbms_output.put_line(v_sex_str);
  
  dbms_output.put_line(length('hello'));
  
end;
