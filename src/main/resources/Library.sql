drop table if exists Book;
drop table if exists Person;

create table Person(
                       id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                       name varchar(100) NOT NULL,
                       birth_year int CHECK(birth_year >= 1900)
);

truncate table Person;

insert into Person(name, birth_year)
VALUES ('Вадим', 1973),
       ('Елена', 1976),
       ('Кирилл', 2001),
       ('Сергей', 1997);

select * from Person;

drop table if exists Book;

create table Book(
                     id int GENERATED BY DEFAULT AS IDENTITY,
                     name varchar(100) NOT NULL,
                     author varchar(100) NOT NULL,
                     publication int CHECK(publication >= 1900),
                     personId int REFERENCES Person (id) ON DELETE SET NULL
);

truncate table Book;

insert into Book(name, author, publication, personId)
VALUES ('Java. Полное руководство', 'Герберт Шилдт', 2018, NULL),
       ('Java. Библиотека профессионала', 'Кей Хорстманн', 2020, NULL),
       ('Java. Эффективное программирование', 'Джошуа Блох', 2019, NULL),
       ('Spring в действии', 'Крейг Уоллс', 2022, 1);

select * from Book;