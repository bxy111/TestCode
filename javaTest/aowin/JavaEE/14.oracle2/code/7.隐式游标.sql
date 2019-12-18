/*
  ��ʽ�α�
    sql%rowcount ���� ��ɾ����䷵�ص���Ӱ�������
    sql%found boolean ��ɾ����Ӱ������>=1 true ����Ϊfalse select into�Ӿ��ѯ�ɹ�
    sql%notfound �෴
*/
declare
begin
  delete from emp where empno in (7369,1111,2222,7878);
  dbms_output.put_line('�ɹ�ɾ��'||sql%rowcount||'����¼');
  if sql%found then
    dbms_output.put_line('�����ݱ�ɾ�� ִ��֮��Ĳ���');
  else
    dbms_output.put_line('ɾ��ʧ�� ����������');
  end if;
  
  rollback;
   
 
end;

/*
  ��ʽ�α꣺ �û��Զ���� ���������ѯ�����

*/
/*
  ��ʽ�α궨��  1
*/
declare
  --����һ���α�
  cursor cur_emp is select * from emp;
  
  v_emp emp%rowtype;
begin
  -- ���α� ֻ�д򿪹��α� ��ѯ��sql�Ż�ִ�� �����α��� ��������  
  open cur_emp;
  -- ��������
  loop
    fetch cur_emp into v_emp; -- ÿ��fetchȡһ������
    
  exit when cur_emp%notfound;
    -- fetch���µ����� �Ż���� �������
    dbms_output.put_line(v_emp.ename);
    dbms_output.put_line(v_emp.empno);
    dbms_output.put_line('-----------------');
  end loop;
 
  --�ر��α�
  close cur_emp;

end;



/*
  ��ʽ�α궨��  1 ������
*/
declare
  --����һ���α� p_ename ��ʽ���� ����ʱ��Ҫָ������
  cursor cur_emp(p_ename varchar2) is select * from emp where ename like '%'||p_ename||'%';
  
  v_emp emp%rowtype;
begin
  -- ���α�  ����ʵ�ʲ���
  open cur_emp('A');
  -- ��������
  loop
    fetch cur_emp into v_emp; -- ÿ��fetchȡһ������
    
  exit when cur_emp%notfound;
    -- fetch���µ����� �Ż���� �������
    dbms_output.put_line(v_emp.ename);
    dbms_output.put_line(v_emp.empno);
    dbms_output.put_line('-----------------');
  end loop;
 
  --�ر��α�
  close cur_emp;

end;

/*
  ��ʾ�α� ���� 2
*/
declare
  --����һ���α� p_ename ��ʽ���� ����ʱ��Ҫָ������
  cursor cur_emp(p_ename varchar2) is select * from emp where ename like '%'||p_ename||'%';
begin
  -- �Զ����α� ���ұ����α���һ���еļ�¼
  for v_emp in cur_emp('A') loop
    dbms_output.put_line(v_emp.ename);
    dbms_output.put_line(v_emp.empno);
    dbms_output.put_line('-----------------');
  end loop;
    
end;

/*
  �α궨��  3 

*/

begin
  -- �Զ����α� ���ұ����α���һ���еļ�¼
  for v_emp in (select * from emp) loop
    dbms_output.put_line(v_emp.ename);
    dbms_output.put_line(v_emp.empno);
    dbms_output.put_line('-----------------');
  end loop;
    
end;



