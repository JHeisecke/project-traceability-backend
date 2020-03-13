create table proyecto (
id bigserial primary key,
nombre varchar(255),
estado varchar(255) unique,
fecha_inicio date,
fecha_fin date,
id_lider bigint not null,
fecha_alta date,
fecha_modificacion date,
usuario_alta bigint,
usuario_modificacion int);
	

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
id_rol bigint ,
password varchar(70),
username varchar(25) unique,
email varchar(50) unique
);

create table fase (
id bigserial primary key,
id_proyecto bigint unique not null,
estado varchar(25) unique,
fecha_alta date,
usuario_modificacion int unique,
usuario_alta bigint unique,
fecha_modificacion date
);

create table recurso(
id bigserial primary key,
nombre varchar (80),
descripcion varchar (1000)
);

create table usuario_rol_proyecto (
id bigserial primary key,
id_proyecto bigint,
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
id_fase integer unique,
estado varchar(40),
fecha_alta date,
fecha_modificacion date,
usuario_modificacion int unique,
usuario_alta bigint unique
);


create table item (
id bigserial primary key,
id_item_padre bigint unique,
id_fase bigint unique,
estado varchar (25) unique,
id_linea_base bigint unique,
fecha_alta date,
fecha_modificacion date,
usuario_modificacion int unique,
usuario_alta bigint unique,
observacion varchar (70),
descripcion varchar (50),
prioridad varchar (20)
);


alter table proyecto add constraint usuario_alta_fkey foreign key (usuario_alta)
references usuario (id) match simple
	on update no action on delete no action;

	
alter table proyecto add constraint usuario_modificacion_fkey foreign key (usuario_modificacion)
references usuario (id) match simple
	on update no action on delete no action;


alter table fase add constraint usuario_alta_fkey2 foreign key (usuario_alta)
references usuario (id) match simple
	on update no action on delete no action;

alter table fase add constraint id_faseuseral_fkey foreign key (usuario_alta)
references usuario (id) match simple
	on update no action on delete no action;
	
alter table fase add constraint usuario_modificacion_fkey2 foreign key (usuario_modificacion)
references usuario (id) match simple
	on update no action on delete no action;


alter table usuario_rol_proyecto add constraint usuario_rol_proyecto_fkey foreign key (id_proyecto)
references proyecto (id) match simple
	on update no action on delete no action;
	
	
alter table usuario_rol_proyecto add constraint id_rol_fkey foreign key (id_rol)
references rol (id) match simple
	on update no action on delete no action;
	

alter table usuario_rol_proyecto add constraint id_usuario_2_fkey foreign key (id_usuario)
references usuario (id) match simple
	on update no action on delete no action;


alter table permiso_rol add constraint id_rol_2_fkey foreign key (id_rol)
references rol (id) match simple
on update no action on delete no action;


alter table permiso_rol add constraint id_permiso_2_fkey foreign key (id_permiso)
references permiso (id) match simple
on update no action on delete no action;


alter table linea_base add constraint id_fase_2_fkey foreign key (id_fase)
references fase (id) match simple
on update no action on delete no action;


alter table linea_base add constraint id_usuario_alta_2_fkey foreign key (usuario_alta)
references usuario (id) match simple
on update no action on delete no action;


alter table linea_base add constraint usuario_modificacion_2_fkey foreign key (usuario_modificacion)
references usuario (id) match simple
on update no action on delete no action;


alter table item add constraint item_padre_fkey foreign key (id_item_padre)
references usuario (id) match simple
on update no action on delete no action;


alter table item add constraint linea_base_3_fkey foreign key (id_linea_base)
references linea_base (id) match simple
on update no action on delete no action;


alter table item add constraint usuario_modificacion_3_fkey_fkey foreign key (usuario_modificacion)
references usuario (id) match simple
on update no action on delete no action;


alter table item add constraint usuario_alta_3_fkey foreign key (usuario_alta)
references linea_base (usuario_alta) match simple
on update no action on delete no action;