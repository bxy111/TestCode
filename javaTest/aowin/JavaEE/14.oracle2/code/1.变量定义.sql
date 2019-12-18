/*
  plsql �飺
  
  declare 
        �������֣���������ģ� ����ʡ�Ե�;
  begin
        ����Ŀ�ִ�в���;
        
  exception
        �쳣������ ��ѡ��
  end
  

*/

-- 1. ���
begin
  dbms_output.put_line('hello world'); -- ������һ���
end;

-- 2. ��������
/*
   ���������Ƿ���declare����
   �﷨��
      ������ ������������ [����Լ��];
      
   
   ���������� v_name
*/
declare
   v_num number;
   v_name varchar2(32);
   v_flag boolean;
   
   v_a number not null := 1; -- ���not null Լ�����ҳ�ʼ��ֵ
   v_b varchar2(32) default '����';  -- Ĭ��ֵԼ��
   v_c constant number := 10; -- ����һ������
   
begin
   -- ������ֵ := ��ֵ�����  
   v_num := 10;
   v_name := 'zhangsan';
   v_flag := true;

  dbms_output.put_line('v_num='||v_num);
  dbms_output.put_line('v_name='||v_name);
  
  if v_flag then
    dbms_output.put_line('true');
     
  end if;
end;

-- 3. �������� ������������ rowtype
declare
   v_emp emp%rowtype; -- ����һ������ �ñ������Դ洢emp����һ�е����� ������һ������


   -- ��������
   v_empno emp.empno%type; -- ����һ���������ͺ�emp���empno�е���������һ��
begin
  -- ��¼���͸�ֵ
  v_emp.empno := 1000;
  v_emp.ename := 'SCOTT';
  v_emp.sal := 12000;
  
  dbms_output.put_line(v_emp.empno||','||v_emp.ename);
  
  v_empno := 1234;
end;



