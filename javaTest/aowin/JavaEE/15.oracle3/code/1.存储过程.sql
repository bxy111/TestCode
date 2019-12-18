/*
  存储过程 创建语法:

CREATE [OR REPLACE] PROCEDURE 存储过程名[(参数[IN|OUT|IN OUT] 数据类型...)]
{AS|IS}
[说明部分]
BEGIN
可执行部分
[EXCEPTION
 错误处理部分]
END [过程名];

*/

-- 1. 简单例子
create or replace procedure pro_hello
is
begin
  dbms_output.put_line('hello world!!');
end;

-- 调用
call pro_hello();

select * from user_source; -- 用来存储用户定义的存储过程、函数等数据的表
select * from user_source where name = 'PRO_HELLO'; 

-- 2. 带参数的过程
/*
   存储过程的参数 输入输出类型
           in 默认类型 输入类型的参数 ，在过程中是不能进行修改的 
           out 输出类型的参数，过程中可以修改， 在过程调用后，可以获取到变化后的值的
           in out 即是输入又是输出
*/
create or replace procedure getEmp(p_empno number, p_emp out emp%rowtype, p_type in out varchar2)
is
begin
  select * into p_emp from emp where empno = p_empno;
  p_type := p_type || '：查询成功';
exception
  when others then
    p_type := p_type || '：查询失败';
end;

-- 注意： 包含输出参数的存储过程必须在plsql块中调用 不能使用call调用
declare
   v_emp emp%rowtype;
   v_type varchar2(128) default '执行结果';
begin
  getEmp(7369,v_emp,v_type); -- 调用存储过程
  dbms_output.put_line(v_type);
  dbms_output.put_line(v_emp.ename);
end;


-- 3. 默认值参数
create or replace procedure pro_person(p_name varchar2 default 'lisi', p_age number default 18)
is 
begin
   dbms_output.put_line(p_name||','||p_age);
end;

call pro_person(); -- 使用默认值
call pro_person('zhagnsan');
call pro_person('wangwu', 30); -- 位置参数 按照参数的位置传入参数
call pro_person(p_age => 29); -- 关键字形式传入参数






