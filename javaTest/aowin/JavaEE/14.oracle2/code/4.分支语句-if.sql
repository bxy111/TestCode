/*
  �����ж���� if
  
  if ����1 then
    ����;
  elsif ����2 then
    ����;
  else
    ����;
  end if;
  
*/
declare
  v_salary number(8, 2) := 20000;
begin
  if v_salary < 5000 then
    dbms_output.put_line('�㻹�����ȥ��');
  elsif v_salary between 5000 and 10000 then
    dbms_output.put_line('����˰��ʣ���٣�');
  elsif v_salary between 10001 and 20000 then
    dbms_output.put_line('��������');
  else
    dbms_output.put_line('����Դ�Ǯ���ˣ�');
  end if;
end;



