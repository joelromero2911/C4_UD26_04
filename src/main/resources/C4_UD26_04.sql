DROP table IF EXISTS reservas;
DROP table IF EXISTS equipos;
DROP table IF EXISTS investigadores;
DROP table IF EXISTS facultades;

create table facultades(
    codigo int auto_increment,
    nombre varchar(100),
	primary key (codigo)
);

create table investigadores(
    dni varchar(8),
    nom_apels varchar(255),
    facultad int,
    primary key (dni),
    constraint investigadores_fk foreign key (facultad) references facultades(codigo)
);

create table equipos(
    num_serie varchar(4),
	nombre varchar(100),
	facultad int,
    primary key (num_serie),
    constraint equipos_fk foreign key (facultad) references facultades(codigo)
);

create table reservas(
    id int auto_increment,
    dni varchar(8),
    num_serie varchar(4),
    comienzo date,
    fin date,
    primary key (id),
    constraint reservas_fk foreign key (dni) references investigadores(dni),
    constraint reservas_fk_01 foreign key (num_serie) references equipos(num_serie)
);

insert into facultades (nombre)values('Facultad1');
insert into facultades (nombre)values('Facultad2');
insert into facultades (nombre)values('Facultad2');

insert into investigadores (dni, nom_apels, facultad)values('34563456', 'Alguien Importante', 1);
insert into investigadores (dni, nom_apels, facultad)values('23452345', 'Joel Romero', 11);
insert into investigadores (dni, nom_apels, facultad)values('65795678', 'Izan Dueso', 21);

insert into equipos (num_serie, nombre, facultad)values('1234', 'Equipo1', 1);
insert into equipos (num_serie, nombre, facultad)values('2345', 'Equipo2', 11);
insert into equipos (num_serie, nombre, facultad)values('3456', 'Equipo3', 21);

insert into reservas (dni, num_serie, comienzo, fin)values('34563456', '1234', now(), now());
insert into reservas (dni, num_serie, comienzo, fin)values('23452345', '2345', now(), now());
insert into reservas (dni, num_serie, comienzo, fin)values('65795678', '3456', now(), now());