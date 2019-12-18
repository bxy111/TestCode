declare
  cursor curr_score(v_min number,v_max number) is select * from score where score>=v_min and score<v_max;
begin
  for v_score in curr_score(0, 60) loop
    insert into flunkstu values v_score;
  end loop;
  for v_score in curr_score(60, 80) loop
    insert into goodstu values v_score;
  end loop;
  for v_score in curr_score(80, 101) loop
	insert into excellentstu values v_score;
  end loop;
  commit;
end;
