
-- 建立資料庫
CREATE DATABASE web CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;


-- 建立資料表
create table if not exists user(
	id int not null auto_increment,
	username varchar(50) not null unique,
	password varchar(255) not null,
	salary varbinary(255) not null,
	createtime timestamp default current_timestamp,
	primary key (id)
);
