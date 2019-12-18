/*
  1. 包定义
  语法：
  CREATE [OR REPLACE] PACKAGE 包名
  {IS|AS}
  公有变量定义
  公有类型定义
  公有游标定义
  公有异常定义
  函数说明
  过程说明
  END;

*/
create or replace package employee
is
       v_emp emp%rowtype; -- 定义一个公共变量
       procedure showdetail; -- 定义一个过程 显示员工的 具体信息
       procedure getemp(p_empno number); -- 定义一个过程 根据编号 查询员工
       -- 定义一个函数
       function sum(p_start number,p_end number) return number;
end;

/*
       2. 包体的定义
       语法：
       CREATE [OR REPLACE] PACKAGE BODY 包名
      {IS|AS}
      私有变量定义
      私有类型定义
      私有游标定义
      私有异常定义
      函数定义
      过程定义
      END;   
*/
create or replace package body employee
is
       v_num number := 0; -- 私有变量 只能在包中只用
       -- 实现过程
      procedure showdetail is
      begin
        if v_emp.empno is not null then
          dbms_output.put_line('员工信息如下：');
          dbms_output.put_line(v_emp.ename);
          dbms_output.put_line(v_emp.empno);
          dbms_output.put_line(v_emp.sal);
        else 
          dbms_output.put_line('没有任何员工信息');
        end if;
      end;
      
      
      procedure getemp(p_empno number) is
      begin
        select * into v_emp from emp where empno = p_empno;
      exception
        when others then
          dbms_output.put_line('查询员工失败！');
          v_emp := null;
      end;      
      
      
      
      function sum(p_start number,p_end number) return number
      is
             
      begin
        for i in p_start..p_end loop
          v_num := v_num + i;
        end loop;
        return v_num;
      end;
      
end;


-- 调用
begin
  employee.getemp(7369);
  employee.showdetail();
  dbms_output.put_line(employee.sum(1, 100));
end;
