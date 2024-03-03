



INSERT INTO `alumno` ( `telefono`, `apellido`, `nombre`, `email`) VALUES ( '623260769', 'lopez', 'john', 'lopezcon1@hotmail.com');
INSERT INTO `alumno` ( `telefono`, `apellido`, `nombre`, `email`) VALUES ('123456789', 'Pérez','Juan', 'juan.perez@example.com');
INSERT INTO `alumno` (`nombre`, `apellido`, `email`, `telefono`) VALUES ('Alejandro', 'Ramírez', 'alejandro.ramirez@example.com', '222222222');
INSERT INTO `alumno` (`nombre`, `apellido`, `email`, `telefono`) VALUES ('Pablo', 'Delgado', 'pablo.delgado@example.com', '999999999');
INSERT INTO `alumno` (`nombre`, `apellido`, `email`, `telefono`) VALUES ('Lorena', 'Reyes', 'lorena.reyes@example.com', '777777777');
INSERT INTO `alumno` (`nombre`, `apellido`, `email`, `telefono`) VALUES ('Roberto', 'Pérez', 'roberto.perez@example.com', '888888888');
INSERT INTO `alumno` (`nombre`, `apellido`, `email`, `telefono`) VALUES ('Elena', 'Gallardo', 'elena.gallardo@example.com', '555555555');


INSERT INTO `profesor` (`nombre`, `apellido`, `email`) VALUES ('Alejandro', 'Gómez', 'alejandro.gomez@example.com');
INSERT INTO `profesor` (`nombre`, `apellido`, `email`) VALUES ('Beatriz', 'López', 'beatriz.lopez@example.com');
INSERT INTO `profesor` (`nombre`, `apellido`, `email`) VALUES ('Carlos', 'Martínez', 'carlos.martinez@example.com');
INSERT INTO `profesor` (`nombre`, `apellido`, `email`) VALUES ('Diana', 'Fernández', 'diana.fernandez@example.com');
INSERT INTO `profesor` (`nombre`, `apellido`, `email`) VALUES ('Eduardo', 'García', 'eduardo.garcia@example.com');
INSERT INTO `profesor` (`nombre`, `apellido`, `email`) VALUES ('Fabiola', 'Hernández', 'fabiola.hernandez@example.com');
INSERT INTO `profesor` (`nombre`, `apellido`, `email`) VALUES ('Gabriel', 'Jiménez', 'gabriel.jimenez@example.com');
INSERT INTO `profesor` (`nombre`, `apellido`, `email`) VALUES ('Hilda', 'Ramírez', 'hilda.ramirez@example.com');
INSERT INTO `profesor` (`nombre`, `apellido`, `email`) VALUES ('Iván', 'Sánchez', 'ivan.sanchez@example.com');
INSERT INTO `profesor` (`nombre`, `apellido`, `email`) VALUES ('Jessica', 'Torres', 'jessica.torres@example.com');


INSERT INTO `asignatura` (`nombre`, `curso`, `ciclo`) VALUES ('Procesos', '2023/2024', '2º DAM');
INSERT INTO `asignatura` (`nombre`, `curso`, `ciclo`) VALUES ('Multimedia', '2023/2024', '2º DAM');
INSERT INTO `asignatura` (`nombre`, `curso`, `ciclo`) VALUES ('Acceso a Datos', '2023/2024', '2º DAM');
INSERT INTO `asignatura` (`nombre`, `curso`, `ciclo`) VALUES ('Empresa', '2023/2024', '2º DAM');
INSERT INTO `asignatura` (`nombre`, `curso`, `ciclo`) VALUES ('Libre Configuración', '2023/2024', '2º DAM');
INSERT INTO `asignatura` (`nombre`, `curso`, `ciclo`) VALUES ('SGE', '2023/2024', '2º DAM');
INSERT INTO `asignatura` (`nombre`, `curso`, `ciclo`) VALUES ('Interface', '2023/2024', '2º DAM');
INSERT INTO `asignatura` (`nombre`, `curso`, `ciclo`) VALUES ('Programación', '2023/2024', '2º DAM');




INSERT INTO `rol` (`id`, `nombre`) VALUES (1,'gestor');
INSERT INTO `rol` (`id`, `nombre`) VALUES (2,'alumno');
INSERT INTO `rol` (`id`, `nombre`) VALUES (3,'profesor');


