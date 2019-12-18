declare
  -- 定义一个记录表类型
  type emp_table is table of emp%rowtype index by binary_integer;
  -- 定义一个记录类型的变量
  v_emps emp_table;
  
  cursor cur_emp is select * from emp;
begin
  open cur_emp;
  fetch cur_emp bulk collect into v_emps; --  批量的将游标中的数据保存在记录表中
  close cur_emp;
  
  -- 从记录表中 获取数据  i 是索引 .first 第一个索引 .last最后一个索引
  for i in v_emps.first..v_emps.last loop
    dbms_output.put_line(v_emps(i).empno);
     dbms_output.put_line(v_emps(i).ename);
      dbms_output.put_line('------------');
  end loop;
end;
