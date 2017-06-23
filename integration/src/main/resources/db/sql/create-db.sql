CREATE TABLE W_EMPLOYEE_D
(
  ROW_WID      BIGSERIAL,
  SID          VARCHAR(255) NOT NULL,
  DISPLAY_NAME VARCHAR(255) NOT NULL,
  DEPARTMENT   VARCHAR(255) NOT NULL,
  POSITION     VARCHAR(255),
  EMAIL        VARCHAR(255) NOT NULL,
  MANAGER      VARCHAR(255),
  CONSTRAINT EMPLOYEE_PK PRIMARY KEY (ROW_WID, SID)
);