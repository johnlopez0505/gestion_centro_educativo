package com.example.john.gestion_centro_educativo.repos;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.john.gestion_centro_educativo.modelos.MatriculaAlumno;

public interface RepoMatriculaAlumno extends JpaRepository<MatriculaAlumno, Integer> { 
    @Query("SELECT ma.asignatura FROM MatriculaAlumno ma WHERE ma.alumno.id = :idAlumno")
    List<Object[]> obtenerAsignaturasPorAlumno(@Param("idAlumno") Integer idAlumno);

    // @Query("SELECT a.nombre " + 
    //     "FROM Asignatura a " + 
    //     "JOIN MatriculaAlumno ON a.id = MatriculaAlumno.a.id " + 
    //     "JOIN Alumno ON MatriculaAlumno.alumno.id = Alumno.id " + 
    //     "WHERE Alumno.id = :alumnoId")
    //     List<Object[]> findAsignaturasByAlumnoId(@Param("alumnoId") int alumnoId);

    //List<MatriculaAlumno> findUserByName(Long alumno);

}
