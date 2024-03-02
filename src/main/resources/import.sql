
INSERT INTO `rol` (`id`, `nombre`) VALUES (1,'gestor');
INSERT INTO `rol` (`id`, `nombre`) VALUES (2,'alumno');
INSERT INTO `rol` (`id`, `nombre`) VALUES (3,'profesor');


INSERT INTO `user`(`enabled`, `rol_id`, `password`, `username`)  VALUES (1,2,'1234','juan');
INSERT INTO `user`(`enabled`, `rol_id`, `password`, `username`)  VALUES (1,2,'1234','alejandro');
INSERT INTO `user`(`enabled`, `rol_id`, `password`, `username`)  VALUES (1,2,'1234','pablo');
INSERT INTO `user`(`enabled`, `rol_id`, `password`, `username`)  VALUES (1,2,'1234','lorena');
INSERT INTO `user`(`enabled`, `rol_id`, `password`, `username`)  VALUES (1,2,'1234','roberto');
INSERT INTO `user`(`enabled`, `rol_id`, `password`, `username`)  VALUES (1,2,'1234','elena');

INSERT INTO `user`(`enabled`, `rol_id`, `password`, `username`)  VALUES (1,3,'1234','alejandro');
INSERT INTO `user`(`enabled`, `rol_id`, `password`, `username`)  VALUES (1,3,'1234','beatriz');
INSERT INTO `user`(`enabled`, `rol_id`, `password`, `username`)  VALUES (1,3,'1234','carlos');
INSERT INTO `user`(`enabled`, `rol_id`, `password`, `username`)  VALUES (1,3,'1234','diana');
INSERT INTO `user`(`enabled`, `rol_id`, `password`, `username`)  VALUES (1,3,'1234','eduardo');
INSERT INTO `user`(`enabled`, `rol_id`, `password`, `username`)  VALUES (1,3,'1234','fabiola');
INSERT INTO `user`(`enabled`, `rol_id`, `password`, `username`)  VALUES (1,3,'1234','gabriel');
INSERT INTO `user`(`enabled`, `rol_id`, `password`, `username`)  VALUES (1,3,'1234','hilda');
INSERT INTO `user`(`enabled`, `rol_id`, `password`, `username`)  VALUES (1,3,'1234','iván');
INSERT INTO `user`(`enabled`, `rol_id`, `password`, `username`)  VALUES (1,3,'1234','jessica');



INSERT INTO `rol_usuarios` (`rol_id`, `usuarios_id`) VALUES ('1', '1');
INSERT INTO `rol_usuarios` (`rol_id`, `usuarios_id`) VALUES ('2', '2');
INSERT INTO `rol_usuarios` (`rol_id`, `usuarios_id`) VALUES ('2', '3');
INSERT INTO `rol_usuarios` (`rol_id`, `usuarios_id`) VALUES ('2', '4');
INSERT INTO `rol_usuarios` (`rol_id`, `usuarios_id`) VALUES ('2', '5');
INSERT INTO `rol_usuarios` (`rol_id`, `usuarios_id`) VALUES ('2', '6');
INSERT INTO `rol_usuarios` (`rol_id`, `usuarios_id`) VALUES ('2', '7');
INSERT INTO `rol_usuarios` (`rol_id`, `usuarios_id`) VALUES ('3', '8');
INSERT INTO `rol_usuarios` (`rol_id`, `usuarios_id`) VALUES ('3', '9');
INSERT INTO `rol_usuarios` (`rol_id`, `usuarios_id`) VALUES ('3', '10');
INSERT INTO `rol_usuarios` (`rol_id`, `usuarios_id`) VALUES ('3', '11');
INSERT INTO `rol_usuarios` (`rol_id`, `usuarios_id`) VALUES ('3', '12');
INSERT INTO `rol_usuarios` (`rol_id`, `usuarios_id`) VALUES ('3', '13');
INSERT INTO `rol_usuarios` (`rol_id`, `usuarios_id`) VALUES ('3', '14');
INSERT INTO `rol_usuarios` (`rol_id`, `usuarios_id`) VALUES ('3', '15');
INSERT INTO `rol_usuarios` (`rol_id`, `usuarios_id`) VALUES ('3', '16');
INSERT INTO `rol_usuarios` (`rol_id`, `usuarios_id`) VALUES ('3', '17');



