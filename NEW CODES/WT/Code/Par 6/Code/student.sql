Create database student;
use student;
CREATE TABLE student_info  (
  student_id INT NOT NULL,
  student_name VARCHAR(255) NOT NULL,
  class_Name VARCHAR(10) NOT NULL,
  division VARCHAR(10) NOT NULL,
  city VARCHAR(50) NOT NULL,
  PRIMARY KEY (student_id)
);
