/*
  case ��֧  �﷨ 1
    
  case
    when ���ʽ1 then
      ...
    when ���ʽ2 then
      ...
    else
      ...
   end case;
  
*/

declare
  v_salary number(8, 2) := 20000;
begin
  
  case
  when v_salary < 5000 then
    dbms_output.put_line('�㻹�����ȥ��');
  when v_salary between 5000 and 10000 then
    dbms_output.put_line('����˰��ʣ���٣�');
  when v_salary between 10001 and 20000 then
    dbms_output.put_line('��������');
  else
    dbms_output.put_line('����Դ�Ǯ���ˣ�');
  end case;
end;


/*
  case ��֧  �﷨ 2
    
  case ����
    when ֵ1 then
      ...
    when ֵ2 then
      ...
    else
      ...
   end case;
  
*/

declare
   v_num number := 2;
   v_str varchar2(10);
begin
  case v_num
    when 1 then
      v_str := 'Ҽ';
    when 2 then
      v_str := '��';
  end case;
  dbms_output.put_line(v_str);
end;

-- ʹ��case when ��������ֵ
declare
   v_sex number := 2;
   v_sex_str varchar2(10);
begin
   v_sex_str:= case v_sex
    when 1 then '��' 
    when 2 then 'Ů' 
    else '����' 
   end;
   dbms_output.put_line(v_sex_str);
end;
