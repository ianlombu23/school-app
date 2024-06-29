CREATE TABLE class (
  class_id varchar(100) NOT NULL,
  class_name varchar(20) NOT NULL,
  teacher_id varchar(100) NOT NULL,
  created_at datetime NOT NULL,
  created_by varchar(50)  DEFAULT NULL,
  update_at datetime DEFAULT NULL,
  updated_by varchar(50)  DEFAULT NULL,
  PRIMARY KEY (class_id)
);


CREATE TABLE student (
  student_id varchar(100) NOT NULL,
  full_name varchar(100) NOT NULL,
  date_of_birth date NOT NULL,
  gender varchar(20) NOT NULL,
  email varchar(50) NOT NULL,
  phone_number varchar(20) DEFAULT NULL,
  mother_maiden_name varchar(50) DEFAULT NULL,
  address varchar(100) DEFAULT NULL,
  is_active tinyint(1) NOT NULL,
  created_at datetime NOT NULL,
  created_by varchar(50) DEFAULT NULL,
  update_at datetime DEFAULT NULL,
  updated_by varchar(50) DEFAULT NULL,
  PRIMARY KEY (student_id)
);

CREATE TABLE student_class (
  student_class_id varchar(100) NOT NULL,
  student_id varchar(100) NOT NULL,
  class_id varchar(100) NOT NULL,
  created_at datetime NOT NULL,
  created_by varchar(50) DEFAULT NULL,
  update_at datetime DEFAULT NULL,
  updated_by varchar(50) DEFAULT NULL,
  PRIMARY KEY (student_class_id)
);

CREATE TABLE teacher (
  teacher_id varchar(100) NOT NULL,
  full_name varchar(100) NOT NULL,
  date_of_birth date NOT NULL,
  gender varchar(20) NOT NULL,
  email varchar(50) NOT NULL,
  phone_number varchar(20) DEFAULT NULL,
  address varchar(100) DEFAULT NULL,
  is_active tinyint(1) NOT NULL,
  created_at datetime NOT NULL,
  created_by varchar(50) DEFAULT NULL,
  update_at datetime DEFAULT NULL,
  updated_by varchar(50) DEFAULT NULL,
  PRIMARY KEY (teacher_id)
);