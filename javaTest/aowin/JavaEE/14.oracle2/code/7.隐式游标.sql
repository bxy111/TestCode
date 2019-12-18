/*
  隐式游标
    sql%rowcount 数字 增删改语句返回的受影响的行数
    sql%found boolean 增删改受影响行数>=1 true 否则为false select into子句查询成功
    sql%notfound 相反
*/
declare
begin
  delete from emp where empno in (7369,1111,2222,7878);
  dbms_output.put_line('成功删除'||sql%rowcount||'条记录');
  if sql%found then
    dbms_output.put_line('有数据被删除 执行之后的操作');
  else
    dbms_output.put_line('删除失败 ，。。。。');
  end if;
  
  rollback;
   
 
end;

/*
  显式游标： 用户自定义的 用来保存查询结果的

*/
/*
  显式游标定义  1
*/
declare
  --定义一个游标
  cursor cur_emp is select * from emp;
  
  v_emp emp%rowtype;
begin
  -- 打开游标 只有打开过游标 查询的sql才会执行 并且游标中 才有数据  
  open cur_emp;
  -- 遍历数据
  loop
    fetch cur_emp into v_emp; -- 每次fetch取一条数据
    
  exit when cur_emp%notfound;
    -- fetch到新的数据 才会输出 否则不输出
    dbms_output.put_line(v_emp.ename);
    dbms_output.put_line(v_emp.empno);
    dbms_output.put_line('-----------------');
  end loop;
 
  --关闭游标
  close cur_emp;

end;



/*
  显式游标定义  1 带参数
*/
declare
  --定义一个游标 p_ename 形式参数 定义时不要指定长度
  cursor cur_emp(p_ename varchar2) is select * from emp where ename like '%'||p_ename||'%';
  
  v_emp emp%rowtype;
begin
  -- 打开游标  传入实际参数
  open cur_emp('A');
  -- 遍历数据
  loop
    fetch cur_emp into v_emp; -- 每次fetch取一条数据
    
  exit when cur_emp%notfound;
    -- fetch到新的数据 才会输出 否则不输出
    dbms_output.put_line(v_emp.ename);
    dbms_output.put_line(v_emp.empno);
    dbms_output.put_line('-----------------');
  end loop;
 
  --关闭游标
  close cur_emp;

end;

/*
  显示游标 定义 2
*/
declare
  --定义一个游标 p_ename 形式参数 定义时不要指定长度
  cursor cur_emp(p_ename varchar2) is select * from emp where ename like '%'||p_ename||'%';
begin
  -- 自动打开游标 并且遍历游标中一行行的记录
  for v_emp in cur_emp('A') loop
    dbms_output.put_line(v_emp.ename);
    dbms_output.put_line(v_emp.empno);
    dbms_output.put_line('-----------------');
  end loop;
    
end;

/*
  游标定义  3 

*/

begin
  -- 自动打开游标 并且遍历游标中一行行的记录
  for v_emp in (select * from emp) loop
    dbms_output.put_line(v_emp.ename);
    dbms_output.put_line(v_emp.empno);
    dbms_output.put_line('-----------------');
  end loop;
    
end;



