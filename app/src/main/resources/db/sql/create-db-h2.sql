CREATE TABLE w_employee_d
(
  row_wid      INTEGER AUTO_INCREMENT,
  sid          VARCHAR(255) NOT NULL,
  display_name VARCHAR(255) NOT NULL,
  department   VARCHAR(255) NOT NULL,
  position     VARCHAR(255),
  email        VARCHAR(255) NOT NULL,
  manager      VARCHAR(255),
  CONSTRAINT employee_pk PRIMARY KEY (row_wid, sid)
);

CREATE TABLE campaign
(
  id           INTEGER   AUTO_INCREMENT,
  name         VARCHAR(255) NOT NULL,
  file_name    VARCHAR(255) NOT NULL,
  created_by   VARCHAR(255) NOT NULL,
  created_date TIMESTAMP DEFAULT current_timestamp,
  active       BOOLEAN,
  CONSTRAINT campaign_pk PRIMARY KEY (id, name)
);

CREATE TABLE assigned_campaign
(
  campaign_id    INTEGER      NOT NULL,
  employee_id    VARCHAR(255) NOT NULL,
  assign_date    TIMESTAMP DEFAULT current_timestamp,
  is_completed   BOOLEAN,
  completed_date TIMESTAMP DEFAULT current_timestamp,
  total_score    INTEGER,
  CONSTRAINT assigned_campaign_pk PRIMARY KEY (campaign_id, employee_id)
);