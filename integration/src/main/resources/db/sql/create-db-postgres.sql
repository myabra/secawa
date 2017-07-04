create table w_employee_d
(
  row_wid      bigserial,
  sid          varchar(255) unique not null,
  display_name varchar(255)        not null,
  department   varchar(255)        not null,
  position     varchar(255),
  email        varchar(255)        not null,
  manager      varchar(255),
  constraint employee_pk primary key (row_wid, sid)
);

create table campaign
(
  id           bigserial unique,
  name         varchar(255) not null,
  file_name    varchar(255) not null,
  created_by   varchar(255) not null,
  created_date timestamp with time zone default current_timestamp,
  active       boolean,
  constraint campaign_pk primary key (id, name)
);

create table assigned_campaign
(
  campaign_id    integer      not null references campaign (id),
  employee_id    varchar(255) not null references w_employee_d (sid),
  assign_date    timestamp with time zone default current_timestamp,
  is_completed   boolean,
  completed_date timestamp with time zone,
  total_score    integer,
  constraint assigned_campaign_pk primary key (campaign_id, employee_id)
);