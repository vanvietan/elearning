CREATE DATABASE  IF NOT EXISTS `elearning`;
USE `elearning`;
--
-- Table structure for table `elearning`
--
CREATE TABLE `course` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `user_id` int,
  `course_info` mediumtext,
  `price` int NOT NULL,
  `rating` numeric
);

CREATE TABLE `chapter` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `title` varchar(255),
  `paragraph` mediumtext,
  `video_id` int,
  `course_id` int
);

CREATE TABLE `video` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `info` varchar(255),
  `timeframe` varchar(255),
  `filepath` varchar(255) NOT NULL
);

CREATE TABLE `user` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) UNIQUE NOT NULL,
  `username` varchar(255) UNIQUE NOT NULL,
  `password` varchar(255) NOT NULL,
  `role_id` tinyint DEFAULT 1
);

CREATE TABLE `library_course` (
  `user_id` int,
  `course_id` int,
  `rating` tinyint,
  PRIMARY KEY (`user_id`, `course_id`)
);

CREATE TABLE `user_chapter` (
  `user_id` int,
  `chapter_id` int,
  `course_id` int,
  `tick` tinyint DEFAULT 0,
  PRIMARY KEY (`user_id`, `chapter_id`, `course_id`)
);

CREATE TABLE `cart_course` (
  `course_id` int,
  `user_id` int,
  PRIMARY KEY (`course_id`, `user_id`)
);

CREATE TABLE `payment` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `number` varchar(255) NOT NULL,
  `security_code` varchar(255) NOT NULL,
  `expired_date` varchar(255) NOT NULL
);

CREATE TABLE `receipt` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `user_id` int,
  `total_price` double,
  `created_at` datetime
);

CREATE TABLE `receipt_course` (
  `course_id` int,
  `receipt_id` int,
  `price` double,
  PRIMARY KEY (`course_id`, `receipt_id`)
);

CREATE TABLE `role` (
  `id` tinyint PRIMARY KEY,
  `description` varchar(255)
);

ALTER TABLE `course` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

ALTER TABLE `chapter` ADD FOREIGN KEY (`video_id`) REFERENCES `video` (`id`);

ALTER TABLE `chapter` ADD FOREIGN KEY (`course_id`) REFERENCES `course` (`id`);

ALTER TABLE `user` ADD FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);

ALTER TABLE `library_course` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

ALTER TABLE `library_course` ADD FOREIGN KEY (`course_id`) REFERENCES `course` (`id`);

ALTER TABLE `user_chapter` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

ALTER TABLE `user_chapter` ADD FOREIGN KEY (`chapter_id`) REFERENCES `chapter` (`id`);

ALTER TABLE `user_chapter` ADD FOREIGN KEY (`course_id`) REFERENCES `course` (`id`);

ALTER TABLE `cart_course` ADD FOREIGN KEY (`course_id`) REFERENCES `course` (`id`);

ALTER TABLE `cart_course` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

ALTER TABLE `payment` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

ALTER TABLE `receipt` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

ALTER TABLE `receipt_course` ADD FOREIGN KEY (`course_id`) REFERENCES `course` (`id`);

ALTER TABLE `receipt_course` ADD FOREIGN KEY (`receipt_id`) REFERENCES `receipt` (`id`);





