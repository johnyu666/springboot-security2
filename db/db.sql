USE TEST;
drop table IF EXISTS users;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS user_role;

CREATE TABLE users (id int auto_increment primary key ,username varchar(20) ,password varchar(120));
CREATE TABLE roles (id int auto_increment primary key,name varchar(20));
CREATE TABLE user_role (user_id int NOT NULL ,role_id int NOT NULL );

insert into users(username,password) values ('john','123');
insert into users(username,password) values ('tom','123');
insert into users(username,password) values ('alice','123');

insert into roles(name) values ('ROLE_USER');
insert into roles(name) values ('ROLE_ADMIN');

insert into user_role (user_id, role_id)  values (1,1);
insert into user_role (user_id, role_id)  values (1,2);
insert into user_role (user_id, role_id)  values (2,1);
insert into user_role (user_id, role_id)  values (3,2);


-- 关联查询用户的角色


select u.id uid,u.username,u.password,ur.role_id rid,r.name role_name from users  u
                                                                    left join user_role ur on u.id = ur.user_id
                                                                    left join roles r on r.id = ur.role_id
where username = 'john';

select *
from users;