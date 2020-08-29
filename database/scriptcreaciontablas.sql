create table proyecto (
id bigserial primary key,
nombre varchar(255),
estado varchar(255),
fecha_inicio date,
fecha_fin date,
id_lider bigint not null,
fecha_alta date,
fecha_modificacion date
);
	

create table parametro (
id bigserial primary key,
dominio varchar (50),
valor varchar (50) ,
orden varchar(50),
descripcion varchar(1000)
);

create table usuario (
id bigserial primary key,
nombre_completo varchar(255),
password varchar(70),
username varchar(25) unique,
email varchar(50) unique
);

create table fase (
id bigserial primary key,
id_proyecto bigint unique not null,
estado varchar(25),
fecha_alta date,
fecha_modificacion date
);

create table recurso(
id bigserial primary key,
nombre varchar (80),
descripcion varchar (1000)
);

create table usuario_proyecto (
id bigserial primary key,
id_proyecto bigint,
id_usuario bigint
);	

create table usuario_rol (
id bigserial primary key,
id_rol bigint,
id_usuario bigint
);

create table rol (
id bigserial primary key,
nombre varchar (80),
descripcion varchar (1000)
);

create table permiso_rol (
id bigserial primary key,
id_rol bigint,
id_permiso bigint,
id_recurso bigint
);


create table permiso (
id bigserial primary key,
nombre varchar(100),
descripcion varchar (1000)
);


create table linea_base (
id bigserial primary key,
id_fase integer,
estado varchar(40),
fecha_alta date,
fecha_modificacion date
);


create table item (
id bigserial primary key,
id_item_padre bigint,
nombre varchar (80),
id_fase bigint,
estado varchar (25),
id_linea_base bigint,
fecha_alta date,
fecha_modificacion date,
observacion varchar (70),
descripcion varchar (50),
prioridad varchar (20),
version	integer
);



alter table usuario_proyecto add constraint usuario_rol_proyecto_fkey foreign key (id_proyecto)
references proyecto (id) match simple
	on update no action on delete cascade;
	
	
alter table usuario_rol add constraint id_rol_fkey foreign key (id_rol)
references rol (id) match simple
	on update no action on delete cascade;

alter table usuario_proyecto add constraint id_usuario_2_fkey foreign key (id_usuario)
references usuario (id) match simple
	on update no action on delete cascade;

alter table usuario_rol add constraint id_usuario_3_fkey foreign key (id_usuario)
references usuario (id) match simple
	on update no action on delete cascade;

alter table linea_base add constraint id_fase_2_fkey foreign key (id_fase)
references fase (id) match simple
on update no action on delete no action;


alter table item add constraint item_padre_fkey foreign key (id_item_padre)
references usuario (id) match simple
on update no action on delete no action;


alter table item add constraint linea_base_3_fkey foreign key (id_linea_base)
references linea_base (id) match simple
on update no action on delete no action;

alter table item alter column version set default 1;

-- Inserts de prueba

INSERT INTO USUARIO(nombre_completo, password,username,email)
VALUES('Administrador','admin','admin','admin@gmail.com');
INSERT INTO USUARIO(nombre_completo, password,username,email)
VALUES('MatiasFare','mfare','mfare','mfare@gmail.com');
INSERT INTO USUARIO(nombre_completo, password,username,email)
VALUES('Yeshua','yedaloc','yedaloc','jessica@gmail.com');
INSERT INTO USUARIO(nombre_completo, password,username,email)
VALUES('Javier Heinecken','javier','javier','javier@gmail.com');
INSERT INTO USUARIO(nombre_completo, password,username,email)
VALUES('Jazmin','jazmin','jazmin','jazmin@gmail.com');

-- Estos permisos son de pruba, hace falta definir los permisos reales del sistema
INSERT INTO permiso(nombre, descripcion) VALUES ('visualizar', 'Permite visualizar elementos');
INSERT INTO permiso(nombre, descripcion) VALUES ('crear', 'Permite creacion de elementos');
INSERT INTO permiso(nombre, descripcion) VALUES ('editar', 'Permite edicion de elementos');
INSERT INTO permiso(nombre, descripcion) VALUES ('eliminar', 'Permite eliminacion de elementos');
INSERT INTO permiso(nombre, descripcion) VALUES ('crud', 'Permisos ABM o CRUD sobre elementos');

