-- 1. 一志愿录取 查询第一志愿填报该学校 并且分数>=录取分数线的学生 从高到低排序 取前面计划招生人数内的人
-- 3张表 college/score/mat

select * from (
select s.stuid , e.plan_total
from college e,
score s,
mat m
where
    s.stuid = m.stuid
and
    m.first_will = e.collegeid
    
-- 筛选条件
e.collegeid = 1
and
    (chinese+english+...) >= e.grade   order by (chinese+english+...) desc )  t  
    where rownum <= plan_total
    
    
