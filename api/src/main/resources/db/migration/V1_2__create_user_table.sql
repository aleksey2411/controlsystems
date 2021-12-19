create table if not exists `user`(
        user_id		     int			 not null auto_increment,
        first_name	     varchar(255)	 not null,
        last_name	     varchar(255)	 not null,
        `active`         bit(1)          not null,
        username	     varchar(255)	 not null,
        password         varchar(255)    not null,
        primary key (user_id)
);

alter table `user`
    add constraint unique key ak_user_username (username);