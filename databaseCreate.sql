
CREATE TABLE `student` (
  `id` char(20) PRIMARY KEY,
  `name` varchar(255) NOT NULL,
  `age` integer,
  `sex` varchar(255),
  `grade` varchar(255) NOT NULL,
  `phone_number` char(20),
  `major_id` char(2),
  `dormitory_id` char(3),
  `college_id` char(2)
);

CREATE TABLE `major` (
  `id` char(2) PRIMARY KEY,
  `name` varchar(255) NOT NULL,
  `student_number` integer
);

CREATE TABLE `course` (
  `id` char(2) PRIMARY KEY,
  `name` varchar(255) NOT NULL,
  `credit` char(1),
  `location_id` char(2),
  `teacher_id` char(20) NOT NULL
);

CREATE TABLE `teacher` (
  `id` char(20) PRIMARY KEY,
  `name` varchar(255) NOT NULL,
  `title` varchar(255),
  `college_id` char(2) NOT NULL
);

CREATE TABLE `college` (
  `id` char(2) PRIMARY KEY,
  `name` varchar(255) NOT NULL,
  `student_number` integer,
  `director` varchar(255)
);

CREATE TABLE `dormitory` (
  `id` char(3) PRIMARY KEY,
  `space` integer
);

CREATE TABLE `teaching_building` (
  `id` char(2) PRIMARY KEY,
  `name` varchar(255) NOT NULL,
  `classroom_number` integer
);

CREATE TABLE `club` (
  `id` char(2) PRIMARY KEY,
  `name` varchar(255) NOT NULL,
  `president_id` char(20)
);
ALTER TABLE  `student`  ADD FOREIGN KEY (`college_id`) REFERENCES `college`  (`id`);
ALTER TABLE `student`  ADD FOREIGN KEY (`major_id`) REFERENCES `major`(`id`);
ALTER TABLE `student` ADD FOREIGN KEY (`dormitory_id`) REFERENCES `dormitory` (`id`);
CREATE TABLE `student_club` (
  `student_id` char(20),
  `club_id` char(2),
  PRIMARY KEY (`student_id`, `club_id`)
);

ALTER TABLE `student_club` ADD FOREIGN KEY (`student_id`) REFERENCES `student` (`id`);

ALTER TABLE `student_club` ADD FOREIGN KEY (`club_id`) REFERENCES `club` (`id`);

ALTER TABLE `course` ADD FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`);

ALTER TABLE `teacher` ADD FOREIGN KEY (`college_id`) REFERENCES `college` (`id`);

ALTER TABLE `course` ADD FOREIGN KEY (`location_id`) REFERENCES `teaching_building` (`id`);
