/*
  �洢���� �����﷨:

CREATE [OR REPLACE] PROCEDURE �洢������[(����[IN|OUT|IN OUT] ��������...)]
{AS|IS}
[˵������]
BEGIN
��ִ�в���
[EXCEPTION
 ��������]
END [������];

*/

-- 1. ������
create or replace procedure pro_hello
is
begin
  dbms_output.put_line('hello world!!');
end;

-- ����
call pro_hello();

select * from user_source; -- �����洢�û�����Ĵ洢���̡����������ݵı�
select * from user_source where name = 'PRO_HELLO'; 

-- 2. �������Ĺ���
/*
   �洢���̵Ĳ��� �����������
           in Ĭ������ �������͵Ĳ��� ���ڹ������ǲ��ܽ����޸ĵ� 
           out ������͵Ĳ����������п����޸ģ� �ڹ��̵��ú󣬿��Ի�ȡ���仯���ֵ��
           in out ���������������
*/
create or replace procedure getEmp(p_empno number, p_emp out emp%rowtype, p_type in out varchar2)
is
begin
  select * into p_emp from emp where empno = p_empno;
  p_type := p_type || '����ѯ�ɹ�';
exception
  when others then
    p_type := p_type || '����ѯʧ��';
end;

-- ע�⣺ ������������Ĵ洢���̱�����plsql���е��� ����ʹ��call����
declare
   v_emp emp%rowtype;
   v_type varchar2(128) default 'ִ�н��';
begin
  getEmp(7369,v_emp,v_type); -- ���ô洢����
  dbms_output.put_line(v_type);
  dbms_output.put_line(v_emp.ename);
end;


-- 3. Ĭ��ֵ����
create or replace procedure pro_person(p_name varchar2 default 'lisi', p_age number default 18)
is 
begin
   dbms_output.put_line(p_name||','||p_age);
end;

call pro_person(); -- ʹ��Ĭ��ֵ
call pro_person('zhagnsan');
call pro_person('wangwu', 30); -- λ�ò��� ���ղ�����λ�ô������
call pro_person(p_age => 29); -- �ؼ�����ʽ�������






