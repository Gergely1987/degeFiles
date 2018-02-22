insert into Blogger (id, age, name) VALUES (1,30, 'Gerike');
insert into Blogger (id, age, name) VALUES (2,23, 'Petya');
insert into STORY (id, title, content, posted, blogger_id) values (1,'Teszt cím', 'Teszt tartalom','2018-02-18' ,(select id from Blogger where name = 'Gerike'));
