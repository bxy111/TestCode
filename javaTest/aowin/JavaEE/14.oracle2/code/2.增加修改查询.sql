--  plsql ��ѯ select .. into .. �޸�ɾ�� ����

-- select .. into .. Ҫ�����ֻ�ܲ�ѯһ��������� ����ᱨ��
declare
    v_emp emp%rowtype;
    v_empno emp.empno%type := 7369;
begin
  -- �Ѳ�ѯ���Ľ����������v_emp�ı�������
  select * into v_emp from emp where empno = v_empno;
  dbms_output.put_line(v_emp.ename);
  dbms_output.put_line(v_emp.job);
  dbms_output.put_line(v_emp.sal);
  dbms_output.put_line(v_emp.hiredate);
  
  v_emp.sal := v_emp.sal + 2000;
  v_emp.deptno := 10;
  update emp set row = v_emp where empno = v_emp.empno;
  
  v_emp.empno := 7368;
  v_emp.ename := 'lisi';
  insert into emp values v_emp; -- ����һ�м�¼
  commit;
end;

select * from emp where empno = 7368;
