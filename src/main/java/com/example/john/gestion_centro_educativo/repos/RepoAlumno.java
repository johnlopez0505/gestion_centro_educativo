package com.example.john.gestion_centro_educativo.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.john.gestion_centro_educativo.modelos.Alumno;

public interface RepoAlumno extends JpaRepository<Alumno,Integer>{
    Optional<Alumno> finByUsuario(String usuario);
}
