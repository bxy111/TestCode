-- 1. �ַ���

create table datatype_test(
       a char,
       b char(10),
       c varchar2(10)
);

insert into datatype_test values ('1','1','1');

insert into datatype_test values ('1','��','��');

select * from datatype_test;
-- ���� ע��  length(str) �����ַ����ĳ���
select length(a),length(b),length(c) from datatype_test;

-- 2. rownum α�� ��ѯ�������� ��1��ʼ  rowid ÿһ�е�Ψһ��id ����� 
-- rownum ����where����в�ѯʱ ����Ҫ����1 ����鲻������
select * from emp;
select * from dept;

select ename,rownum,rowid from emp where empno > 7369;

-- �Բ�ѯ���ȡǰ3��
select * from emp where rownum <= 3;

-- ȡ��ѯ����Ĵӵ�4����ʼ֮��Ľ��
select * from (select emp.*,rownum r from emp)  where r > 3;

-- ��ѯ������ߵ�ǰ����Ա�� where ���� order by ִ��
select * from (
select * from emp where sal is not null order by sal desc) where rownum <= 3;

-- ��ҳ��ѯ ����ҳ��ΪpageNum ÿҳ��ʾpageSize����¼
select 
* from (select emp.*, rownum r from emp where rownum <= pageNum*pageSize)
where r >= (pageNum-1)*pageSize + 1

select * from (select emp.*,rownum r from emp where rownum <= 4*2) 
where r >= (4-1)*2+1;


-- 3. ����

-- 3.1 ��������
create sequence myseq; -- ʹ��Ĭ�����Դ�������
drop sequence myseq;

create sequence myseq
start with 1 -- ������ʼֵ
minvalue 1 -- ������Сֵ
maxvalue 99999999999 -- �������ֵ
increment by 1 -- ��������
nocycle
cache 100;

-- 3.2 ��������ȡֵ
select myseq.nextval from dual; -- ��ȡ���е���һ��ֵ
select myseq.currval from dual; -- ��ȡ��ǰ����ֵ

-- 3.3 ���ݿ�����ʹ������ֵ
select * from dept;
delete from dept where deptno not in (10��20,30,40);

insert into dept values (myseq.nextval,'a','a')


select * from emp_1;
-- 4. ��ձ�����
delete from emp_1; -- dml���� ֧������� ��������ȥɾ������
truncate table emp_1; -- ddl���� ��֧������ ��ձ������

-- upper ���ú��� ���ַ���ת�ɴ�д
select * from emp_1 where upper(ename) = upper('B')


-- 5. decode ����
select decode(8, 1, '��', 0, 'Ů', '����') from dual;
select case 1 when 1 then '��' when 0 then 'Ů' else '����' end from dual;

select emp.*, decode(mgr, 7902, 'FORD',7782,'CLARK','����' ) from emp;

-- 6. nvl ��ֵת��
select emp.*,sal+nvl(comm,0) from emp;

-- 7. to_char ������ת��Ϊ�ַ�������
select to_char(hiredate, 'yyyy-mm-dd hh24:mi:ss dy'),hiredate from emp;



select count(*),avg(sal),max(sal),min(sal),deptno,job  from emp group by deptno, job;

/*
       ��ѯ
       select
       from
       where
       group by
       having 
       order by 
       
       oracle: ˳��
       
       from > where > group by > having > select > order by 
       
       mysql: ˳��
       from > where > select > group by > having > order by > limit

*/

select count(*),avg(sal),max(sal),min(sal) msal,deptno,job  from emp group by deptno, job having min(sal) > 2000;

