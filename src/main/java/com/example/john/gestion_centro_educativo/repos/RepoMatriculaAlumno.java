package com.example.john.gestion_centro_educativo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.john.gestion_centro_educativo.modelos.MatriculaAlumno;

public interface RepoMatriculaAlumno extends JpaRepository<MatriculaAlumno, Integer> {
    @Query("SELECT a.id AS alumnoId, a.nombre AS nombreAlumno, a.apellido AS apellidoAlumno, " +
           "a.email AS emailAlumno, a.telefono AS telefonoAlumno, m.asignatura.id AS asignaturaId, " +
           "m.asignatura.nombre AS nombreAsignatura, m.asignatura.curso AS cursoAsignatura, " +
           "m.asignatura.ciclo AS cicloAsignatura " +
           "FROM MatriculaAlumno m JOIN m.alumno a JOIN m.asignatura")
    List<Object[]> obtenerAlumnosMatriculados();
    
}
