create table if not exists book(
	id int not null auto_increment,
	name varchar(50) not null unique,
	amount int not null,
	price int not null,
	user_id int,
	primary key(id),
	foreign key(user_id) references user(id)



);