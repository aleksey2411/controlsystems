create table if not exists user_role(
      user_id		 int	 not null,
      role_id		 int	 not null,

      primary key (user_id, role_id)
    );

alter table user_role
    add constraint foreign key fk_user_role_user (user_id)
    references `user` (user_id);

alter table user_role
    add constraint foreign key fk_user_role_role (role_id)
    references `role` (role_id);