CREATE TABLE attendance (
  attendance_id varchar(100) NOT NULL,
  attendance_by varchar(50) NOT NULL,
  student_id varchar(100) NOT NULL,
  class_id varchar(100) NOT NULL,
  attendance_status varchar(20) DEFAULT NULL,
  description varchar(100) DEFAULT NULL,
  created_at datetime NOT NULL,
  created_by varchar(50) CHARACTER SET DEFAULT NULL,
  update_at datetime DEFAULT NULL,
  updated_by varchar(50) CHARACTER SET DEFAULT NULL,
  PRIMARY KEY (attendance_id)
);