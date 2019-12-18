--  plsql 查询 select .. into .. 修改删除 新增

-- select .. into .. 要求必须只能查询一条结果出来 否则会报错
declare
    v_emp emp%rowtype;
    v_empno emp.empno%type := 7369;
begin
  -- 把查询语句的结果保存在了v_emp的变量中了
  select * into v_emp from emp where empno = v_empno;
  dbms_output.put_line(v_emp.ename);
  dbms_output.put_line(v_emp.job);
  dbms_output.put_line(v_emp.sal);
  dbms_output.put_line(v_emp.hiredate);
  
  v_emp.sal := v_emp.sal + 2000;
  v_emp.deptno := 10;
  update emp set row = v_emp where empno = v_emp.empno;
  
  v_emp.empno := 7368;
  v_emp.ename := 'lisi';
  insert into emp values v_emp; -- 新增一行记录
  commit;
end;

select * from emp where empno = 7368;
