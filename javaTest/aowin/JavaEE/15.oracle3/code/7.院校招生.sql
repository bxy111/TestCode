-- 1. һ־Ը¼ȡ ��ѯ��һ־Ը���ѧУ ���ҷ���>=¼ȡ�����ߵ�ѧ�� �Ӹߵ������� ȡǰ��ƻ����������ڵ���
-- 3�ű� college/score/mat

select * from (
select s.stuid , e.plan_total
from college e,
score s,
mat m
where
    s.stuid = m.stuid
and
    m.first_will = e.collegeid
    
-- ɸѡ����
e.collegeid = 1
and
    (chinese+english+...) >= e.grade   order by (chinese+english+...) desc )  t  
    where rownum <= plan_total
    
    
