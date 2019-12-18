declare
  -- ����һ����¼������
  type emp_table is table of emp%rowtype index by binary_integer;
  -- ����һ����¼���͵ı���
  v_emps emp_table;
  
  cursor cur_emp is select * from emp;
begin
  open cur_emp;
  fetch cur_emp bulk collect into v_emps; --  �����Ľ��α��е����ݱ����ڼ�¼����
  close cur_emp;
  
  -- �Ӽ�¼���� ��ȡ����  i ������ .first ��һ������ .last���һ������
  for i in v_emps.first..v_emps.last loop
    dbms_output.put_line(v_emps(i).empno);
     dbms_output.put_line(v_emps(i).ename);
      dbms_output.put_line('------------');
  end loop;
end;
