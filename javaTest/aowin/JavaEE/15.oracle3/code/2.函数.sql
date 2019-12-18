/*
  函数 function 
  
  定义语法：
  CREATE [OR REPLACE] FUNCTION 函数名[(参数[IN] 数据类型...)] －－参数是可选的
   RETURN 数据类型－－return 返回值类型，不可省略
   {AS|IS}
  [说明部分]
  BEGIN
  可执行部分
  RETURN (表达式)
  [EXCEPTION
  错误处理部分]
  END [函数名];


*/

-- 1. 简单例子
create or replace function fun_sum(p_start number, p_end number)
return number
is 
   v_sum number := 0;
begin
  for i in p_start..p_end loop
    v_sum := v_sum + i;
  end loop;
  return v_sum;
end;


-- 函数调用
-- 注意：不能使用call调用 
-- plsql中调用
declare
   v_sum number;
begin
  v_sum := fun_sum(1, 100);
  dbms_output.put_line(v_sum);
end;
-- sql语句中调用
select fun_sum(1, 100) from dual;


-- 2. 使用游标的例子 sys_refcursor 是游标的数据类型
create or replace function fun_getemp(p_empno number) return sys_refcursor
is
       v_emps sys_refcursor; -- 定义一个游标类型的变量
begin
  if p_empno is null then
    
     open v_emps for select * from emp ;
  else
     open v_emps for select * from emp where empno = p_empno;
  end if;
  return v_emps;
end;

-- 调用
select fun_getemp(null) from dual;

-- plsql中调用
declare
   v_emp emp%rowtype;
   v_emps sys_refcursor;
begin
  v_emps := fun_getemp(null);
  
  loop
    fetch v_emps into v_emp ;
  exit when v_emps%notfound;
       dbms_output.put_line(v_emp.ename);
  end loop;
end;








