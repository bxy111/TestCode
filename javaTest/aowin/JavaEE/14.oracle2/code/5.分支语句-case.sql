/*
  case 分支  语法 1
    
  case
    when 表达式1 then
      ...
    when 表达式2 then
      ...
    else
      ...
   end case;
  
*/

declare
  v_salary number(8, 2) := 20000;
begin
  
  case
  when v_salary < 5000 then
    dbms_output.put_line('你还活的下去吗？');
  when v_salary between 5000 and 10000 then
    dbms_output.put_line('交完税还剩多少？');
  when v_salary between 10001 and 20000 then
    dbms_output.put_line('可以买车了');
  else
    dbms_output.put_line('你可以存钱买房了！');
  end case;
end;


/*
  case 分支  语法 2
    
  case 变量
    when 值1 then
      ...
    when 值2 then
      ...
    else
      ...
   end case;
  
*/

declare
   v_num number := 2;
   v_str varchar2(10);
begin
  case v_num
    when 1 then
      v_str := '壹';
    when 2 then
      v_str := '贰';
  end case;
  dbms_output.put_line(v_str);
end;

-- 使用case when 给变量赋值
declare
   v_sex number := 2;
   v_sex_str varchar2(10);
begin
   v_sex_str:= case v_sex
    when 1 then '男' 
    when 2 then '女' 
    else '保密' 
   end;
   dbms_output.put_line(v_sex_str);
end;
