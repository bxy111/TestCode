/*
  1. loopѭ��
  
     loop
       ѭ�����;
     exit [when ����] ѭ���˳����� ��������when������ ִֻ��һ�� ֱ���˳�
          ��� ;�˳���������ʱ��ִ�� �����������ִ��
     end loop;
*/

declare
     v_num number:= 1;
begin
  loop
    dbms_output.put_line(v_num);
    v_num := v_num + 1;
  exit when v_num >= 10;
    dbms_output.put_line('������������');
  end loop;
end;


/*
  2. while loop ѭ��
  
  while ���� loop
    ���;
  end loop

*/
declare
  v_num number := 1;
  v_sum number := 0;
begin
  while v_num <= 100 loop
    v_sum := v_sum + v_num;
    v_num := v_num + 1;
  end loop;
  dbms_output.put_line(v_sum);
end;

/*
  3. for ѭ��
  
  for ��ʱ���� in lower..upper loop
  end loop;

*/
declare
  v_sum number := 0;
  v_start number := 2;
begin
  for i in v_start..100 loop
    v_sum := v_sum + i;
  end loop;
  dbms_output.put_line(v_sum);
end;


