-- 1. 字符串

create table datatype_test(
       a char,
       b char(10),
       c varchar2(10)
);

insert into datatype_test values ('1','1','1');

insert into datatype_test values ('1','你','你');

select * from datatype_test;
-- 单行 注释  length(str) 返回字符串的长度
select length(a),length(b),length(c) from datatype_test;

-- 2. rownum 伪列 查询结果的序号 从1开始  rowid 每一行的唯一的id 不变的 
-- rownum 放在where后进行查询时 必须要包含1 否则查不到数据
select * from emp;
select * from dept;

select ename,rownum,rowid from emp where empno > 7369;

-- 对查询结果取前3名
select * from emp where rownum <= 3;

-- 取查询结果的从第4条开始之后的结果
select * from (select emp.*,rownum r from emp)  where r > 3;

-- 查询工资最高的前三名员工 where 先于 order by 执行
select * from (
select * from emp where sal is not null order by sal desc) where rownum <= 3;

-- 分页查询 假设页码为pageNum 每页显示pageSize条记录
select 
* from (select emp.*, rownum r from emp where rownum <= pageNum*pageSize)
where r >= (pageNum-1)*pageSize + 1

select * from (select emp.*,rownum r from emp where rownum <= 4*2) 
where r >= (4-1)*2+1;


-- 3. 主键

-- 3.1 创建序列
create sequence myseq; -- 使用默认属性创建序列
drop sequence myseq;

create sequence myseq
start with 1 -- 设置起始值
minvalue 1 -- 设置最小值
maxvalue 99999999999 -- 设置最大值
increment by 1 -- 递增步长
nocycle
cache 100;

-- 3.2 从序列中取值
select myseq.nextval from dual; -- 获取序列的下一个值
select myseq.currval from dual; -- 获取当前序列值

-- 3.3 数据库主键使用序列值
select * from dept;
delete from dept where deptno not in (10，20,30,40);

insert into dept values (myseq.nextval,'a','a')


select * from emp_1;
-- 4. 清空表数据
delete from emp_1; -- dml操作 支持事务的 按照条件去删除数据
truncate table emp_1; -- ddl操作 不支持事务 清空表格数据

-- upper 内置函数 将字符串转成大写
select * from emp_1 where upper(ename) = upper('B')


-- 5. decode 函数
select decode(8, 1, '男', 0, '女', '保密') from dual;
select case 1 when 1 then '男' when 0 then '女' else '保密' end from dual;

select emp.*, decode(mgr, 7902, 'FORD',7782,'CLARK','其他' ) from emp;

-- 6. nvl 空值转换
select emp.*,sal+nvl(comm,0) from emp;

-- 7. to_char 将日期转换为字符串类型
select to_char(hiredate, 'yyyy-mm-dd hh24:mi:ss dy'),hiredate from emp;



select count(*),avg(sal),max(sal),min(sal),deptno,job  from emp group by deptno, job;

/*
       查询
       select
       from
       where
       group by
       having 
       order by 
       
       oracle: 顺序
       
       from > where > group by > having > select > order by 
       
       mysql: 顺序
       from > where > select > group by > having > order by > limit

*/

select count(*),avg(sal),max(sal),min(sal) msal,deptno,job  from emp group by deptno, job having min(sal) > 2000;

