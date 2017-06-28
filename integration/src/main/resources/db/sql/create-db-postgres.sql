create table w_employee_d
(
  row_wid      bigserial,
  sid          varchar(255) not null,
  display_name varchar(255) not null,
  department   varchar(255) not null,
  position     varchar(255),
  email        varchar(255) not null,
  manager      varchar(255),
  constraint employee_pk primary key (row_wid, sid)
);

create table campaign
(
  id   bigserial,
  name varchar(255) not null,
  file_name varchar(255) not null,
  created_by varchar(255) not null,
  created_date timestamp with time zone  default current_timestamp,
  active boolean,
  constraint campaign_pk primary key (id, name)
);