INSERT INTO `role`(id, description) VALUES
	(1,'USER'),
	(2,'INSTRUCTOR'),
	(3,'ADMIN');

INSERT INTO `user`(name, email, username, password, role_id) VALUES 
	('Leslie','leslie@luv2code.com', 'leslie',1234,1),
	('Emma','emma@luv2code.com','emma',1234,1),
	('Avani','avani@luv2code.com','avani',1234,2),
	('Yuri','yuri@luv2code.com','yuri',1234,1),
	('Juan','juan@luv2code.com','juan',1234,2);
    
INSERT INTO `course` (course_info, name, price, rating, user_id) VALUES
	('abc','IT',200,5,1),
    ('def','film',300,4,2),
    ('ghj','music',400,2,3),
    ('klm','art',500,5,4),
    ('opq','sport',600,1,5);