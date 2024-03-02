package com.example.john.gestion_centro_educativo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.john.gestion_centro_educativo.modelos.Alumno;

public interface RepoAlumno extends JpaRepository<Alumno,Integer>{
    
}
