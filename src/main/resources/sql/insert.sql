INSERT INTO `charity-donation`.`institution` (`description`, `name`)
VALUES ('Purpose and Mission: Help persons in a difficult life situation', 'Foundation "Dbam o Health"' );
INSERT INTO `charity-donation`.`institution` (`description`, `name`)
VALUES ('Purpose and Mission: Help children from poor families.', 'Foundation "for children"');
INSERT INTO `charity-donation`.`institution` (`description`, `name`)
VALUES ('Purpose and Mission: Help to wake up children from coma', 'Foundation "And whom"' );
INSERT INTO `charity-donation`.`institution` (`description`, `name`)
VALUES ('Purpose and Mission: Help for the Axis without residence', 'Foundation "Without a house"' );

insert into `charity-donation`.`category`(name)
values ('clothes, for reuse'),
       ('clothes, to throw away '),
       ('toy'),
       ('books'),
       ('other');


insert into `charity-donation`.`users`(id, created_on, update_on, email, enabled, first_name, last_name, password)
values (1,now(),now(),'syrinx@att.net',true,'Benjamin','Downs','$2a$10$rUO8AgYTFpILr0.aZL9i1uWKFL/c6YchBkNZwsegONNGUhz99aA7.'),
(2,now(),now(),'rddesign@yahoo.com',true,'Sadie','English','$2a$10$rUO8AgYTFpILr0.aZL9i1uWKFL/c6YchBkNZwsegONNGUhz99aA7.'),
(3,now(),now(),'harryh@aol.com',true,'Harold','Terry','$2a$10$rUO8AgYTFpILr0.aZL9i1uWKFL/c6YchBkNZwsegONNGUhz99aA7.'),
(4,now(),now(),'meinkej@optonline.net',true,'Juan','Davidson','$2a$10$rUO8AgYTFpILr0.aZL9i1uWKFL/c6YchBkNZwsegONNGUhz99aA7.'),
(5,now(),now(),'godeke@outlook.com',true,'Rosa','Mahoney','$2a$10$rUO8AgYTFpILr0.aZL9i1uWKFL/c6YchBkNZwsegONNGUhz99aA7.'),
(6,now(),now(),'adamk@live.com',true,'Myrna','Wise','$2a$10$rUO8AgYTFpILr0.aZL9i1uWKFL/c6YchBkNZwsegONNGUhz99aA7.'),
(7,now(),now(),'chinthaka@att.net',true,'Roderick','Garcia','$2a$10$rUO8AgYTFpILr0.aZL9i1uWKFL/c6YchBkNZwsegONNGUhz99aA7.'),
(8,now(),now(),'choset@att.net',true,'Eduardo','Spence','$2a$10$rUO8AgYTFpILr0.aZL9i1uWKFL/c6YchBkNZwsegONNGUhz99aA7.'),
(9,now(),now(),'tromey@me.com',true,'Karina','Bonilla','$2a$10$rUO8AgYTFpILr0.aZL9i1uWKFL/c6YchBkNZwsegONNGUhz99aA7.'),
(10,now(),now(),'gavollink@outlook.com',true,'Garland','Saunders','$2a$10$rUO8AgYTFpILr0.aZL9i1uWKFL/c6YchBkNZwsegONNGUhz99aA7.'),
(11,now(),now(),'neuffer@mac.com',true,'Dianne','Landry','$2a$10$rUO8AgYTFpILr0.aZL9i1uWKFL/c6YchBkNZwsegONNGUhz99aA7.'),
(12,now(),now(),'doche@att.net',true,'Don','Rich','$2a$10$rUO8AgYTFpILr0.aZL9i1uWKFL/c6YchBkNZwsegONNGUhz99aA7.'),
(13,now(),now(),'seemant@gmail.com',true,'Sofia','Bridges','$2a$10$rUO8AgYTFpILr0.aZL9i1uWKFL/c6YchBkNZwsegONNGUhz99aA7.'),
(14,now(),now(),'violinhi@aol.com',true,'Chi','Valentine','$2a$10$rUO8AgYTFpILr0.aZL9i1uWKFL/c6YchBkNZwsegONNGUhz99aA7.'),
(15,now(),now(),'bancboy@comcast.net',true,'Abigail','Zamora','$2a$10$rUO8AgYTFpILr0.aZL9i1uWKFL/c6YchBkNZwsegONNGUhz99aA7.'),
(16,now(),now(),'paulv@mac.com',true,'Violet','Phillips','$2a$10$rUO8AgYTFpILr0.aZL9i1uWKFL/c6YchBkNZwsegONNGUhz99aA7.'),
(17,now(),now(),'codex@me.com',true,'Cedric','Ho','$2a$10$rUO8AgYTFpILr0.aZL9i1uWKFL/c6YchBkNZwsegONNGUhz99aA7.'),
(18,now(),now(),'mcrawfor@icloud.com',true,'Phillip','Bright','$2a$10$rUO8AgYTFpILr0.aZL9i1uWKFL/c6YchBkNZwsegONNGUhz99aA7.'),
(19,now(),now(),'weazelman@gmail.com',true,'Romeo','Quinn','$2a$10$rUO8AgYTFpILr0.aZL9i1uWKFL/c6YchBkNZwsegONNGUhz99aA7.'),
(20,now(),now(),'msroth@optonline.net',true,'Cesar','Hampton','$2a$10$rUO8AgYTFpILr0.aZL9i1uWKFL/c6YchBkNZwsegONNGUhz99aA7.'),
(21,now(),now(),'grdschl@aol.com',true,'Leroy','Walls','$2a$10$rUO8AgYTFpILr0.aZL9i1uWKFL/c6YchBkNZwsegONNGUhz99aA7.'),
(22,now(),now(),'chrwin@optonline.net',true,'Chet','Gates','$2a$10$rUO8AgYTFpILr0.aZL9i1uWKFL/c6YchBkNZwsegONNGUhz99aA7.'),
(23,now(),now(),'keutzer@msn.com',true,'Melody','Schmidt','$2a$10$rUO8AgYTFpILr0.aZL9i1uWKFL/c6YchBkNZwsegONNGUhz99aA7.'),
(24,now(),now(),'cisugrad@optonline.net',true,'Maynard','Winters','$2a$10$rUO8AgYTFpILr0.aZL9i1uWKFL/c6YchBkNZwsegONNGUhz99aA7.'),
(25,now(),now(),'bebing@aol.com',true,'Lee','Krause','$2a$10$rUO8AgYTFpILr0.aZL9i1uWKFL/c6YchBkNZwsegONNGUhz99aA7.'),
(26,now(),now(),'andrei@gmail.com',true,'Delmer','Guzman','$2a$10$rUO8AgYTFpILr0.aZL9i1uWKFL/c6YchBkNZwsegONNGUhz99aA7.'),
(27,now(),now(),'bader@live.com',true,'Priscilla','Andersen','$2a$10$rUO8AgYTFpILr0.aZL9i1uWKFL/c6YchBkNZwsegONNGUhz99aA7.'),
(28,now(),now(),'konit@optonline.net',true,'Winford','Peck','$2a$10$rUO8AgYTFpILr0.aZL9i1uWKFL/c6YchBkNZwsegONNGUhz99aA7.'),
(29,now(),now(),'seano@msn.com',true,'Desmond','Tucker','$2a$10$rUO8AgYTFpILr0.aZL9i1uWKFL/c6YchBkNZwsegONNGUhz99aA7.'),
(30,now(),now(),'kalpol@me.com',true,'Faith','Morse','$2a$10$rUO8AgYTFpILr0.aZL9i1uWKFL/c6YchBkNZwsegONNGUhz99aA7.');

insert into `charity-donation`.`user_role`(user_id, roles) VALUES
(1,'ROLE_USER'),
(2,'ROLE_USER'),
(3,'ROLE_USER'),
(4,'ROLE_USER'),
(5,'ROLE_USER'),
(6,'ROLE_USER'),
(7,'ROLE_USER'),
(8,'ROLE_USER'),
(9,'ROLE_USER'),
(10,'ROLE_USER'),
(11,'ROLE_USER'),
(12,'ROLE_USER'),
(13,'ROLE_USER'),
(14,'ROLE_USER'),
(15,'ROLE_USER'),
(16,'ROLE_USER'),
(17,'ROLE_USER'),
(18,'ROLE_USER'),
(19,'ROLE_USER'),
(20,'ROLE_USER'),
(21,'ROLE_USER'),
(22,'ROLE_USER'),
(23,'ROLE_USER'),
(24,'ROLE_USER'),
(25,'ROLE_USER'),
(26,'ROLE_USER'),
(27,'ROLE_USER'),
(28,'ROLE_USER'),
(29,'ROLE_USER'),
(30,'ROLE_USER');
