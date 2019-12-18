/*
  1. loop循环
  
     loop
       循环语句;
     exit [when 条件] 循环退出条件 如果不添加when的条件 只执行一次 直接退出
          语句 ;退出条件满足时不执行 如果不满足则执行
     end loop;
*/

declare
     v_num number:= 1;
begin
  loop
    dbms_output.put_line(v_num);
    v_num := v_num + 1;
  exit when v_num >= 10;
    dbms_output.put_line('继续。。。。');
  end loop;
end;


/*
  2. while loop 循环
  
  while 条件 loop
    语句;
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
  3. for 循环
  
  for 临时变量 in lower..upper loop
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


