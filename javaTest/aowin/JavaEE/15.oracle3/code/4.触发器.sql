/*
  触发器 语法：
  CREATE [OR REPLACE] TRIGGER 触发器名
  {BEFORE|AFTER|INSTEAD OF} 触发事件1 [OR 触发事件2...]
  ON 表名
  [FOR EACH ROW]
  [WHEN ( 触发条件)]
  declare
  声明部分
  BEGIN
  主体部分
  END;


*/

-- 例子
create or replace trigger tri_dept
before update or delete or insert
on dept
for each row -- 行级触发器
declare
begin
  case 
    when inserting then
       dbms_output.put_line('新增部门'||:new.deptno);
    when updating then
       dbms_output.put_line('修改部门,新:'||:new.dname||',旧：'||:old.dname);
    when deleting then
      dbms_output.put_line('删除部门'||:old.deptno);
   end case;
end;

select * from dept;
delete from dept where deptno in (11, 8, 9 );

insert into dept values (1, '1', '1');
update dept set dname = 'dname' where deptno = 11;


-- 触发器实现主键自动递增例子
create table dept_2 as select * from dept;

select * from dept_1;
truncate table dept_1;
--1. 创建序列对象
create sequence seq_deptno ;

-- 2.创建触发器
-- insert into dept values (id,dname,loc)

-- insert into dept (dname,loc) values (dname,loc)
create or replace trigger tri_dept_1
before insert on dept_1
for each row
declare
begin
  if :new.deptno is null then
    :new.deptno := seq_deptno.nextval; -- 如果新增的记录中deptno值为空 则将新增的记录中的主键赋值为序列的一个值
  end if; 
end;

insert into dept_1 (dname, loc) values ('a', 'a');
select * from dept_1;









