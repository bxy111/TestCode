/*
  ���� function 
  
  �����﷨��
  CREATE [OR REPLACE] FUNCTION ������[(����[IN] ��������...)] ���������ǿ�ѡ��
   RETURN �������ͣ���return ����ֵ���ͣ�����ʡ��
   {AS|IS}
  [˵������]
  BEGIN
  ��ִ�в���
  RETURN (���ʽ)
  [EXCEPTION
  ��������]
  END [������];


*/

-- 1. ������
create or replace function fun_sum(p_start number, p_end number)
return number
is 
   v_sum number := 0;
begin
  for i in p_start..p_end loop
    v_sum := v_sum + i;
  end loop;
  return v_sum;
end;


-- ��������
-- ע�⣺����ʹ��call���� 
-- plsql�е���
declare
   v_sum number;
begin
  v_sum := fun_sum(1, 100);
  dbms_output.put_line(v_sum);
end;
-- sql����е���
select fun_sum(1, 100) from dual;


-- 2. ʹ���α������ sys_refcursor ���α����������
create or replace function fun_getemp(p_empno number) return sys_refcursor
is
       v_emps sys_refcursor; -- ����һ���α����͵ı���
begin
  if p_empno is null then
    
     open v_emps for select * from emp ;
  else
     open v_emps for select * from emp where empno = p_empno;
  end if;
  return v_emps;
end;

-- ����
select fun_getemp(null) from dual;

-- plsql�е���
declare
   v_emp emp%rowtype;
   v_emps sys_refcursor;
begin
  v_emps := fun_getemp(null);
  
  loop
    fetch v_emps into v_emp ;
  exit when v_emps%notfound;
       dbms_output.put_line(v_emp.ename);
  end loop;
end;








