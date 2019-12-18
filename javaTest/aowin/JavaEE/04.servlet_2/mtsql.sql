create table food(-- 食品表，用于生成美团首页 1-5
foodId int auto_increment primary key,
name varchar(20) not null,
price double(4,1),
pic varchar(50)
)

create table user(-- 用户表 登陆用
account varchar(20) primary key,
password varchar(20) not null,
name varchar(20)
)

create table cart(-- 购物车

cartId int auto_increment primary key,
account varchar(20) not null,-- 哪个账户的购物车
foodId int, --表示加购的食品
status int default 0,
foreign key(foodId) REFERENCES food(foodId),-- 外键，约束购物车中食品信息的
foreign key(account) REFERENCES user(account)
)

insert user(account,password,name)
values("zhs","123","张三");
insert user(account,password,name)
values("lisi","456","李四");


insert into food(name,price,pic)
values('A米汉堡',16,'1cde.jpg');
insert into food(name,price,pic)
values('杨记小厨',17.5,'3a31d.jpg');
insert into food(name,price,pic)
values('杨铭宇黄焖鸡米饭',18,'9ecd.jpg');
insert into food(name,price,pic)
values('烤肉拌饭',18,'d64c553.jpg');
insert into food(name,price,pic)
values('有名堂(焗饭、小炒)',14,'3d875.jpg');
insert into food(name,price,pic)
values('翔仔湾(美食特惠！)',20,'880259b.jpg');
insert into food(name,price,pic)
values('食尚便当',21,'1b718f.jpg');
insert into food(name,price,pic)
values('格子那只水饺',13,'4c981e4.jpg');