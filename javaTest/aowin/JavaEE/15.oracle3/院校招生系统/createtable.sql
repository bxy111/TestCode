create or replace function random(p_start number,p_end number)
return number
is
begin
  return round(dbms_random.value(p_start,p_end),0);
end;

create table college(
       collegeid number(5),--ѧԺ���
       name varchar2(50) not null,--ѧԺ����
       grade number(3),--ԺУ���¼ȡ������
       plan_total number(5) not null,--�ƻ���������
       actual_total number(5) default 0,--�Ѿ�¼ȡ������
       connector varchar2(50),--��ϵ��
       tel varchar2(20),--��ϵ�绰
       address varchar2(50),--ѧУ��ַ
       primary key (collegeid),
       check(grade>-1 and grade<701) 
)

declare 
       v_score number:=0;
begin
  
  for i in 1111..1121 loop
      insert into college values(i,'�㽭��ѧ'||(400+25*v_score),(400+25*v_score),5,0,'����ʦ','0571-1111','��ϪУ��');
      v_score:=v_score+1;
    end loop;
end;
select * from college


create table student(
       stuid number(5),--��������
       name varchar2(50) not null,--��������
       age number(3),--����
       sex number(1),--�Ա���
       address varchar2(50),--��ͥ��ַ
       tel varchar2(20),--��ϵ�绰
       primary key (stuid),
       check(age>-1 and age<151)
)
declare 
begin
  for i in 1001..1101 loop
      insert into student values(i,'����'||i,19,random(0,1),'�㽭','151********');
    end loop;
end;
select * from student


create table score(
       stuid number(5),--��������
       chinese number(3),--���ĳɼ�
       math number(3),--��ѧ�ɼ�
       english number(3),--Ӣ��ɼ�
       complex number(3),--�ۺϳɼ�
       primary key (stuid),
       check(chinese>-1 and chinese<151),
       check(math>-1 and math<151),
       check(english>-1 and english<151),
       check(complex>-1 and complex<301)
)


declare 
       v_score number:=0;
begin
  for i in 1001..1101 loop
      insert into score values(i,random(90,150),random(60,150),random(10,150),random(100,300));
      v_score := v_score+1;
    end loop;
end;
select stuid,(chinese+math+english+complex)a ,s.* from score s order by a;

truncate table score;

create table mat(
       stuid number(5),--�������
       first_will number(5),--һ־ԸԺУ���
       second_will number(5),--��־ԸԺУ���
       rel_flag number(1) default 0,--�Ƿ�ͬ�����0ͬ��1��ͬ��
       mat_flag number(1) default 0,--¼ȡ״̬0δ¼ȡ1¼ȡ
       mat_collegeid number(5),--¼ȡԺУ���
       mat_will_flag number(1),--�������ĸ�ԺУ¼ȡ1һ־Ը��2��־Ը��3����
       mat_date date,--¼ȡ����
       operator varchar2(50),--�Կ���Ͷ�����˻�
       primary key (stuid)
)
declare

begin
  for i in 1001..1101 loop
    insert into mat values(i,random(1111,1121),random(1111,1121),0,0,'','',null,'');
  end loop;
end;
select * from mat
truncate table mat;


