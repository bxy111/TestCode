create or replace function random(p_start number,p_end number)
return number
is
begin
  return round(dbms_random.value(p_start,p_end),0);
end;

create table college(
       collegeid number(5),--学院编号
       name varchar2(50) not null,--学院名称
       grade number(3),--院校最低录取分数线
       plan_total number(5) not null,--计划招生人数
       actual_total number(5) default 0,--已经录取的人数
       connector varchar2(50),--联系人
       tel varchar2(20),--联系电话
       address varchar2(50),--学校地址
       primary key (collegeid),
       check(grade>-1 and grade<701) 
)

declare 
       v_score number:=0;
begin
  
  for i in 1111..1121 loop
      insert into college values(i,'浙江大学'||(400+25*v_score),(400+25*v_score),5,0,'李老师','0571-1111','西溪校区');
      v_score:=v_score+1;
    end loop;
end;
select * from college


create table student(
       stuid number(5),--考生考号
       name varchar2(50) not null,--考生姓名
       age number(3),--年龄
       sex number(1),--性别编号
       address varchar2(50),--家庭地址
       tel varchar2(20),--联系电话
       primary key (stuid),
       check(age>-1 and age<151)
)
declare 
begin
  for i in 1001..1101 loop
      insert into student values(i,'张三'||i,19,random(0,1),'浙江','151********');
    end loop;
end;
select * from student


create table score(
       stuid number(5),--考生考号
       chinese number(3),--语文成绩
       math number(3),--数学成绩
       english number(3),--英语成绩
       complex number(3),--综合成绩
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
       stuid number(5),--考生编号
       first_will number(5),--一志愿院校编号
       second_will number(5),--二志愿院校编号
       rel_flag number(1) default 0,--是否同意调剂0同意1不同意
       mat_flag number(1) default 0,--录取状态0未录取1录取
       mat_collegeid number(5),--录取院校编号
       mat_will_flag number(1),--考生被哪个院校录取1一志愿，2二志愿，3调剂
       mat_date date,--录取日期
       operator varchar2(50),--对考生投档的账户
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


