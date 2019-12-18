/*
  plsql 块：
  
  declare 
        声明部分（定义变量的） 可以省略的;
  begin
        程序的可执行部分;
        
  exception
        异常处理部分 可选的
  end
  

*/

-- 1. 输出
begin
  dbms_output.put_line('hello world'); -- 输出并且换行
end;

-- 2. 变量定义
/*
   变量定义是放在declare部分
   语法：
      变量名 变量数据类型 [变量约束];
      
   
   变量名命名 v_name
*/
declare
   v_num number;
   v_name varchar2(32);
   v_flag boolean;
   
   v_a number not null := 1; -- 添加not null 约束并且初始化值
   v_b varchar2(32) default '李四';  -- 默认值约束
   v_c constant number := 10; -- 定义一个常量
   
begin
   -- 变量赋值 := 赋值运算符  
   v_num := 10;
   v_name := 'zhangsan';
   v_flag := true;

  dbms_output.put_line('v_num='||v_num);
  dbms_output.put_line('v_name='||v_name);
  
  if v_flag then
    dbms_output.put_line('true');
     
  end if;
end;

-- 3. 变量定义 复合数据类型 rowtype
declare
   v_emp emp%rowtype; -- 定义一个变量 该变量可以存储emp表中一行的数据 类似于一个对象


   -- 特殊类型
   v_empno emp.empno%type; -- 定义一个变量类型和emp表的empno列的数据类型一样
begin
  -- 记录类型赋值
  v_emp.empno := 1000;
  v_emp.ename := 'SCOTT';
  v_emp.sal := 12000;
  
  dbms_output.put_line(v_emp.empno||','||v_emp.ename);
  
  v_empno := 1234;
end;