INSERT INTO `alumno` (`usuario_id`, `telefono`, `apellido`, `nombre`, `email`) VALUES (1, '623260769', 'lopez', 'john', 'lopezcon1@hotmail.com');
INSERT INTO `alumno` (`usuario_id`, `telefono`, `apellido`, `nombre`, `email`) VALUES (2,'123456789', 'Pérez','Juan', 'juan.perez@example.com');
INSERT INTO `alumno` (`usuario_id`,`nombre`, `apellido`, `email`, `telefono`) VALUES (3,'Alejandro', 'Ramírez', 'alejandro.ramirez@example.com', '222222222');
INSERT INTO `alumno` (`usuario_id`,`nombre`, `apellido`, `email`, `telefono`) VALUES (4,'Pablo', 'Delgado', 'pablo.delgado@example.com', '999999999');
INSERT INTO `alumno` (`usuario_id`,`nombre`, `apellido`, `email`, `telefono`) VALUES (5,'Lorena', 'Reyes', 'lorena.reyes@example.com', '777777777');
INSERT INTO `alumno` (`usuario_id`,`nombre`, `apellido`, `email`, `telefono`) VALUES (6,'Roberto', 'Pérez', 'roberto.perez@example.com', '888888888');
INSERT INTO `alumno` (`usuario_id`,`nombre`, `apellido`, `email`, `telefono`) VALUES (7,'Elena', 'Gallardo', 'elena.gallardo@example.com', '555555555');


INSERT INTO `profesor` (`usuario_id`,`nombre`, `apellido`, `email`) VALUES (8,'Alejandro', 'Gómez', 'alejandro.gomez@example.com');
INSERT INTO `profesor` (`usuario_id`,`nombre`, `apellido`, `email`) VALUES (9,'Beatriz', 'López', 'beatriz.lopez@example.com');
INSERT INTO `profesor` (`usuario_id`,`nombre`, `apellido`, `email`) VALUES (10,'Carlos', 'Martínez', 'carlos.martinez@example.com');
INSERT INTO `profesor` (`usuario_id`,`nombre`, `apellido`, `email`) VALUES (11,'Diana', 'Fernández', 'diana.fernandez@example.com');
INSERT INTO `profesor` (`usuario_id`,`nombre`, `apellido`, `email`) VALUES (12,'Eduardo', 'García', 'eduardo.garcia@example.com');
INSERT INTO `profesor` (`usuario_id`,`nombre`, `apellido`, `email`) VALUES (13,'Fabiola', 'Hernández', 'fabiola.hernandez@example.com');
INSERT INTO `profesor` (`usuario_id`,`nombre`, `apellido`, `email`) VALUES (14,'Gabriel', 'Jiménez', 'gabriel.jimenez@example.com');
INSERT INTO `profesor` (`usuario_id`,`nombre`, `apellido`, `email`) VALUES (15,'Hilda', 'Ramírez', 'hilda.ramirez@example.com');
INSERT INTO `profesor` (`usuario_id`,`nombre`, `apellido`, `email`) VALUES (16,'Iván', 'Sánchez', 'ivan.sanchez@example.com');
INSERT INTO `profesor` (`usuario_id`,`nombre`, `apellido`, `email`) VALUES (17,'Jessica', 'Torres', 'jessica.torres@example.com');


INSERT INTO `asignatura` (`nombre`, `curso`, `ciclo`) VALUES ('Procesos', '2023/2024', '2º DAM');
INSERT INTO `asignatura` (`nombre`, `curso`, `ciclo`) VALUES ('Multimedia', '2023/2024', '2º DAM');
INSERT INTO `asignatura` (`nombre`, `curso`, `ciclo`) VALUES ('Acceso a Datos', '2023/2024', '2º DAM');
INSERT INTO `asignatura` (`nombre`, `curso`, `ciclo`) VALUES ('Empresa', '2023/2024', '2º DAM');
INSERT INTO `asignatura` (`nombre`, `curso`, `ciclo`) VALUES ('Libre Configuración', '2023/2024', '2º DAM');
INSERT INTO `asignatura` (`nombre`, `curso`, `ciclo`) VALUES ('SGE', '2023/2024', '2º DAM');
INSERT INTO `asignatura` (`nombre`, `curso`, `ciclo`) VALUES ('Interface', '2023/2024', '2º DAM');
INSERT INTO `asignatura` (`nombre`, `curso`, `ciclo`) VALUES ('Programación', '2023/2024', '2º DAM');



INSERT INTO `matricula_alumno`(`asignatura_id`,`alumno_id`)  VALUES (1,2);
INSERT INTO `matricula_alumno`(`asignatura_id`,`alumno_id`) VALUES (2,3);
INSERT INTO `matricula_alumno`(`asignatura_id`,`alumno_id`) VALUES (4,4);
INSERT INTO `matricula_alumno`(`asignatura_id`,`alumno_id`) VALUES (2,5);



INSERT INTO `matricula_profesor`(`asignatura_id`,`profesor_id`) VALUES (1,1)
INSERT INTO `matricula_profesor`(`asignatura_id`,`profesor_id`) VALUES (2,2);
INSERT INTO `matricula_profesor`(`asignatura_id`,`profesor_id`) VALUES (3,3);
INSERT INTO `matricula_profesor`(`asignatura_id`,`profesor_id`) VALUES (1,4);
