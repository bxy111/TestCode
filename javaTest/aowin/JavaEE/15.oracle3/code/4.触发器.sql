/*
  ������ �﷨��
  CREATE [OR REPLACE] TRIGGER ��������
  {BEFORE|AFTER|INSTEAD OF} �����¼�1 [OR �����¼�2...]
  ON ����
  [FOR EACH ROW]
  [WHEN ( ��������)]
  declare
  ��������
  BEGIN
  ���岿��
  END;


*/

-- ����
create or replace trigger tri_dept
before update or delete or insert
on dept
for each row -- �м�������
declare
begin
  case 
    when inserting then
       dbms_output.put_line('��������'||:new.deptno);
    when updating then
       dbms_output.put_line('�޸Ĳ���,��:'||:new.dname||',�ɣ�'||:old.dname);
    when deleting then
      dbms_output.put_line('ɾ������'||:old.deptno);
   end case;
end;

select * from dept;
delete from dept where deptno in (11, 8, 9 );

insert into dept values (1, '1', '1');
update dept set dname = 'dname' where deptno = 11;


-- ������ʵ�������Զ���������
create table dept_2 as select * from dept;

select * from dept_1;
truncate table dept_1;
--1. �������ж���
create sequence seq_deptno ;

-- 2.����������
-- insert into dept values (id,dname,loc)

-- insert into dept (dname,loc) values (dname,loc)
create or replace trigger tri_dept_1
before insert on dept_1
for each row
declare
begin
  if :new.deptno is null then
    :new.deptno := seq_deptno.nextval; -- ��������ļ�¼��deptnoֵΪ�� �������ļ�¼�е�������ֵΪ���е�һ��ֵ
  end if; 
end;

insert into dept_1 (dname, loc) values ('a', 'a');
select * from dept_1;









