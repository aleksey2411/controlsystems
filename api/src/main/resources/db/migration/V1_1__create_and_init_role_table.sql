create table if not exists `role`(
    role_id 	int 			not null auto_increment,
    `role` 		varchar(255)	not null,

    primary key(role_id)
    );

alter table `role`
    add constraint unique key ak_role_role (`role`);

insert into `role`(`role`)
values ('ROLE_USER'),
       ('ROLE_ADMIN');