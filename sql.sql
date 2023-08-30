CREATE DATABASE hotel_alura;

use hotel_alura;

create table reservas(
id int not null auto_increment,
fecha_entrada date not null,
fecha_salida date not null,
valor varchar(50),
forma_pago varchar(50)not null,
PRIMARY KEY (id)
);

create table huespedes(
id int not null auto_increment,
nombre varchar(50)not null,
apellido varchar(50)not null,
fecha_nacimiento date not null,
nacionalidad varchar(50)not null,
telefono varchar(50)not null,
id_reserva int not null,
primary key (id),
foreign key (id_reserva) references reservas(id)
);

create table usuarios(
nombre varchar(50),
psw varchar(50)
);

insert into usuarios (nombre,psw) values ('Ivanovich','123456');
insert into usuarios (nombre,psw) values ('admin','admin');




