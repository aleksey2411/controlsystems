create table if not exists `ticket`
(
    ticket_id                 int               not null auto_increment,
    user_id                   int               not null,
    resource_id               int               not null,
    order_date_time           datetime          not null,
    status                    varchar(40)       not null,

    primary key (ticket_id)
    );

alter table `ticket`
    add constraint unique key ak_ticket_user_id_order_date_time (user_id, order_date_time);

alter table `ticket`
    add constraint ticket_check_number_of_seats check(number_of_seats>0);

alter table `ticket`
    add constraint foreign key fk_ticket_user (user_id)
    references `user` (user_id);

alter table `ticket`
    add constraint foreign key fk_ticket_trip (trip_id)
    references `trip` (trip_id);

alter table `ticket`
    add constraint foreign key fk_ticket_route_bus_stop (route_bus_stop_id)
    references `route_bus_stop` (route_bus_stop_id);