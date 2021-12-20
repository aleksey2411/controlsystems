create table if not exists `user`(
        user_id		     int			 not null auto_increment,
        `name`	     varchar(255)	 not null,
        topic	     varchar(255)	 not null,
        publication_date  	     date 	 not null,
        author_id         int    not null,
        primary key (user_id)
);

alter table `user`
    add constraint unique key ak_user_username (username);