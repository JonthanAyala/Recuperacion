create database ayala;
use ayala;

create table users(
	id_user int primary key auto_increment,
    role varchar(12),
    name varchar(100),
    lastname varchar(100),
    mail varchar(100),
    pass varchar(100)
);
-- (título, descripción tipo de incidencia(Justificación de Falta o Retardo) y estado), 

create table incidencias (
	id int primary key auto_increment,
    titulo varchar(100),
    titulo varchar(100),
    descripcion varchar(255),
    tipo varchar(100),
    estado varchar(30),
    mensaje varchar(255),
    fk_user int,
    FOREIGN KEY (fk_user) REFERENCES users (id_user)
);

INSERT INTO `ayala`.`users` (`id_user`, `role`, `name`, `lastname`, `mail`, `pass`) VALUES ('0', 'ADMIN_ROLE', 'admin', 'admin', 'admin@a', 'admin');
INSERT INTO `ayala`.`users` (`id_user`, `role`, `name`, `lastname`, `mail`, `pass`) VALUES ('0', 'CHARGE_ROLE', 'Jonathan', 'Ayala', 'ayala@a', 'ayala');
INSERT INTO `ayala`.`users` (`id_user`, `role`, `name`, `lastname`, `mail`, `pass`) VALUES ('0', 'USER_ROLE', 'Juan', 'Si', 'juan@a', 'juan');

INSERT INTO `ayala`.`incidencias` (`id`, `titulo`, `descripcion`, `tipo`, `estado`, `mensaje`, `fk_user`) VALUES ('0', 'a', 'a', 'a', 'Aceptada', 'a', '3');
INSERT INTO `ayala`.`incidencias` (`id`, `titulo`, `descripcion`, `tipo`, `estado`, `mensaje`, `fk_user`) VALUES ('0', 'b', 'b', 'b', 'Aceptada', 'b', '3');
INSERT INTO `ayala`.`incidencias` (`id`, `titulo`, `descripcion`, `tipo`, `estado`, `mensaje`, `fk_user`) VALUES ('0', 'c', 'c', 'c', 'Pendiente', 'c', '3');
