/*
  1. ������
  �﷨��
  CREATE [OR REPLACE] PACKAGE ����
  {IS|AS}
  ���б�������
  �������Ͷ���
  �����α궨��
  �����쳣����
  ����˵��
  ����˵��
  END;

*/
create or replace package employee
is
       v_emp emp%rowtype; -- ����һ����������
       procedure showdetail; -- ����һ������ ��ʾԱ���� ������Ϣ
       procedure getemp(p_empno number); -- ����һ������ ���ݱ�� ��ѯԱ��
       -- ����һ������
       function sum(p_start number,p_end number) return number;
end;

/*
       2. ����Ķ���
       �﷨��
       CREATE [OR REPLACE] PACKAGE BODY ����
      {IS|AS}
      ˽�б�������
      ˽�����Ͷ���
      ˽���α궨��
      ˽���쳣����
      ��������
      ���̶���
      END;   
*/
create or replace package body employee
is
       v_num number := 0; -- ˽�б��� ֻ���ڰ���ֻ��
       -- ʵ�ֹ���
      procedure showdetail is
      begin
        if v_emp.empno is not null then
          dbms_output.put_line('Ա����Ϣ���£�');
          dbms_output.put_line(v_emp.ename);
          dbms_output.put_line(v_emp.empno);
          dbms_output.put_line(v_emp.sal);
        else 
          dbms_output.put_line('û���κ�Ա����Ϣ');
        end if;
      end;
      
      
      procedure getemp(p_empno number) is
      begin
        select * into v_emp from emp where empno = p_empno;
      exception
        when others then
          dbms_output.put_line('��ѯԱ��ʧ�ܣ�');
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


-- ����
begin
  employee.getemp(7369);
  employee.showdetail();
  dbms_output.put_line(employee.sum(1, 100));
end;