INSERT INTO ROL(nombre, descripcion) VALUES('sysadmin','Administrador del sistema');
INSERT INTO ROL(nombre, descripcion) VALUES('Developer','Desarrollador en proyectos');
INSERT INTO ROL(nombre, descripcion) VALUES('Team Leader','Lider de proyectos');

INSERT INTO usuario_rol (id_usuario, id_rol) values (1, 1);
INSERT INTO usuario_rol (id_usuario, id_rol) values (2, 2);
INSERT INTO usuario_rol (id_usuario, id_rol) values (3, 3);
INSERT INTO usuario_rol (id_usuario, id_rol) values (4, 3);
INSERT INTO usuario_rol (id_usuario, id_rol) values (5, 2);

INSERT INTO recurso(nombre, descripcion)
VALUES('sistema','Sistema de Trazabilidad');
INSERT INTO recurso(nombre, descripcion)
VALUES('modAdmin','Modulo de Administracion');
INSERT INTO recurso(nombre, descripcion)
VALUES('modConfig','Modulo de Configuracion');
INSERT INTO recurso(nombre, descripcion)
VALUES('modDesa','Modulo de Desarrollo');

INSERT INTO permiso_rol (id_rol, id_permiso, id_recurso)
VALUES(1,1,1);
INSERT INTO permiso_rol (id_rol, id_permiso, id_recurso)
VALUES(1,2,1);
INSERT INTO permiso_rol (id_rol, id_permiso, id_recurso)
VALUES(1,3,1);
INSERT INTO permiso_rol (id_rol, id_permiso, id_recurso)
VALUES(1,5,2);
INSERT INTO permiso_rol (id_rol, id_permiso, id_recurso)
VALUES(1,5,3);
INSERT INTO permiso_rol (id_rol, id_permiso, id_recurso)
VALUES(1,5,4);
INSERT INTO permiso_rol (id_rol, id_permiso, id_recurso)
VALUES(2,5,4);
INSERT INTO permiso_rol (id_rol, id_permiso, id_recurso)
VALUES(3,5,2);
INSERT INTO permiso_rol (id_rol, id_permiso, id_recurso)
VALUES(3,5,3);
INSERT INTO permiso_rol (id_rol, id_permiso, id_recurso)
VALUES(3,5,4);

INSERT INTO parametro (id, dominio, valor, orden, descripcion)
VALUES (default,'estado_item','ALTO',1,'estado de prioridad alto');

INSERT INTO parametro (id, dominio, valor, orden, descripcion)
VALUES (default,'estado_item','MEDIO',2,'estado de prioridad medio');

INSERT INTO parametro (id, dominio, valor, orden, descripcion)
VALUES (default,'estado_item','BAJO',3,'estado de prioridad bajo');

INSERT INTO parametro (id, dominio, valor, orden, descripcion)
VALUES (default,'estado_proyecto','EN CURSO',1,'el proyecto esta en curso');

INSERT INTO parametro (id, dominio, valor, orden, descripcion)
VALUES (default,'estado_proyecto','PRODUCCION',2,'el proyecto esta en produccion');

INSERT INTO parametro (id, dominio, valor, orden, descripcion)
VALUES (default,'estado_proyecto','ANALISIS',3,'el proyecto esta en analisis');

INSERT INTO parametro (id, dominio, valor, orden, descripcion)
VALUES (default,'estado_fase','INICIAL',1,'La fase se ha inicializado');

INSERT INTO parametro (id, dominio, valor, orden, descripcion)
VALUES (default,'estado_fase','DESARROLLO',2,'La fase esta en desarrollo');

INSERT INTO parametro (id, dominio, valor, orden, descripcion)
VALUES (default,'estado_fase','REVISION',3,'La fase esta en Revision');

INSERT INTO parametro (id, dominio, valor, orden, descripcion)
VALUES (default,'estado_fase','COMPLETA',4,'La fase esta completa');

INSERT INTO parametro (id, dominio, valor, orden, descripcion)
VALUES (default,'estado_lineabase','ABIERTO',1,'La linea base esta abierta');

INSERT INTO parametro (id, dominio, valor, orden, descripcion)
VALUES (default,'estado_lineabase','CERRADO',2,'La linea base esta cerrada');
