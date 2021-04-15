Drop table associative;
Drop table movies;
Drop table genres;
CREATE TABLE movies (id int(3) primary key not null AUTO_INCREMENT,
		     title VARCHAR(20),
		     release_date date,
		     duration int(4),
		     score int(2));
CREATE TABLE  genres(id int(3) primary key not null AUTO_INCREMENT,
		     name varchar(100));
CREATE TABLE associative(id_movie int(3),
 			 id_genres int(3));

ALTER TABLE movies AUTO_INCREMENT=123;
Alter table associative add constraint fk_movies FOREIGN KEY (id_movie)REFERENCES movies(id) ON DELETE CASCADE;
Alter table associative add constraint fk_genres FOREIGN KEY (id_genres)REFERENCES genres(id) ON DELETE CASCADE;

Insert into movies (title,release_date,duration,score) values('Harry Potter','17-12-01',200,3);
Insert into movies (title,release_date,duration,score) values('Godfather','74-05-13',154,5);
Insert into movies (title,release_date,duration,score) values('Fightclub','94-10-11',189,4);
Insert into genres (name) values('Drama');
Insert into genres (name) values('Action');
Insert into genres (name) values('Thriller');
Insert into associative values('123','1');
Insert into associative values('124','1');
Insert into associative values('125','2');