INSERT INTO `user`(`enabled`, `rol_id`, `alumno_id`, `profesor_id`, `password`, `username`)  VALUES (1,1,null,null,'1234','john');
INSERT INTO `user`(`enabled`, `rol_id`, `alumno_id`, `profesor_id`, `password`, `username`)  VALUES (1,2,1,null,'1234','john');
INSERT INTO `user`(`enabled`, `rol_id`, `alumno_id`, `profesor_id`, `password`, `username`)  VALUES (1,2,2,null,'1234','juan');
INSERT INTO `user`(`enabled`, `rol_id`, `alumno_id`, `profesor_id`, `password`, `username`)  VALUES (1,2,3,null,'1234','alejandro');
INSERT INTO `user`(`enabled`, `rol_id`, `alumno_id`, `profesor_id`, `password`, `username`)  VALUES (1,2,4,null,'1234','pablo');
INSERT INTO `user`(`enabled`, `rol_id`, `alumno_id`, `profesor_id`, `password`, `username`)  VALUES (1,2,5,null,'1234','lorena');
INSERT INTO `user`(`enabled`, `rol_id`, `alumno_id`, `profesor_id`, `password`, `username`)  VALUES (1,2,6,null,'1234','roberto');
INSERT INTO `user`(`enabled`, `rol_id`, `alumno_id`, `profesor_id`, `password`, `username`)  VALUES (1,2,7,null,'1234','elena');

INSERT INTO `user`(`enabled`, `rol_id`, `alumno_id`, `profesor_id`, `password`, `username`)  VALUES (1,3,null,1,'1234','alejandro');
INSERT INTO `user`(`enabled`, `rol_id`, `alumno_id`, `profesor_id`, `password`, `username`)  VALUES (1,3,null,2,'1234','beatriz');
INSERT INTO `user`(`enabled`, `rol_id`, `alumno_id`, `profesor_id`, `password`, `username`)  VALUES (1,3,null,3,'1234','carlos');
INSERT INTO `user`(`enabled`, `rol_id`, `alumno_id`, `profesor_id`, `password`, `username`)  VALUES (1,3,null,4,'1234','diana');
INSERT INTO `user`(`enabled`, `rol_id`, `alumno_id`, `profesor_id`, `password`, `username`)  VALUES (1,3,null,5,'1234','eduardo');
INSERT INTO `user`(`enabled`, `rol_id`, `alumno_id`, `profesor_id`, `password`, `username`)  VALUES (1,3,null,6,'1234','fabiola');
INSERT INTO `user`(`enabled`, `rol_id`, `alumno_id`, `profesor_id`, `password`, `username`)  VALUES (1,3,null,7,'1234','gabriel');
INSERT INTO `user`(`enabled`, `rol_id`, `alumno_id`, `profesor_id`, `password`, `username`)  VALUES (1,3,null,8,'1234','hilda');
INSERT INTO `user`(`enabled`, `rol_id`, `alumno_id`, `profesor_id`, `password`, `username`)  VALUES (1,3,null,9,'1234','iván');
INSERT INTO `user`(`enabled`, `rol_id`, `alumno_id`, `profesor_id`, `password`, `username`)  VALUES (1,3,null,10,'1234','jessica');






INSERT INTO `matricula_alumno`(`asignatura_id`,`alumno_id`)  VALUES (1,2);
INSERT INTO `matricula_alumno`(`asignatura_id`,`alumno_id`)  VALUES (2,2);
INSERT INTO `matricula_alumno`(`asignatura_id`,`alumno_id`)  VALUES (3,2);
INSERT INTO `matricula_alumno`(`asignatura_id`,`alumno_id`) VALUES (2,3);
INSERT INTO `matricula_alumno`(`asignatura_id`,`alumno_id`) VALUES (4,4);
INSERT INTO `matricula_alumno`(`asignatura_id`,`alumno_id`) VALUES (2,5);



INSERT INTO `matricula_profesor`(`asignatura_id`,`profesor_id`) VALUES (1,1)
INSERT INTO `matricula_profesor`(`asignatura_id`,`profesor_id`) VALUES (2,2);
INSERT INTO `matricula_profesor`(`asignatura_id`,`profesor_id`) VALUES (3,3);
INSERT INTO `matricula_profesor`(`asignatura_id`,`profesor_id`) VALUES (1,4);
