package com.example.john.gestion_centro_educativo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.john.gestion_centro_educativo.modelos.Rol;

public interface RepoRol extends JpaRepository<Rol, Integer> {
    
}
