create database curso
use curso

create table articulo(
id int primary key identity(1,1),
nombre nvarchar (30) not null,
articulo nvarchar (30) not null,
precio int not null
);

insert into articulo values('Aceite',10,13);
insert into articulo values('Jabon',20,14);
insert into articulo values('Desodorante',30,15);

select * from articulo;