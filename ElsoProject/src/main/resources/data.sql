insert into Blogger (age, name) VALUES (30, 'Gerike');
insert into Blogger (age, name) VALUES (23, 'Petya');
insert into story (title, content, posted, blogger_id) values ('Teszt cím', 'Teszt tartalom', CURRENT_DATE() ,(select id from Blogger where name = 'Gerike'));
insert into story (title, content, posted, blogger_id) values ('Teszt cím2', 'Teszt tartalom2', CURRENT_DATE() ,(select id from Blogger where name = 'Gerike'));
	insert into story (title, content, posted, blogger_id) values ('Teszt cím3', 'Teszt tartalom3', CURRENT_DATE() ,(select id from Blogger where name = 'Petya'));
insert into story (title, content, posted, blogger_id) values ('Teszt cím4', 'Teszt tartalom4', CURRENT_DATE() ,(select id from Blogger where name = 'Petya'));
insert into story (title, content, posted, blogger_id) values ('szia', 'Teszt tartalom4', CURRENT_DATE() ,(select id from Blogger where name = 'Gerike'));